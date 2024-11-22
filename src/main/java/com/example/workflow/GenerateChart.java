package com.example.workflow;

import com.example.workflow.clients.ChartWebServiceClient;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

@Component
public class GenerateChart implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ChartWebServiceClient client = new ChartWebServiceClient();
        int projectId = (int) delegateExecution.getVariable("projectId");

        String filepath = client.getBurndownChart(projectId);
        File file = new File(filepath);

        try (FileInputStream fis = new FileInputStream(file)){
            fis.readAllBytes();
        } catch (Exception e) {
            throw new BpmnError("GenerateChartError");
        }
    }
}
