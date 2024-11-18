package com.example.workflow;

import com.example.workflow.clients.ProjectWebServiceClient;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CreateProject implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProjectWebServiceClient client = new ProjectWebServiceClient();

        String title = (String) delegateExecution.getVariable("title");
        String startTime = (String) delegateExecution.getVariable("startTime");
        String finishTime = (String) delegateExecution.getVariable("finishTime");
        int totalHours = (Integer) delegateExecution.getVariable("totalHours");

        if (title == null || startTime == null || finishTime == null) {
            throw new BpmnError("CreateProjectError");
        }

        client.createProject(title, startTime, finishTime, totalHours);
    }
}
