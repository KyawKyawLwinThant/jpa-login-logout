package com.example.jpasigninsingnup;

import com.example.jpasigninsingnup.dao.RoleDao;
import com.example.jpasigninsingnup.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class JpaSigninSingnupApplication {
    @Autowired
    private RoleDao roleDao;
    @Transactional
    @Bean @Profile("test")
    public ApplicationRunner runner(){
        return r ->{
            Role role1=new Role();
            role1.setName("ROLE_ADMIN");
            Role role2=new Role();
            role2.setName("ROLE_USER");
            roleDao.save(role1);
            roleDao.save(role2);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaSigninSingnupApplication.class, args);
    }

}
