package spring.secruity.example.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import spring.secruity.example.security.MyAuthenticationProvider


@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    fun provider() = MyAuthenticationProvider()


    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(provider())
    }

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/resource/**", "/static/**", "/favicon.ico")
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable().httpBasic()
        http.headers().frameOptions().disable()

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/auth")
                .defaultSuccessUrl("/index", true)
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)

        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true)
    }


}