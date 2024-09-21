package com.example.ramenddang.member.dto;

import com.example.ramenddang.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MemberDetails implements UserDetails {
    private final Member member;

    public MemberDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {

                return member.getUserRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return member.getUserPasswd();
    }

    public Long getUserId() {
        return member.getUserId();
    }

    public boolean isDeleted(){
        return member.getIsDeleted();
    }

    @Override
    public String getUsername() {
        return member.getUserLoginId();
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
