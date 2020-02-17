package com.example.DailyReport.security.CompanyMmember;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoginCompanyMember extends User {

    private final com.example.DailyReport.domain.CompanyMember CompanyMember;

    public LoginCompanyMember(com.example.DailyReport.domain.CompanyMember companyMember, Collection<GrantedAuthority> authorityList) {
        super(companyMember.getEmail(), companyMember.getPassword(), authorityList);
        this.CompanyMember = companyMember;
    }

    public com.example.DailyReport.domain.CompanyMember getCompanyMember() {
        return CompanyMember;
    }
}
