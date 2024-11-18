package com.example.workflow.clients;

import jakarta.xml.soap.*;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserWebServiceClient extends SoapWebServiceClient{
    public UserWebServiceClient() {
        super("http://localhost:8010/wss/user", "http://user.services.example.org/");
    }

    public void createUser(String firstName, String secondName) throws Exception {
        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:user=\"" + this.artifact + "\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <user:createUser>\n" +
                "         <arg0>\n" +
                "            <!--Optional:-->\n" +
                "            <firstName>" + firstName + "</firstName>\n" +
                "            <!--Optional:-->\n" +
                "            <secondName>" + secondName + "</secondName>\n" +
                "         </arg0>\n" +
                "      </user:createUser>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        this.send(this.url, "createUser", payload);
    }

    public void getUserById(int id) throws Exception {
        String envelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:user=\"" + this.artifact+ "\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <user:getUserById>\n" +
                "         <arg0>" + id + "</arg0>\n" +
                "      </user:getUserById>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String response = this.send(this.url, "getUserById", envelope);
    }
}