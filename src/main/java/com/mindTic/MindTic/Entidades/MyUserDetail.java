package com.mindTic.MindTic.Entidades;

import com.mindTic.MindTic.Entidades.Empleado;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {

    private String username;
    private String password;
    private List <GrantedAuthority> authorities;

    public MyUserDetail(Empleado empleado){
        this.username = empleado.getEmail();
        this.password = empleado.getPassword();
        List <GrantedAuthority> roles = new ArrayList<>();

        for (String rol : empleado.getRoles().split(",")) {
            roles.add(
                    new SimpleGrantedAuthority(rol)
            );
        }

        this.authorities = roles;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}