package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

import java.util.List;

public class EnglishSkill {
    String EnglishSkillName;
    List<EnglishTask> TaskOfEngLishSkill;
    boolean isVisible;

    public EnglishSkill() {
    }

    public EnglishSkill(String englishSkillName, List<EnglishTask> taskOfEngLishSkill, boolean isVisible) {
        EnglishSkillName = englishSkillName;
        TaskOfEngLishSkill = taskOfEngLishSkill;
        this.isVisible = isVisible;
    }

    public String getEnglishSkillName() {
        return EnglishSkillName;
    }

    public void setEnglishSkillName(String englishSkillName) {
        EnglishSkillName = englishSkillName;
    }

    public List<EnglishTask> getTaskOfEngLishSkill() {
        return TaskOfEngLishSkill;
    }

    public void setTaskOfEngLishSkill(List<EnglishTask> taskOfEngLishSkill) {
        TaskOfEngLishSkill = taskOfEngLishSkill;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

}
