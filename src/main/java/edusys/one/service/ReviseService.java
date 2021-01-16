package edusys.one.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import edusys.one.dao.ExamRepository;
import edusys.one.dao.ResultRepository;
import edusys.one.dao.StudentRepository;
import edusys.one.dao.TeacherRepository;
import edusys.one.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:41
 */
@Service
public class ReviseService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;


    public RespBean change(Integer type,Object object){
        Integer zero=0,one=1,two=2,three=3;
        if (type.equals(zero)){
            return changeStu(object);
        }else if (type.equals(one)){
            return changeTch(object);
        }else if (type.equals(two)){
            return changeExam(object);
        }else if (type.equals(three)){
            return changeRust(object);
        }
        return RespBean.error("错误","错误");
    }


    private RespBean changeStu(Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        Student student = objectMapper.convertValue(object,Student.class);
        Optional<Student> studentOptional = studentRepository.findById(student.getUserId());
        if (!studentOptional.isPresent()){
            return RespBean.error("失败","不存在学生信息");
        }
        studentRepository.saveAndFlush(student);
        return RespBean.ok("成功",true);
    }

    private RespBean changeTch(Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        Teacher teacher = objectMapper.convertValue(object, Teacher.class);
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacher.getTeacherId());
        if (!teacherOptional.isPresent()){
            return RespBean.error("失败","不存在老师信息");
        }
        teacherRepository.saveAndFlush(teacher);
        return RespBean.ok("成功",true);
    }

    private RespBean changeExam(Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        Exam exam = objectMapper.convertValue(object, Exam.class);
        Optional<Exam> examOptional = examRepository.findById(exam.getExamId());
        if (!examOptional.isPresent()){
            return RespBean.error("失败","不存在老师信息");
        }
        examRepository.saveAndFlush(exam);
        return RespBean.ok("成功",true);
    }

    private RespBean changeRust(Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        Result result = objectMapper.convertValue(object, Result.class);
        Optional<Result> resultOptional = resultRepository.findByUserIdEqualsAndExamIdEquals(result.getUserId(),result.getExamId());
        if (!resultOptional.isPresent()){
            return RespBean.error("失败","不存在考试/考生信息");
        }
        resultRepository.saveAndFlush(result);
        return RespBean.ok("成功",true);
    }

}
