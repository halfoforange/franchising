package com.s0rInb.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import com.s0rInb.entity.User;

import java.util.Collection;

public class UserImpl extends org.springframework.security.core.userdetails.User {
    @JsonIgnore
    private User user;
    public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities, User user) {
        super(username, password, authorities);
        this.user=user;
    }

    public User getUser() {
        return user;
    }
}
