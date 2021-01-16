package edusys.one.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: 张灿
 * @Time: 2021/1/6 16:44
 */
@Entity
public class Student {

    /**
     * 学号
     */
    @Id
    private String userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String classes;

    /**
     * 老师
     */
    private String teacherName;

    /**
     * 老师手机号
     */
    private Integer teacherPhone;

    /**
     * 联系方式的家长
     */
    private String contact;

    /**
     * 家长电话
     */
    private Integer contactPhone;

    /**
     * 家庭住址
     */
    private String address;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(Integer teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Integer contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", grade='" + grade + '\'' +
                ", classes='" + classes + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhone=" + teacherPhone +
                ", contact='" + contact + '\'' +
                ", contactPhone=" + contactPhone +
                ", address='" + address + '\'' +
                '}';
    }
}
