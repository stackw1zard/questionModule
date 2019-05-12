package com.stackwizards.custom.mcq_module;

public class QuestionStatistic {
    protected String uuid = null;
    protected int numOfTimesAsked = 0;
    protected int numOfTimesAnsweredCorrectly = 0;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getNumOfTimesAsked() {
        return numOfTimesAsked;
    }

    public void setNumOfTimesAsked(int numOfTimesAsked) {
        this.numOfTimesAsked = numOfTimesAsked;
    }

    public int getNumOfTimesAnsweredCorrectly() {
        return numOfTimesAnsweredCorrectly;
    }

    public void setNumOfTimesAnsweredCorrectly(int numOfTimesAnsweredCorrectly) {
        this.numOfTimesAnsweredCorrectly = numOfTimesAnsweredCorrectly;
    }
}
