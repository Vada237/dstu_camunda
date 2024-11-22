package com.example.workflow.clients;

import com.example.workflow.parsers.TaskParser;
import com.example.workflow.viewModels.Task;

public class TaskWebServiceClient extends SoapWebServiceClient {

    public TaskWebServiceClient() {
        super("http://localhost:8011/wss/task", "http://task.services.example.org/");
    }

    public void createTask(int totalHours, int userId, int projectId, String title, String startTime, String finishTime) throws Exception {
        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:task=\"" + this.artifact + "\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <task:addTask>\n" +
                "         <arg0>            \n" +
                "            <finishTime>" + finishTime + "</finishTime>\n" +
                "            <projectId>" + projectId + "</projectId>\n" +
                "            <startTime>" + startTime + "</startTime>\n" +
                "            <title>" + title + "</title>\n" +
                "            <userId>" + userId + "</userId>\n" +
                "            <countHours>" + totalHours + "</countHours>\n" +
                "         </arg0>\n" +
                "      </task:addTask>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        this.send(this.url, "addTask", payload);
    }

    public Task[] getAll() throws Exception {
        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:task=\"" + this.artifact + "\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <task:getAll/>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String response = this.send(this.url, "getAll", payload);
        return TaskParser.getTasks(response);
    }

    public static void main (String[] args) {

    }
}
