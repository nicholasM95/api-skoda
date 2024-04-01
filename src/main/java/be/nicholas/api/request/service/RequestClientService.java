package be.nicholas.api.request.service;

import be.nicholas.api.request.domain.Request;

public interface RequestClientService {

    Request getRequestInfoByVinAndId(String vin, String id);
}
