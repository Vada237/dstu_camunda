package com.example.workflow.clients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChartWebServiceClient extends RestWebServiceClient{
    public String getBurndownChart(int projectId) throws Exception {
        String response = this.sendRequest("http://localhost:8081/api/reports/burndown-chart/" + projectId);
        String filepath = System.getProperty("user.dir") + "/storage/burndown_for_project_id_" + projectId + ".png";
        File file = new File(filepath);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filepath;
    }
}
