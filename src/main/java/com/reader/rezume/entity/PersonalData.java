package com.reader.rezume.entity;

/**
 * Class for writing and outputting properties using getters and setters
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class PersonalData {
    /**
     * Property - Full Name
     */
    private String FIO;

    /**
     * Property - Birthday
     */
    private String DOB;

    /**
     * Property - Phone
     */
    private String phone;

    /**
     * Property - Email
     */
    private String email;

    /**
     * Property - Skype
     */
    private String skype;

    /**
     * Property - Avatar link
     */
    private String avatar;

    /**
     * Property - Target
     */
    private String target;

    /**
     * Property - Experience
     */
    private String experiences;

    /**
     * Property - Educations
     */
    private String educations;

    /**
     * Property - Additional educations
     */
    private String additionalEducations;

    /**
     * Property - Skills
     */
    private String skills;

    /**
     * Property - Examples code
     */
    private String examplesCode;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatarPath(String avatar) {
        this.avatar = avatar;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public String getEducations() {
        return educations;
    }

    public void setEducations(String educations) {
        this.educations = educations;
    }

    public String getAdditionalEducations() {
        return additionalEducations;
    }

    public void setAdditionalEducations(String additionalEducations) {
        this.additionalEducations = additionalEducations;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExamplesCode() {
        return examplesCode;
    }

    public void setExamplesCode(String examplesCode) {
        this.examplesCode = examplesCode;
    }
}