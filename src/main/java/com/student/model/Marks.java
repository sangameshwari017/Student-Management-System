package com.student.model;

public class Marks {

    private int markId;
    private int studentId;
    private String studentName;
    private String subject;
    private int mark;
    private String grade;

    public Marks() {

    }

    public Marks(int markId, int studentId, String studentName,
                 String subject, int mark, String grade) {

        this.markId = markId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.subject = subject;
        this.mark = mark;
        this.grade = grade;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}