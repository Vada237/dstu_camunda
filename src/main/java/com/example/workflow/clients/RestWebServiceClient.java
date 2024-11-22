package com.example.workflow.clients;

import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;
import org.camunda.connect.httpclient.HttpResponse;

public class RestWebServiceClient {
    private final HttpConnector connector;

    public RestWebServiceClient() {
        this.connector = Connectors.getConnector(HttpConnector.ID);;
    }

    public String sendRequest(String url) throws Exception {
        HttpResponse response = this.connector.createRequest().get().url(url).execute();

        if (response.getStatusCode() == 200) {
            return response.getResponse();
        }

        throw new Exception("REST send request error");
    }
}
