package com.blog.aulia.repository

import com.blog.aulia.model.Post
import org.springframework.data.repository.CrudRepository  
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import kotlin.collections.Collection;

@Repository
// interface PostRepository : JpaRepository<Post, Long> {
interface PostRepository : CrudRepository<Post, Long> {

    fun findByPostTypeOrderByIDAsc(post_type: String)  : Collection<Post>
    fun findByID(ID: Long)  : Post


    
    @Query(value = "select * from godongmassmg_posts where post_type='post' order by ?1 ?2", nativeQuery = true)
    fun allPostOrderBy(orderBy: String, order: String ) : Collection<Post>
 }