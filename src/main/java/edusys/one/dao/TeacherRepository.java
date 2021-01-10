package edusys.one.dao;

import edusys.one.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:33
 */

public interface TeacherRepository extends JpaRepository<Teacher,String> {

    /**
     * 分页查询
     *
     * @param pageable 分页
     * @param string 教师编号
     * @param stringo 教师名字
     * @return Pages
     */
    Page<Teacher> findAllByTeacherIdLikeAndTeacherNameLike(Pageable pageable,String string,String stringo);
}
