package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

public class TypeFillInfo {
    String Question;
    String Answer;

    public TypeFillInfo() {
    }

    public TypeFillInfo(String question, String answer) {
        Question = question;
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

}
