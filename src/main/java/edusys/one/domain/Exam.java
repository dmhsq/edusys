package edusys.one.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:09
 */
@Entity
public class Exam {

    /**
     * 考试编号
     */
    @Id
    private String examId;

    /**
     * 考试名
      */
    private String examName;

    /**
     * 考试年级
     */
    private String examGrade;

    /**
     * 考试具体说明
     */
    private String examInfo;

    /**
     * 考试日期
     */
    private String examDate;

    /**
     * 考试负责老师
     */
    private String examTeacher;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(String examGrade) {
        this.examGrade = examGrade;
    }

    public String getExamInfo() {
        return examInfo;
    }

    public void setExamInfo(String examInfo) {
        this.examInfo = examInfo;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamTeacher() {
        return examTeacher;
    }

    public void setExamTeacher(String examTeacher) {
        this.examTeacher = examTeacher;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId='" + examId + '\'' +
                ", examName='" + examName + '\'' +
                ", examGrade='" + examGrade + '\'' +
                ", examInfo='" + examInfo + '\'' +
                ", examDate='" + examDate + '\'' +
                ", examTeacher='" + examTeacher + '\'' +
                '}';
    }
}
