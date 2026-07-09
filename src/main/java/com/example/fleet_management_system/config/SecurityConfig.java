package com.example.fleet_management_system.config;

import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {
//    The string "ROLE_" is prepended to a role name to create the authority string that the security framework uses for authorization checks.
    private static final String ROLE_PREFIX = "ROLE_";
    private static final String ADMIN = "ADMIN";
    private static final String FLEET_MANAGER = "FLEET_MANAGER";
    private static final String DRIVER = "DRIVER";
    private static final String SERVICE_ENGINEER = "SERVICE_ENGINEER";
    private static final String SAFETY_OFFICER = "SAFETY_OFFICER";
    private static final String OPERATIONS_ANALYST = "OPERATIONS_ANALYST";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/access-denied").permitAll()
                        .requestMatchers("/admin/**", "/api/admin/**").hasRole(ADMIN)
                        .requestMatchers("/fleet/**", "/api/fleet/**").hasAnyRole(ADMIN, FLEET_MANAGER)
                        .requestMatchers("/driver/**", "/api/driver/**").hasAnyRole(ADMIN, FLEET_MANAGER, DRIVER, SAFETY_OFFICER)
                        .requestMatchers("/service/**", "/api/service/**").hasAnyRole(ADMIN, FLEET_MANAGER, SERVICE_ENGINEER)
                        .requestMatchers("/safety/**", "/api/safety/**").hasAnyRole(ADMIN, FLEET_MANAGER, SAFETY_OFFICER)
                        .requestMatchers("/analyst/**", "/api/fuel-logs", "/api/fuel-logs/**").hasAnyRole(ADMIN, FLEET_MANAGER, OPERATIONS_ANALYST)
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/access-denied")
                )
                .formLogin(form -> form
                        .loginPage("/")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .successHandler(roleBasedSuccessHandler())
                        .failureUrl("/?error")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return email -> {
            User user = userRepository.findByEmail(email);

            if (user == null) {
                throw new UsernameNotFoundException("User not found: " + email);
            }

            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRole().name())
                    .build();
        };
    }

    @Bean
    public AuthenticationSuccessHandler roleBasedSuccessHandler() {
        return (request, response, authentication) -> {
            if (hasRole(authentication, ADMIN)) {
                response.sendRedirect("/admin/dashboard");
            } else if (hasRole(authentication, FLEET_MANAGER)) {
                response.sendRedirect("/fleet/vehicles/register");
            } else if (hasRole(authentication, DRIVER)) {
                response.sendRedirect("/driver/dashboard");
            } else if (hasRole(authentication, SERVICE_ENGINEER)) {
                response.sendRedirect("/service/dashboard");
            } else if (hasRole(authentication, SAFETY_OFFICER)) {
                response.sendRedirect("/safety/dashboard");
            } else if (hasRole(authentication, OPERATIONS_ANALYST)) {
                response.sendRedirect("/analyst/dashboard");
            } else {
                response.sendRedirect("/");
            }
        };
    }

    // This method checks whether the currently logged-in user has a specific role.
    private boolean hasRole(Authentication authentication, String role) {
        // Gets all roles/permissions of the logged-in user.
        // Converts the list of roles into a stream so we can process them easily.
        // Checks if at least one role matches the condition.
        // Compares each authority with the required role.
        return authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_" + role));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
