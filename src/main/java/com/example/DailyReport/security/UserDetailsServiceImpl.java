package com.example.DailyReport.security;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public LoginUser loadUserByUsername(String email) throws UsernameNotFoundException {
        List<Admin> adminListe = adminMapper.findAdmin(email);
        Admin admin = adminListe.get(0);

        if(admin == null){
            throw new UsernameNotFoundException("メールアドレスが不正です");
        }

        Collection<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ADMIN"));
        return new LoginUser(admin,authorityList);

    }
}
