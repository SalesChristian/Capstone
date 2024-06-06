package org.example.config;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        logger.info("Login successful for user: {}", authentication.getName());
        if (roles.contains("ROLE_ADMIN")) {
            logger.info("Redirecting to /admin_main");
            redirectStrategy.sendRedirect(request, response, "/admin_main");
        } else if (roles.contains("ROLE_USER")) {
            logger.info("Redirecting to /user_main");
            redirectStrategy.sendRedirect(request, response, "/user_main");
        } else {
            throw new IllegalStateException("User role not recognized");
        }
    }
}
