package fr.erickfranco.cv_api.configurations.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/diplomes", "/api/experiences", "/api/langages", "/api/projets", "/api/messages", "/api/projets/page/**", "/api/uploads/img/**", "/images/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/diplomes/{id}", "/api/experiences/{id}", "/api/langages/{id}", "/api/projets/{id}", "/api/messages/{id}").hasAnyRole("USER", "ADMIN") // rehercher par id
                .antMatchers(HttpMethod.POST, "/api/projets/upload").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/diplomes", "/api/experiences", "/api/langages", "/api/projets", "/api/messages").hasRole("ADMIN") // create simplement admin
                .antMatchers("/api/diplomes/**", "/api/experiences/**", "/api/langages/**", "/api/projets/**", "/api/messages/**").hasRole("ADMIN") // delete update simplement admin /** c'est une route generique
                .anyRequest().authenticated().and().cors()
                .configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setExposedHeaders(Arrays.asList("Content-Type", "Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
                new CorsFilter(corsConfigurationSource()));

        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;

    }
}
