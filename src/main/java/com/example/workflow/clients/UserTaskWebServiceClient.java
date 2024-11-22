package com.example.workflow.clients;

public class UserTaskWebServiceClient extends SoapWebServiceClient{

    public UserTaskWebServiceClient() {
        super("http://localhost:8012/wss/userTask", "http://userTask.services.example.org/");
    }

    public void addTime(int taskId, int userId, int time, int progress, String createdAt) throws Exception {
        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" x" +
                "mlns:user=\""+ this.artifact +"\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <user:trackTime>\n" +
                "         <arg0>"+taskId+"</arg0>\n" +
                "         <arg1>"+userId+"</arg1>\n" +
                "         <arg2>"+time+"</arg2>\n" +
                "         <arg3>"+progress+"</arg3>\n" +
                "         <arg4>"+createdAt+"</arg4>\n" +
                "      </user:trackTime>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        this.send(this.url, "trackTime", payload);
    }
}
