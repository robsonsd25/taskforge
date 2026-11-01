.authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .requestMatchers(HttpMethod.POST, "/login", "/usuarios", "/usuarios/login").permitAll()
        .requestMatchers("/h2-console/**").permitAll()
        .requestMatchers("/error").permitAll()
// Libera TODAS as rotas do Swagger, incluindo a de configuração
        .requestMatchers(
                "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/v3/api-docs/swagger-config"
).permitAll()
        .anyRequest().authenticated()
)