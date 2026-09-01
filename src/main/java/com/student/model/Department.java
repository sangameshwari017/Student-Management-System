package com.student.model;

public class Department {

    private int departmentId;
    private String departmentName;
    private String hodName;
    private int totalFaculty;
    private int totalStudents;

    public Department() {

    }

    public Department(int departmentId, String departmentName,
            String hodName, int totalFaculty, int totalStudents) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.hodName = hodName;
        this.totalFaculty = totalFaculty;
        this.totalStudents = totalStudents;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public int getTotalFaculty() {
        return totalFaculty;
    }

    public void setTotalFaculty(int totalFaculty) {
        this.totalFaculty = totalFaculty;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId
                + ", departmentName=" + departmentName
                + ", hodName=" + hodName
                + ", totalFaculty=" + totalFaculty
                + ", totalStudents=" + totalStudents + "]";
    }

}