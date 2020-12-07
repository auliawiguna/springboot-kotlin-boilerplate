package com.blog.aulia.controller

import java.security.Principal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.Authentication
import com.blog.aulia.repository.ArticleRepository
import com.blog.aulia.model.Article
import com.blog.aulia.requests.ArticleRequest

import org.springframework.http.HttpStatus
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest
import java.util.*

import com.blog.aulia.security.encoder.config.PasswordEncoderAndMatcherConfig

@Controller
class ArticleController (private val articleRepository: ArticleRepository) {

    @GetMapping("/admin/article")    
    fun indexArticle(model: Model, paging: Pageable, @RequestParam(defaultValue = "1") page: Int, @RequestParam(defaultValue = "10") size: Int, request: HttpServletRequest, passwordEncoder: PasswordEncoderAndMatcherConfig, securityContextHolder: SecurityContextHolder, auth: Authentication, principal: Principal, redirectAttrs: RedirectAttributes) : String {
        model["title"] = "Articles"
        var paging = PageRequest.of(page, size);
        var dataTableArticle = articleRepository.findAll(paging)
        // var dataTableArticle = articleRepository.allArticleOrderByPaging(begin, limit, orderBy)
        model["articles"] = dataTableArticle
        var pageCount = dataTableArticle.getTotalPages()
        var prevPage = false
        var prevPageNum = 0
        var nextPage = false
        var nextPageNum = 0
        if (page > 1 && pageCount > 1) {
            prevPage = true
            prevPageNum = page - 1
        } 
        if (page < pageCount && pageCount > 1) {
            nextPage = true
            nextPageNum = page + 1
        } 
        val arrayOfPage = Array(pageCount) { i -> (i + 1).toString() }
        model["arrayOfPage"] = arrayOfPage
        model["prevPage"] = prevPage
        model["prevPageNum"] = prevPageNum
        model["nextPage"] = nextPage
        model["nextPageNum"] = nextPageNum
        model["base_url"] = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
        System.out.println(dataTableArticle)
        return "backend/article/index"
    } 

    // @GetMapping("/admin/articles/ajax/{typeRequest}")
    // fun articleAjax(@PathVariable typeRequest: String, @RequestParam begin: Long, @RequestParam limit: Long, @RequestParam orderBy: String, model: Model, request: HttpServletRequest): String {
    //     when (typeRequest) {
    //         "datatable" -> {
    //             var dataTableArticle = articleRepository.allArticleOrderByPaging(begin, limit, orderBy)
    //             System.out.println(dataTableArticle)
    //             return dataTableArticle
    //         }
    //     }
    // } 
}
