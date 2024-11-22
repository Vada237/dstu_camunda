package com.example.workflow.clients;

import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.soap.SoapHttpConnector;
import org.camunda.connect.httpclient.soap.SoapHttpResponse;

public abstract class SoapWebServiceClient {
    protected final SoapHttpConnector connector;
    protected final String url;
    protected final String artifact;

    public SoapWebServiceClient(String url, String artifact) {
        this.url = url;
        this.artifact = artifact;
        this.connector = Connectors.getConnector(SoapHttpConnector.ID);
    }

    public String send(String url, String action, String payload) throws Exception {
        SoapHttpResponse response = this.connector.createRequest().url(url).soapAction(action).payload(payload).execute();

        if (response.getStatusCode() == 200) {
            return response.getResponse();
        }

        throw new Exception("SOAP send request error");
    }
}
