package com.example.DailyReport.security.CompanyMmember;

import com.example.DailyReport.domain.CompanyMember;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.mapper.CompanyMapper;
import com.example.DailyReport.mapper.StudentMapper;
import com.example.DailyReport.security.Student.LoginStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component("COMPANYMEMBER")
public class CompanyMemberDetailServiceImpl implements UserDetailsService {

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        CompanyMember companyMember = companyMapper.findCompanyMemberByEmail(email);

        Collection<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("COMPANYMEMBER"));
        return new LoginCompanyMember(companyMember,authorityList);
    }


}
