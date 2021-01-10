package edusys.one.dao;

import edusys.one.domain.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:35
 */

public interface ExamRepository extends JpaRepository<Exam,String> {

    /**
     * 分页查询
     *
     * @param pageable 分页
     * @param string 考试名
     * @param stringo 考试日期
     * @return Pages
     */
    Page<Exam> findAllByExamNameLikeAndExamDateLike(Pageable pageable, String string, String stringo);
}
