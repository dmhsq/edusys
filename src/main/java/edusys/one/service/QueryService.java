package edusys.one.service;

import edusys.one.dao.ExamRepository;
import edusys.one.dao.ResultRepository;
import edusys.one.dao.StudentRepository;
import edusys.one.dao.TeacherRepository;
import edusys.one.domain.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:40
 */
@Service
public class QueryService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;


    public RespBean find(Integer type,String userId,String userName, String teacherId, String teacherName, String examName, String examDate, String classes, String grade, Integer currentPage, Integer pageSize){
        if (currentPage<0){
            currentPage = 1;
        }
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        Integer zero=0,one=1,two=2,three=3;
        if (type.equals(zero)) {return findStudent(pageable,userId,userName,grade);}
        else if (type.equals(one)) {return findTeacher(pageable,teacherId,teacherName);}
        else if (type.equals(two)) {return findExam(pageable,examName,examName);}
        else if (type.equals(three)) {return findResult(pageable,examName,userId,classes);}
        else {return RespBean.error("失败","失败");}
    }

    /**
     * 查询学生
     * @param pageable 分页
     * @param userId 学号
     * @param userName 学生名
     * @param grade 年级
     * @return RespBean
     */
    private RespBean findStudent(Pageable pageable,String userId,String userName,String grade){
        return RespBean.ok("成功",studentRepository.findAllByUserIdLikeAndUserNameLikeAndGradeLike(pageable,"%"+userId+"%","%"+userName+"%","%"+grade+"%"));
    }

    /**
     * 查询老师
     * @param pageable 分页
     * @param teacherId 老师编号
     * @param teacherName 老师名
     * @return RespBean
     */
    private RespBean findTeacher(Pageable pageable,String teacherId,String teacherName){
        return  RespBean.ok("成功",teacherRepository.findAllByTeacherIdLikeAndTeacherNameLike(pageable,"%"+teacherId+"%","%"+teacherName+"%"));
    }

    /**
     * 查询考试
     * @param pageable 分页
     * @param examName 考试名
     * @param examDate 考试日期
     * @return RespBean
     */
    private RespBean findExam(Pageable pageable,String examName,String examDate){
        return  RespBean.ok("成功",examRepository.findAllByExamNameLikeAndExamDateLike(pageable,"%"+examName+"%","%"+examDate+"%"));
    }

    /**
     *
     * @param pageable 分页
     * @param examName 考试名
     * @param userId 学号
     * @param classes 班级
     * @return RespBean
     */
    private RespBean findResult(Pageable pageable,String examName,String userId,String classes){
        return  RespBean.ok("成功",resultRepository.findAllByExamNameLikeAndUserIdLikeAndClassesLike(pageable,"%"+examName+"%","%"+userId+"%","%"+classes+"%"));
    }

}
