package com.exam.service.impl;

//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import com.exam.helper.UserFoundException;
import com.exam.models.User;
import com.exam.models.Role;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception{
        //return null;
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            //local.setFirstname("Aman");
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    @Override
    public User getUser(String username) {
        //return null;
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {

            this.userRepository.deleteById(userId);

    }

}
