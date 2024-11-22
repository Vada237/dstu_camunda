package com.example.workflow.viewModels;

public class Task {
    private int id;
    private String title;
    private String startTime;
    private String finishTime;
    private String countHours;

    public Task(int id, String title, String startTime, String finishTime, String countHours) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.countHours = countHours;
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

    public String getCountHours() {
        return countHours;
    }

    public void setCountHours(String countHours) {
        this.countHours = countHours;
    }
}
