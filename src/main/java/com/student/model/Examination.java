package com.student.model;

public class Examination {

    private int examId;
    private int studentId;
    private String studentName;
    private String examName;
    private String examDate;
    private String examTime;

    public Examination() {
    }

    public Examination(int examId, int studentId, String studentName,
            String examName, String examDate, String examTime) {

        this.examId = examId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.examName = examName;
        this.examDate = examDate;
        this.examTime = examTime;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
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

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

	@Override
	public String toString() {
		return "Examination [examId=" + examId + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", examName=" + examName + ", examDate=" + examDate + ", examTime=" + examTime + "]";
	}
    
}