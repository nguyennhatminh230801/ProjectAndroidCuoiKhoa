package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

public class EnglishTask {
    int ResID;
    String NameOfTask;
    StateOfStudy stateOfStudy;

    public EnglishTask() {
    }

    public EnglishTask(int resID, String nameOfTask, StateOfStudy stateOfStudy) {
        ResID = resID;
        NameOfTask = nameOfTask;
        this.stateOfStudy = stateOfStudy;
    }

    public int getResID() {
        return ResID;
    }

    public void setResID(int resID) {
        ResID = resID;
    }

    public String getNameOfTask() {
        return NameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        NameOfTask = nameOfTask;
    }

    public StateOfStudy getStateOfStudy() {
        return stateOfStudy;
    }

    public void setStateOfStudy(StateOfStudy stateOfStudy) {
        this.stateOfStudy = stateOfStudy;
    }

}
