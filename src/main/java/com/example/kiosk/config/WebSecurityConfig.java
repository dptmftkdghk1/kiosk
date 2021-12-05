package com.example.kiosk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.kiosk.service.MemberService;

import lombok.AllArgsConstructor;


@Configuration
@EnableWebSecurity
@AllArgsConstructor

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private MemberService memberservice;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 인증하지 않을 주소 추가.
		web.ignoring().antMatchers("/css/**", "/js/**", "/image/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/mypoint/**").hasAnyAuthority("QUERY", "WRITE") // 접근 권한. 
				.antMatchers("/menus/**", "/post/**").hasRole("ADMIN")
				.antMatchers("/**").permitAll() // 위 경우를 빼고 모든 권한을 줌=로그인 필요 없음.
				.anyRequest().authenticated()
		.and().formLogin().loginPage("/").defaultSuccessUrl("/myinfo").permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/").invalidateHttpSession(true)
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().csrf()
		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()); 
	}
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberservice).passwordEncoder(passwordEncoder());
    }
	
}