package com.blog.aulia.security

import com.blog.aulia.model.User
import org.slf4j.LoggerFactory
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors
import kotlin.collections.Collection;

open class CustomUserDetails: User, UserDetails {
    
    private val log = LoggerFactory.getLogger(CustomUserDetails::class.java)

    constructor(user: User) : super(user)

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return super.roles
        .stream()
        .map{
            role -> log.debug("Grant Auth with role " + role.toString())
            SimpleGrantedAuthority(role.toString())
        }
        .collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return super.userPass.toString()
    } 

    override fun getUsername(): String {
        log.debug("super.userNicename " + super.userNicename)
        return super.userNicename.toString()
    } 

    override fun isEnabled(): Boolean {
        return true
    } 

    override fun isCredentialsNonExpired(): Boolean {
        return true
    } 

    override fun isAccountNonExpired(): Boolean {
        return true
    } 

    override fun isAccountNonLocked(): Boolean {
        return true
    }     
}