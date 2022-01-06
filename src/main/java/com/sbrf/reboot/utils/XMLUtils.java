package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class XMLUtils {
    //объект Jackson, который выполняет сериализацию
    private static final XmlMapper mapper = new XmlMapper();

    public static String toXML(Request request) throws JsonProcessingException {
        return mapper.writeValueAsString(request);
    }

    public static String toXML(Response response) throws JsonProcessingException{
        return mapper.writeValueAsString(response);
    }

    public static Request XMLtoRequest(String json) throws JsonProcessingException{
        return mapper.readValue(json, Request.class);
    }

    public static Response XMLtoResponse(String json) throws JsonProcessingException{
        return mapper.readValue(json, Response.class);
    }
}
