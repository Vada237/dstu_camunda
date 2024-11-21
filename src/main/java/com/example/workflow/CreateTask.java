package com.example.workflow;

import com.example.workflow.clients.TaskWebServiceClient;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateTask implements JavaDelegate{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        TaskWebServiceClient client = new TaskWebServiceClient();

        try {
            String taskTitle = (String) delegateExecution.getVariable("title");
            String startTime = (String) delegateExecution.getVariable("startTime");
            String finishTime = (String) delegateExecution.getVariable("finishTime");
            int userId = (Integer) delegateExecution.getVariable("userId");
            int projectId = (Integer) delegateExecution.getVariable("projectId");

            client.createTask(userId, projectId, taskTitle, startTime, finishTime);
        } catch (Exception e) {
            throw new BpmnError("CreateTaskError");
        }
    }
}
