package com.example.DailyReport;

import com.example.DailyReport.security.Admin.AdminDetailsServiceImpl;
import com.example.DailyReport.security.Student.StudentDetailServiceImpl;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DailyReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyReportApplication.class, args);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean(name = "ADMIN")
//	public UserDetailsService userDetailsService(){
//		return new AdminDetailsServiceImpl();
//	}

//	@Bean(name = "STUDENT")
//	public UserDetailsService studentDetailService(){
//		return new StudentDetailServiceImpl();
//	}

}
