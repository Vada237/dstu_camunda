package com.example.workflow;

import com.example.workflow.clients.TaskWebServiceClient;
import com.example.workflow.viewModels.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class GetAllTasks implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        TaskWebServiceClient client = new TaskWebServiceClient();
        Task[] tasks = client.getAll();

        if (tasks.length == 0) {
            throw new BpmnError("TasksNotFound");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(tasks);

        delegateExecution.setVariable("tasks", jsonString);
    }
}
