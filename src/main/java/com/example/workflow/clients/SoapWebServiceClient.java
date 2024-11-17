package com.example.workflow.clients;

import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.soap.SoapHttpConnector;
import org.camunda.connect.httpclient.soap.SoapHttpResponse;

public class SoapWebServiceClient {
    public static void main(String[] args) {
        SoapHttpConnector soap = Connectors.getConnector(SoapHttpConnector.ID);
        String envelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:user=\"http://user.services.example.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <user:getUserById>\n" +
                "         <arg0>1</arg0>\n" +
                "      </user:getUserById>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        SoapHttpResponse response = soap.createRequest()
                .url("http://localhost:8010/wss/user")
                .soapAction("getUserById")
                .payload(envelope)
                .execute();

        Integer statusCode = response.getStatusCode();
        String contentTypeHeader = response.getHeader("Content-Type");
        String body = response.getResponse();
        System.out.println(1);
    }
}
