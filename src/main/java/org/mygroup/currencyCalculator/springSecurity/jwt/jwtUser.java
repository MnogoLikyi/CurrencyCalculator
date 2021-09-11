package org.mygroup.currencyCalculator.springSecurity.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mygroup.currencyCalculator.enums.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * This class implements a {@link UserDetails } interface and realizes the its functionality of jwt user state.
 *
 * @author Samvel Ghazaryna
 * @version 1.0
 * */

public class jwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final Status status;
    private final LocalDateTime lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;

    public Status getStatus() {
        return status;
    }

    public jwtUser(
            Long id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            Status status,
            LocalDateTime lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.status = status;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    public LocalDateTime getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
