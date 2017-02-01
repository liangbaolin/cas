package org.apereo.cas.configuration.model.core.web.security;

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties;
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is {@link AdminPagesSecurityProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
public class AdminPagesSecurityProperties {
    private String ip = "127\\.0\\.0\\.1|0:0:0:0:0:0:0:1";
    private List<String> adminRoles = new ArrayList<>(Collections.singletonList("ROLE_ADMIN"));
    private String loginUrl;
    private String service;
    private Resource users;
    private boolean actuatorEndpointsEnabled;

    private Jdbc jdbc = new Jdbc();

    public Jdbc getJdbc() {
        return jdbc;
    }

    public void setJdbc(final Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    public boolean isActuatorEndpointsEnabled() {
        return actuatorEndpointsEnabled;
    }

    public void setActuatorEndpointsEnabled(final boolean actuatorEndpointsEnabled) {
        this.actuatorEndpointsEnabled = actuatorEndpointsEnabled;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }

    public List<String> getAdminRoles() {
        return adminRoles;
    }

    public void setAdminRoles(final List<String> adminRoles) {
        this.adminRoles = adminRoles;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(final String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getService() {
        return service;
    }

    public void setService(final String service) {
        this.service = service;
    }

    public Resource getUsers() {
        return users;
    }

    public void setUsers(final Resource users) {
        this.users = users;
    }

    public class Jdbc extends AbstractJpaProperties {
        private String rolePrefix;
        private String query;

        @NestedConfigurationProperty
        private PasswordEncoderProperties passwordEncoder = new PasswordEncoderProperties();

        public String getRolePrefix() {
            return rolePrefix;
        }

        public void setRolePrefix(final String rolePrefix) {
            this.rolePrefix = rolePrefix;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(final String query) {
            this.query = query;
        }

        public PasswordEncoderProperties getPasswordEncoder() {
            return passwordEncoder;
        }

        public void setPasswordEncoder(final PasswordEncoderProperties passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
        }
    }
}
