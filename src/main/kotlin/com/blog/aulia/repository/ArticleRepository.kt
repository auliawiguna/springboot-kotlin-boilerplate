package com.blog.aulia.repository

import com.blog.aulia.model.Article
import org.springframework.data.repository.CrudRepository  
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import kotlin.collections.Collection;

@Repository
// interface PostRepository : JpaRepository<Post, Long> {
// interface ArticleRepository : CrudRepository<Article, Long> {
interface ArticleRepository : PagingAndSortingRepository<Article, Long>, JpaSpecificationExecutor<Article> {
// interface ArticleRepository : DataTablesRepository<Article, Long> {
    
    fun findBySlugOrderByIdAsc(slug: String)  : Collection<Article>
    fun findBySlug(slug: String)  : Article


    
    // @Query(value = "select * from articles limit ?1 , ?2 order by ?3", nativeQuery = true)
    // fun allArticleOrderByPaging(begin: Long, limit: Long, orderBy: String ) : Page<Article>
}