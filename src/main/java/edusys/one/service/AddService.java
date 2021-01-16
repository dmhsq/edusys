package edusys.one.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edusys.one.dao.ExamRepository;
import edusys.one.dao.ResultRepository;
import edusys.one.dao.StudentRepository;
import edusys.one.dao.TeacherRepository;
import edusys.one.domain.Exam;
import edusys.one.domain.RespBean;
import edusys.one.domain.Student;
import edusys.one.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:42
 */
@Service
public class AddService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;


    public RespBean add(Integer type, Object object){
        Integer zero=0,one=1,two=2;
        if (type.equals(zero)){
            return addStu(object);
        }else if (type.equals(one)){
            return addTch(object);
        }else if (type.equals(two)){
            return addExam(object);
        }
        return RespBean.error("错误","错误");
    }


    private RespBean addStu(Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        Student student = objectMapper.convertValue(object,Student.class);
        studentRepository.saveAndFlush(student);
        return RespBean.ok("成功",true);
    }

    private RespBean addTch(Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        Teacher teacher = objectMapper.convertValue(object, Teacher.class);
        teacherRepository.saveAndFlush(teacher);
        return RespBean.ok("成功",true);
    }

    private RespBean addExam(Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        Exam exam = objectMapper.convertValue(object, Exam.class);
        examRepository.saveAndFlush(exam);
        return RespBean.ok("成功",true);
    }


}
