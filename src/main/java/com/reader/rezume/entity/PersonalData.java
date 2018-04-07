package com.reader.rezume.entity;

public class PersonalData {

    private String FIO;
    private String DOB;
    private String phone;
    private String email;
    private String skype;
    private String avatar;
    private String target;
    private String experiences;
    private String educations;
    private String additionalEducations;
    private String skills;
    private String examplesCode;

    public PersonalData(
            String FIO,
            String DOB,
            String phone,
            String email,
            String skype,
            String avatar,
            String target,
            String experiences,
            String educations,
            String additionalEducations,
            String skills,
            String examplesCode) {
        this.FIO = FIO;
        this.DOB = DOB;
        this.phone = phone;
        this.email = email;
        this.skype = skype;
        this.avatar = avatar;
        this.target = target;
        this.experiences = experiences;
        this.educations = educations;
        this.additionalEducations = additionalEducations;
        this.skills = skills;
        this.examplesCode = examplesCode;
    }

    public String getFIO() {
        return FIO;
    }

    public String getDOB() {
        return DOB;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getTarget() {
        return target;
    }

    public String getExperiences() {
        return experiences;
    }

    public String getEducations() {
        return educations;
    }

    public String getAdditionalEducations() {
        return additionalEducations;
    }

    public String getSkills() {
        return skills;
    }

    public String getExamplesCode() {
        return examplesCode;
    }
}
