package com.example.workflow;

import com.example.workflow.clients.UserWebServiceClient;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateUser implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        UserWebServiceClient soapWebServiceClient = new UserWebServiceClient();

        String firstName = (String) delegateExecution.getVariable("first_name");
        String secondName = (String) delegateExecution.getVariable("second_name");

        if (firstName == null && secondName == null) {
            throw new BpmnError("createUserError");
        }

        soapWebServiceClient.createUser(firstName, secondName);
        delegateExecution.setVariable("firstName", firstName);
        delegateExecution.setVariable("secondName", firstName);

    }
}
