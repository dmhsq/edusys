package edusys.one.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 14:51
 */
@Entity
public class Teacher {

    /**
     * 教师编号
     */
    @Id
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师电话
     */
    private String teacherTel;

    /**
     * 教师家庭住址
     */
    private String address;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTel() {
        return teacherTel;
    }

    public void setTeacherTel(String teacherTel) {
        this.teacherTel = teacherTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherTel='" + teacherTel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
