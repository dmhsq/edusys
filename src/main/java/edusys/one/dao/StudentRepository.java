package edusys.one.dao;

import edusys.one.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 张灿
 * @Time: 2021/1/6 16:34
 */

public interface StudentRepository extends JpaRepository<Student,String> {

    /**
     * 分页查询
     *
     * @param pageable 分页
     * @param string 学号
     * @param stringo 学生名
     * @param stringt 班级
     * @return Pages
     */
    Page<Student> findAllByUserIdLikeAndUserNameLikeAndGradeLike(Pageable pageable, String string,String stringo,String stringt);

}
