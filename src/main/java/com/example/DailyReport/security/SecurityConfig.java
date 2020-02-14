package com.example.DailyReport.security;


import com.example.DailyReport.security.Admin.AdminDetailsServiceImpl;
import com.example.DailyReport.security.CompanyMmember.CompanyMemberDetailServiceImpl;
import com.example.DailyReport.security.Student.StudentDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfig  {


    /**
     * 管理者用のセキュリティー
     */
    @Configuration
    @Order(1)
    public static class AdminSecurity extends WebSecurityConfigurerAdapter{


        @Autowired
        @Qualifier("ADMIN")
        AdminDetailsServiceImpl adminDetailsService;


        /**
         * 静的ファイルに認証はかけない.
         * @param web
         * @throws Exception
         */
        @Override
        public void configure(WebSecurity web) throws Exception{
            web.ignoring().antMatchers( "/css/**", "/js/**", "/images/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.antMatcher("/admin/**")
                .authorizeRequests()
                .antMatchers("/admin/loginPage").permitAll()
                .antMatchers("/admin/**")
                .hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and();

             http
                .formLogin()
                .loginProcessingUrl("/admin/login")//ログイン処理をするURL
                .loginPage("/admin/loginPage")//ログイン画面のURL
                .failureUrl("/admin/loginPage?error")//ログイン失敗時
                .defaultSuccessUrl("/admin/operationManager",true)//認証成功時のURL
                .usernameParameter("email")//ユーザーのパラメーター名
                .passwordParameter("password")
                .and();

             http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                .logoutSuccessUrl("/admin/loginPage");
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder ath) throws Exception{
            ath.userDetailsService(this.adminDetailsService)
                    .passwordEncoder(new BCryptPasswordEncoder());
        }

    }


    /**
     * 受講生用のセキュリティー
     */
    @Configuration
    @Order(2)
    public static class StudentSecurity extends WebSecurityConfigurerAdapter{


        @Autowired
        @Qualifier("STUDENT")
        StudentDetailServiceImpl studentDetailService;

        @Override
        public void configure(WebSecurity web) throws Exception{
            web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.antMatcher("/student/**")
                    .authorizeRequests()
                    .antMatchers("/student/loginPage").permitAll()
                    .antMatchers("/student/**")
                    .hasAuthority("STUDENT")
                    .anyRequest()
                    .authenticated()
                    .and();
            http
                    .formLogin()
                    .loginProcessingUrl("/student/login")//ログイン処理をするURL
                    .loginPage("/student/loginPage")//ログイン画面のURL
                    .failureUrl("/student/loginPage?error")//ログイン失敗時
                    .defaultSuccessUrl("/student/studentTrainingList",true)//認証成功時のURL
                    .usernameParameter("email")//ユーザーのパラメーター名
                    .passwordParameter("password")
                    .and();
            http
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/student/logout"))
                    .logoutSuccessUrl("/student/loginPage")
                    .and().csrf().disable();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder ath) throws Exception{
            ath.userDetailsService(this.studentDetailService)
                    .passwordEncoder(new BCryptPasswordEncoder());
        }
    }


    @Configuration
    @Order(3)
    public static class CompanySecurity extends WebSecurityConfigurerAdapter{


        @Autowired
        @Qualifier("COMPANYMEMBER")
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
                    .hasAuthority("COMPANYMEMBER")
                    .anyRequest()
                    .authenticated()
                    .and();
            http
                    .formLogin()
                    .loginProcessingUrl("/companyMember/login")//ログイン処理をするURL
                    .loginPage("/companyMember/loginPage")//ログイン画面のURL
                    .failureUrl("/companyMember/loginPage?error")//ログイン失敗時
                    .defaultSuccessUrl("/companyMember/companyTrainingList",true)//認証成功時のURL
                    .usernameParameter("email")//ユーザーのパラメーター名
                    .passwordParameter("password")
                    .and();
            http
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/companyMember/logout"))
                    .logoutSuccessUrl("/companyMember/loginPage")
                    .and().csrf().disable();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder ath) throws Exception{
            ath.userDetailsService(this.companyMemberDetailService)
                    .passwordEncoder(new BCryptPasswordEncoder());
        }
    }


}
