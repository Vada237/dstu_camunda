package com.example.workflow;

import com.example.workflow.clients.ProjectWebServiceClient;
import com.example.workflow.viewModels.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class GetAllProjects implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProjectWebServiceClient client = new ProjectWebServiceClient();
        Project[] projects = client.getProjects();
        if (projects.length == 0) {
            throw new BpmnError("ProjectsNotFound");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projects);
        delegateExecution.setVariable("projects", jsonString);
    }
}
