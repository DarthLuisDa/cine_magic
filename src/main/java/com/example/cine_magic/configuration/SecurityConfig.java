package com.example.cine_magic.configuration;

import com.example.cine_magic.filtros.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authProvider = authProvider;
    }

    @Bean
    public SecurityFilterChain cadenaDeFiltros(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) //desabilitar el cross
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/cine_magic_db/auth/registro","/cine_magic_db/auth/login").permitAll()  //END POINT PUBLICO todos los endpoints que macheen con esto no pedirá autenticacion
                                .anyRequest().authenticated()  // END POINT PRIVADO todos los demas endpoint pedirán autenticación
                )
                .sessionManagement( sessionManager -> //desabilita sesiones
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider) //especificamos provedor en este caso es autenticasion con acceso a bd
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // especificamos el filtro en este caso filtros
                .build();
    }

    /*
    @Bean
    public SecurityFilterChain cadenaDeFiltros(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable()).httpBasic(Customizer.withDefaults()). //tener una autorizacion basica por defaul
                authorizeHttpRequests((authz) -> authz.requestMatchers("/autentification/**").permitAll().anyRequest().authenticated()); //cualquier petición debe estar autenticada
        return httpSecurity.build();
    }
    */

    /*
    @Bean
    public InMemoryUserDetailsManager crearUsuario() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Daniel")
                .password("1234")
                .roles("USER")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("Luis")
                .password("4321")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(List.of(user,user2));
    }
    */

}

