package com.example.DailyReport.security;


import com.example.DailyReport.domain.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class LoginUser extends User {


    private final com.example.DailyReport.domain.Admin Admin;

    public LoginUser(Admin admin, Collection<GrantedAuthority> authorityList) {
        super(admin.getEmail(), admin.getPassword(), authorityList);
        this.Admin = admin;
    }

    public com.example.DailyReport.domain.Admin getAdmin() {
        return Admin;
    }
}
