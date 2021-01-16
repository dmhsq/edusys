package edusys.one.service;


import edusys.one.domain.User;
import edusys.one.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 张灿
 * @Time: 2019/12/15 17:04
 */
@Service
public class UserService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);
            User user;
            if (!optionalUser.isPresent()){
                throw new UsernameNotFoundException("用户不存在");
            }
            user = optionalUser.get();
            System.out.println(user);


            System.out.println(user);
            System.out.println("wrong");
            System.out.println(user.getPassword());
            System.out.println(user.getUserId());



            List<GrantedAuthority> authorityList = new ArrayList<>();
            if (user.getRoles().equals("user")) {

                authorityList.add(new SimpleGrantedAuthority("ROLE_user"));

            }

            if (user.getRoles().equals("admin")) {

                authorityList.add(new SimpleGrantedAuthority("ROLE_admin"));

            }



            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    authorityList
            );

//            return user;

    }
}
