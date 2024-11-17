package com.example.workflow.clients;

import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;
import org.camunda.connect.httpclient.HttpResponse;
import org.camunda.connect.httpclient.soap.SoapHttpConnector;

public class RestWebServiceClient {
    public static void main(String[] args) {
        HttpConnector connector = Connectors.getConnector(HttpConnector.ID);

        HttpResponse response = connector.createRequest().get().url("http://localhost:8081/api/reports/info/1").execute();

        String body = response.getResponse();
        System.out.println(1);
    }
}
