package com.example.workflow;

import com.example.workflow.clients.UserWebServiceClient;
import com.example.workflow.viewModels.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class GetAllUsers implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        UserWebServiceClient client = new UserWebServiceClient();

        User[] users = client.getAllUsers();

        if (users.length == 0) {
            throw new BpmnError("UserNotFound");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(users);

        delegateExecution.setVariable("users", jsonString);
    }
}
