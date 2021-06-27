package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

public class Subject {
    int Resid;
    String subjects;
    StateOfStudy stateOfStudy;

    public Subject() {
    }

    public Subject(int resid, String subjects, StateOfStudy stateOfStudy) {
        Resid = resid;
        this.subjects = subjects;
        this.stateOfStudy = stateOfStudy;
    }

    public StateOfStudy getStateOfStudy() {
        return stateOfStudy;
    }

    public void setStateOfStudy(StateOfStudy stateOfStudy) {
        this.stateOfStudy = stateOfStudy;
    }

    public int getResid() {
        return Resid;
    }

    public void setResid(int resid) {
        Resid = resid;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
