package edusys.one.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:22
 */
@Entity
public class Result {

    /**
     * 学号
     */
    @Id
    private String userId;

    /**
     * 学生姓名
     */
    private String userName;

    /**
     * 班级
     */
    private String classes;

    /**
     * 考试名
     */
    private String examName;

    /**
     * 科目成绩
     */
    private String examResult;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    @Override
    public String toString() {
        return "Result{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", classes='" + classes + '\'' +
                ", examName='" + examName + '\'' +
                ", examResult='" + examResult + '\'' +
                '}';
    }
}
