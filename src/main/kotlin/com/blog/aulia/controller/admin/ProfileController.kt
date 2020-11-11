package com.blog.aulia.controller

import java.security.Principal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.Authentication
import com.blog.aulia.repository.UserRepository
import com.blog.aulia.model.User
import com.blog.aulia.requests.ProfileRequest

import org.springframework.http.HttpStatus
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

import com.blog.aulia.security.encoder.config.PasswordEncoderAndMatcherConfig

@Controller
class ProfileController (private val userRepository: UserRepository) {

    @GetMapping("/admin/profile")    
    fun indexProfile(model: Model, request: HttpServletRequest, passwordEncoder: PasswordEncoderAndMatcherConfig, securityContextHolder: SecurityContextHolder, auth: Authentication, principal: Principal, user: User) : String {
        System.out.println("My Name " +  principal.getName())
        var name = principal.getName()
        var user =  userRepository.findByUserLogin(principal.getName())
        model["user"] = user
        model["name"] = auth.getName()
        model["title"] = "My Profile"
        // model["password"] = passwordEncoder.passwordEncoderAndMatcher().encode("admin123")
        model["base_url"] = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
        return "backend/profile/index"
    } 

    @PostMapping("/admin/profile")    
    fun postProfile(profileRequest : ProfileRequest, passwordEncoder: PasswordEncoderAndMatcherConfig) : String {
        var id = profileRequest.id
        
        var user =  userRepository.getOne(id!!)
        user.userNicename = profileRequest.name!!;
        if (profileRequest.email!="") {
            user.userEmail = profileRequest.email!!;
        }
        if (profileRequest.password != "") {
            if (profileRequest.password == profileRequest.password_confirm) {
                var encodedPassword = passwordEncoder.passwordEncoderAndMatcher().encode(profileRequest.password)
                user.userPass = encodedPassword
            }
        }
        // model["password"] = passwordEncoder.passwordEncoderAndMatcher().encode("admin123")

        userRepository.save(user);        
        return "redirect:/admin/profile"
    } 
}
