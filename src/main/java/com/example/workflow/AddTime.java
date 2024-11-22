package com.example.workflow;

import com.example.workflow.clients.UserTaskWebServiceClient;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AddTime implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        UserTaskWebServiceClient client = new UserTaskWebServiceClient();

        try {
            int taskId = (int) delegateExecution.getVariable("taskId");
            int userId = (int) delegateExecution.getVariable("userId");
            int time = (int) delegateExecution.getVariable("time");
            int progress = (int) delegateExecution.getVariable("progress");
            String createdAt = (String) delegateExecution.getVariable("createdAt");
            client.addTime(taskId, userId, time, progress, createdAt);
        } catch (Exception e) {
            throw new BpmnError("AddTimeError");
        }
    }
}
