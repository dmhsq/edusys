package edusys.one.dao;

import edusys.one.domain.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 张灿
 * @Time: 2021/1/10 15:36
 */

public interface ResultRepository extends JpaRepository<Result,String> {

    /**
     * 分页查询
     *
     * @param pageable 分页
     * @param string 考试名
     * @param stringo 学号
     * @param stringt 班级
     * @return Pages
     */
    Page<Result> findAllByExamNameLikeAndUserIdLikeAndClassesLike(Pageable pageable, String string, String stringo,String stringt);
}
