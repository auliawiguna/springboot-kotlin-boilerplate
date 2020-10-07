package com.blog.aulia.controller

import java.security.Principal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.Authentication
import com.blog.aulia.model.Term
import com.blog.aulia.repository.UserRepository

import org.springframework.http.HttpStatus
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

import com.blog.aulia.security.encoder.config.PasswordEncoderAndMatcherConfig

@Controller
class ProfileController (private val userRepository: UserRepository) {
    
    @GetMapping("/admin/profile")
    fun home(model: Model, request: HttpServletRequest, passwordEncoder: PasswordEncoderAndMatcherConfig, securityContextHolder: SecurityContextHolder, auth: Authentication, principal: Principal) : String {
        System.out.println(auth)
        model["name"] = auth.getName()
        model["title"] = "My Profile"
        // model["password"] = passwordEncoder.passwordEncoderAndMatcher().encode("admin123")
        model["base_url"] = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
        return "backend/profile/index"
    } 
}
