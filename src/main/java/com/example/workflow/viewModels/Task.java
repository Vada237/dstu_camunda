package com.example.workflow.viewModels;

public class Task {
    private int id;
    private String title;
    private String startTime;
    private String finishTime;
    private int countHours;
    private String status;

    public Task(int id, String title, String startTime, String finishTime, int countHours, String status) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.countHours = countHours;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public int getCountHours() {
        return countHours;
    }

    public void setCountHours(int countHours) {
        this.countHours = countHours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
