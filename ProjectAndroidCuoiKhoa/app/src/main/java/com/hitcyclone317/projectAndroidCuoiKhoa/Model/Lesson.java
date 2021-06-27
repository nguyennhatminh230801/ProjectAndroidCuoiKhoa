package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

public class Lesson {
    int ResID;
    String LessonName;
    int NumOfTask;
    boolean TestOfLesson;
    StateOfStudy stateOfStudy;

    public Lesson() {
    }

    public Lesson(int resID, String lessonName, int numOfTask, boolean testOfLesson, StateOfStudy stateOfStudy) {
        ResID = resID;
        LessonName = lessonName;
        NumOfTask = numOfTask;
        TestOfLesson = testOfLesson;
        this.stateOfStudy = stateOfStudy;
    }

    public int getNumOfTask() {
        return NumOfTask;
    }

    public void setNumOfTask(int numOfTask) {
        NumOfTask = numOfTask;
    }

    public int getResID() {
        return ResID;
    }

    public void setResID(int resID) {
        ResID = resID;
    }

    public String getLessonName() {
        return LessonName;
    }

    public void setLessonName(String lessonName) {
        LessonName = lessonName;
    }

    public boolean isTestOfLesson() {
        return TestOfLesson;
    }

    public void setTestOfLesson(boolean testOfLesson) {
        TestOfLesson = testOfLesson;
    }

    public StateOfStudy getStateOfStudy() {
        return stateOfStudy;
    }

    public void setStateOfStudy(StateOfStudy stateOfStudy) {
        this.stateOfStudy = stateOfStudy;
    }
}
