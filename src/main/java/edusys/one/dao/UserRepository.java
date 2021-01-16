package edusys.one.dao;

import edusys.one.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: 张灿
 * @Time: 2020/1/2 22:15
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String username);

}
