package com.example.workflow.clients;



import java.sql.Timestamp;

public class ProjectWebServiceClient extends SoapWebServiceClient{
    public ProjectWebServiceClient() {
        super("http://localhost:8013/wss/project", "http://project.services.example.org");
    }

    public void createProject(String title, String startTime, String finishTime, int totalHours) throws Exception {
        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:proj=\"http://project.services.example.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <proj:addProject>\n" +
                "         <arg0>\n" +
                "            <finishTime>" + finishTime + "</finishTime>           \n" +
                "            <startTime>" + startTime + "</startTime>\n" +
                "            <title>" + title + "</title>\n" +
                "            <totalHours>" + totalHours + "</totalHours>\n" +
                "         </arg0>\n" +
                "      </proj:addProject>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        this.send(this.url, "addProject", payload);
    }
}
