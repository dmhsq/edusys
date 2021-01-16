package edusys.one.service;

import edusys.one.dao.UserRepository;
import edusys.one.domain.RespBean;
import edusys.one.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Service;

/**
 * @Author: 张灿
 * @Time: 2021/1/14 21:11
 */
@Service
public class UserManageService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ConsumerTokenServices consumerTokenServices;

    @Autowired
    UserRepository userRepository;

    /**
     * 退出
     *
     * @param accessToken 令牌
     * @return boolean
     */
    public boolean logOut(String accessToken) {
        if (consumerTokenServices.revokeToken(accessToken)) {
            return true;
        }
        return false;
    }



    public RespBean doSign(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles("user");
        userRepository.save(user);

        return RespBean.ok("成功",user.getUsername());
    }



}
