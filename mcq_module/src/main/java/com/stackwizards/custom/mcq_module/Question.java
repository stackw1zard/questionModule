package com.stackwizards.custom.mcq_module;

import java.util.ArrayList;

/*  This class will hold the questions and respective answers, once the downloaded json files are parsed
    The numOfTimesAnsweredCorrectly will be used to sort, so as those answered correctly are less frequently asked
    As the question used, were collected using web scrapping, most of them do not have hints
 */
public class Question extends QuestionStatistic {

    private String question_text;
    private String answer;
    private String hint;
    private ArrayList<String> answer_options;

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public ArrayList<String> getAnswer_options() {
        return answer_options;
    }

    public void setAnswer_options(ArrayList<String> answer_options) {
        this.answer_options = answer_options;
    }
}
