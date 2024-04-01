package be.nicholas.api.ventilator.web.out;

import be.nicholas.api.core.auth.pin.PinLogin;
import be.nicholas.api.host.service.HostService;
import be.nicholas.api.ventilator.domain.Ventilator;
import be.nicholas.api.ventilator.resource.out.*;
import be.nicholas.api.ventilator.service.VentilatorClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Service
public class VentilatorClientServiceImpl implements VentilatorClientService {

    private static final String MODE = "mal";
    private final VentilatorClient client;
    private final HostService hostService;
    private final PinLogin pinLogin;


    @Override
    public Ventilator startVentilator(Ventilator ventilator) {
        log.info("start ventilator for vin {} with duration {}", ventilator.vin(), ventilator.duration());
        URI uri = hostService.getHost(ventilator.vin(), MODE);

        QuickstartRequestResource quickstartRequest = new QuickstartRequestResource();
        quickstartRequest.setActive(true);
        quickstartRequest.setClimatisationDuration(ventilator.duration());

        PerformActionRequestResource performActionRequest = new PerformActionRequestResource();
        performActionRequest.setQuickstart(quickstartRequest);

        VentilatorRequestResource request = new VentilatorRequestResource();
        request.setPerformAction(performActionRequest);

        VentilatorResponseResource response = client.startVentilator(uri, ventilator.vin(), pinLogin.doPinLogin(ventilator.vin(), ventilator.pin()), request);
        return new Ventilator(ventilator.vin(), null, ventilator.duration(), response.getPerformActionResponse().getRequestId());
    }

    @Override
    public Ventilator stopVentilator(Ventilator ventilator) {
        log.info("stop ventilator for vin {}", ventilator.vin());
        URI uri = hostService.getHost(ventilator.vin(), MODE);

        QuickstopRequestResource quickstopRequest = new QuickstopRequestResource();
        quickstopRequest.setActive(false);

        PerformActionRequestResource performActionRequest = new PerformActionRequestResource();
        performActionRequest.setQuickstop(quickstopRequest);

        VentilatorRequestResource request = new VentilatorRequestResource();
        request.setPerformAction(performActionRequest);
        VentilatorResponseResource response = client.stopVentilator(uri, ventilator.vin(), request);
        return new Ventilator(ventilator.vin(), null, 0, response.getPerformActionResponse().getRequestId());
    }
}
