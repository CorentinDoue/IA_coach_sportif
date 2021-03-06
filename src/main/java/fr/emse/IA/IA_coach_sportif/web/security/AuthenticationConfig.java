package fr.emse.IA.IA_coach_sportif.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration of the WebMvc application
 * @author JB Nizet
 */
@Configuration
public class AuthenticationConfig implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/api/**/*")
//                .excludePathPatterns("/api/authentication");
//    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
