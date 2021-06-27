package com.hitcyclone317.projectAndroidCuoiKhoa.Model;

public class TypeVocabulary {
    String Title;
    String AudioLink;
    String ImageLink;
    String VietnameseTrans;
    String Description;

    public TypeVocabulary() {

    }

    public TypeVocabulary(String title, String audioLink, String imageLink, String vietnameseTrans, String description) {
        Title = title;
        AudioLink = audioLink;
        ImageLink = imageLink;
        VietnameseTrans = vietnameseTrans;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAudioLink() {
        return AudioLink;
    }

    public void setAudioLink(String audioLink) {
        AudioLink = audioLink;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }

    public String getVietnameseTrans() {
        return VietnameseTrans;
    }

    public void setVietnameseTrans(String vietnameseTrans) {
        VietnameseTrans = vietnameseTrans;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
