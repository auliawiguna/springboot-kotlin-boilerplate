package com.blog.aulia.security.service

import com.blog.aulia.model.User
import com.blog.aulia.repository.UserRepository
import com.blog.aulia.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
open class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return CustomUserDetails(userRepository.findByUserLogin(username)!!)
    }
}