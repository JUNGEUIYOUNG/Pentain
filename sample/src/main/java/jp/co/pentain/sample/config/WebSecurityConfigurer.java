package jp.co.pentain.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                            "/img/**",
                            "/css/**",
                            "/js/**",
                            "/vendor/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
            	.authorizeRequests()
            	.antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and();

            http.formLogin()
                .loginPage("/login") //ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
                .loginProcessingUrl("/login") //フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
                .usernameParameter("email") //リクエストパラメータのname属性を明示
                .passwordParameter("passwd")
                .defaultSuccessUrl("/")
                // .successForwardUrl("/")
                .failureUrl("/login?error")
                //.permitAll()
                .and();

            http.logout()
              	.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
              	.logoutSuccessUrl("/login");
    }
   /* @Configuration
    protected static class AuthenticationConfiguration
    extends GlobalAuthenticationConfigurerAdapter {
        @Autowired
        UsersDetailServiceImp userDetailsService;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            // 認証するユーザーを設定する
            auth.userDetailsService(userDetailsService)
            // 入力値をbcryptでハッシュ化した値でパスワード認証を行う
            .passwordEncoder(new BCryptPasswordEncoder());
        }
    }*/

}
