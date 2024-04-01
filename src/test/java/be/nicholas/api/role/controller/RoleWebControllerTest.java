package be.nicholas.api.role.controller;

import be.nicholas.api.host.service.HostService;
import be.nicholas.api.role.resource.out.RoleInfoResponseResource;
import be.nicholas.api.role.resource.out.RoleResponseResource;
import be.nicholas.api.role.web.in.RoleWebController;
import be.nicholas.api.role.web.out.RoleClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(RoleWebController.class)
@ComponentScan(basePackages = {"be.nicholas.api.role"})
public class RoleWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleClient client;

    @MockBean
    private HostService hostService;

    @Test
    public void getRole() throws Exception {
        List<Map<String, Object>> serviceInfo = new ArrayList<>();
        serviceInfo.add(Map.of("foo", "bar"));
        RoleInfoResponseResource roleInfoResponseResource = new RoleInfoResponseResource();
        roleInfoResponseResource.setServiceInfo(serviceInfo);

        RoleResponseResource roleResponseResource = new RoleResponseResource();
        roleResponseResource.setOperationList(roleInfoResponseResource);

        URI uri = new URI("https://test.be");
        Mockito.when(hostService.getHost("QMGAG8BEQSY003476", "fal")).thenReturn(uri);
        Mockito.when(client.getRoles(uri, "QMGAG8BEQSY003476")).thenReturn(roleResponseResource);
        String response = """
                {"services":[{"foo":"bar"}]}""";

        mockMvc.perform(get("/role/QMGAG8BEQSY003476")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json(response, true));
    }
}
