package com.blog.aulia.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import com.blog.aulia.model.User

import com.blog.aulia.extension.toSlug

@Entity
@Table(name = "articles")
data class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = 0,

    @Column(name = "title")
    val title: String = "",

    @Column(name = "content")
    val content: String? = null,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    val author: User? = null,

    @Column(name = "slug")
    val slug: String? = title.toSlug()
    // val postSlug: String? = postTitle.toSlug()
)
