package com.example.workflow.clients;


import com.example.workflow.parsers.UserParser;
import com.example.workflow.viewModels.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public User[] getAllUsers() throws Exception {
        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:user=\"" + this.artifact + "\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <user:getAll/>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String response = this.send(this.url, "getAll", payload);

        return UserParser.getUsers(response);
    }
}