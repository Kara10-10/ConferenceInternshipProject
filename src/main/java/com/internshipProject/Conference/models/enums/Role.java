package com.internshipProject.Conference.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_LISTENER, ROLE_SPEAKER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
