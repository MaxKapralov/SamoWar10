package project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@SpringBootApplication(scanBasePackages = {"project"})
@EnableJpaRepositories("project.model.repositories")
@EntityScan(basePackages = {"project.model.data"})
public class Application{

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }


    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic().realmName("REALM").authenticationEntryPoint(getBasicAuthEntryPoint())
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .and().csrf().disable();
        }

        @Bean
        public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint()
        {
            return new CustomBasicAuthenticationEntryPoint();
        }
    }
}
