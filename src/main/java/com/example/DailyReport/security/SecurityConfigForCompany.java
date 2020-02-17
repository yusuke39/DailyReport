package com.example.DailyReport.security;

import com.example.DailyReport.security.CompanyMmember.CompanyMemberDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfigForCompany {

    /**
     * 企業担当者用セキュリティ
     */
    @Configuration
    public static class CompanySecurity extends WebSecurityConfigurerAdapter {


        @Autowired
        @Qualifier("COMPANY_MEMBER")
        CompanyMemberDetailServiceImpl companyMemberDetailService;

        @Override
        public void configure(WebSecurity web) throws Exception{
            web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.antMatcher("/companyMember/**")
                    .authorizeRequests()
                    .antMatchers("/companyMember/loginPage").permitAll()
                    .antMatchers("/companyMember/**")
                    .hasAuthority("COMPANY_MEMBER")
                    .anyRequest()
                    .authenticated()
                    .and();
            http.formLogin()
                    .loginProcessingUrl("/companyMember/login")//ログイン処理をするURL
                    .loginPage("/companyMember/loginPage")//ログイン画面のURL
                    .failureUrl("/companyMember/loginPage?error")//ログイン失敗時
                    .defaultSuccessUrl("/companyMember/companyTrainingList",true)//認証成功時のURL
                    .usernameParameter("email")//ユーザーのパラメーター名
                    .passwordParameter("password")
                    .and();
            http.logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/companyMember/logout"))
                    .logoutSuccessUrl("/companyMember/loginPage");
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder ath) throws Exception{
            ath.userDetailsService(this.companyMemberDetailService)
                    .passwordEncoder(new BCryptPasswordEncoder());
        }
    }
}
