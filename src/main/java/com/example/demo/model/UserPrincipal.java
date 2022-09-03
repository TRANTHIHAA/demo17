package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails {
    private Long id;

    private String name;

    private String email;

    private String password;

    private Restaurants restaurant;

    private List<? extends GrantedAuthority> roles;


    public static UserPrincipal build(Users user) {
        Set<Roles> roles = user.getRoles(); //Lấy ra role của user
        List<GrantedAuthority> authorities = new ArrayList<>(); //tạo một list quyền cho user principal
        for (Roles role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole())); //thêm quyền vào list
        }
        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRestaurant(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public Long getId() {
        return id;
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
