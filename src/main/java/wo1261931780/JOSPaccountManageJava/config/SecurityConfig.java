package wo1261931780.JOSPaccountManageJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 配置 - 集成测试阶段开放所有 API
 *
 * <p>正式上线前需要替换为基于 JWT 的认证过滤器链：
 * <ul>
 *   <li>添加 JwtAuthenticationFilter 到 UsernamePasswordAuthenticationFilter 之前</li>
 *   <li>放行 /api/auth/** (登录/注册)</li>
 *   <li>其他 /api/** 需要 Authorization: Bearer {token}</li>
 * </ul>
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
