package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

public class Subject {
    int Resid;
    String subjects;

    public Subject(int resid, String subjects) {
        Resid = resid;
        this.subjects = subjects;
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
