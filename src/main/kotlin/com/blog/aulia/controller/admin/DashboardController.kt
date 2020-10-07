package com.blog.aulia.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

import com.blog.aulia.model.Term
import com.blog.aulia.repository.TermRepository
import com.blog.aulia.repository.PostRepository

import org.springframework.http.HttpStatus
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

import com.blog.aulia.security.encoder.config.PasswordEncoderAndMatcherConfig

@Controller
class DashboardController (private val termRepository: TermRepository, private val postRepository: PostRepository) {
    
    @GetMapping("/admin/dashboard")
    fun home(model: Model, request: HttpServletRequest, passwordEncoder: PasswordEncoderAndMatcherConfig) : String {
        model["title"] = "Dashboard"
        // model["password"] = passwordEncoder.passwordEncoderAndMatcher().encode("admin123")
        model["base_url"] = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
        return "backend/dashboard/index"
    } 
}
