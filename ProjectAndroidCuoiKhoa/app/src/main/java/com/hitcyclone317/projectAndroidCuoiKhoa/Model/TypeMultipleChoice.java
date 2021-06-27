package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

public class TypeMultipleChoice {
    String Question;
    String CauA, CauB, CauC, CauD;
    int Answer;

    public TypeMultipleChoice() {

    }
    public TypeMultipleChoice(String question, String cauA, String cauB, String cauC, String cauD, int answer) {
        Question = question;
        CauA = cauA;
        CauB = cauB;
        CauC = cauC;
        CauD = cauD;
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getCauA() {
        return CauA;
    }

    public void setCauA(String cauA) {
        CauA = cauA;
    }

    public String getCauB() {
        return CauB;
    }

    public void setCauB(String cauB) {
        CauB = cauB;
    }

    public String getCauC() {
        return CauC;
    }

    public void setCauC(String cauC) {
        CauC = cauC;
    }

    public String getCauD() {
        return CauD;
    }

    public void setCauD(String cauD) {
        CauD = cauD;
    }

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }
}
