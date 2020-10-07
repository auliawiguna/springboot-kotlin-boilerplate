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

@Controller
class HomeController (private val termRepository: TermRepository, private val postRepository: PostRepository) {
    
    @GetMapping("/")
    fun home(model: Model) : String {
        model["title"] = "Blog"
        return "index"
    } 

    @GetMapping("/access-denied")
    fun accessDenied(model: Model) : String {
        model["title"] = "Blog"
        return "access_denied"
    } 

    @GetMapping("/terms")
    fun getTerms(model: Model) : String {
        model["title"] = "Terms"
        model["term"] = termRepository.findAll()
        return "term/index"
    } 

    @GetMapping("/posts")
    fun getPosts(model: Model, request: HttpServletRequest) : String {
        model["title"] = "Posts"
        model["base_url"] = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
        model["post"] = postRepository.findByPostTypeOrderByIDAsc("post")
        model["term"] = termRepository.findAll()
        System.out.println(model)
        return "post/index"
    } 


    @GetMapping("/posts/{postId}/{slug}")
    fun showPost(@PathVariable postId: Long, @PathVariable slug: String, model: Model, request: HttpServletRequest): String {
        model["base_url"] = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
        val article = postRepository.findByID(postId)
        model["title"] = article.postTitle.toString()
        model["post"] = article
        return "post/detail"
    }


    // @GetMapping("/terms")
    // fun getTerms(): List<Term> = 
    //     repository.findAll()
}
