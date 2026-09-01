package com.student.model;

public class Faculty {

    private int facultyId;
    private String facultyName;
    private String department;
    private String qualification;
    private int experience;
    private String mobile;
    private String email;

    public Faculty() {

    }

    public Faculty(int facultyId, String facultyName, String department,
                   String qualification, int experience,
                   String mobile, String email) {

        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.department = department;
        this.qualification = qualification;
        this.experience = experience;
        this.mobile = mobile;
        this.email = email;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Faculty [facultyId=" + facultyId +
                ", facultyName=" + facultyName +
                ", department=" + department +
                ", qualification=" + qualification +
                ", experience=" + experience +
                ", mobile=" + mobile +
                ", email=" + email + "]";
    }

}