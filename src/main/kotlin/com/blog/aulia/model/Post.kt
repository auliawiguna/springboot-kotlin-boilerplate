package com.blog.aulia.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import com.blog.aulia.model.User

import com.blog.aulia.extension.toSlug

@Entity
@Table(name = "godongmassmg_posts")
data class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ID: Long? = 0,

    @Column(name = "post_title")
    val postTitle: String = "",

    @Column(name = "post_content")
    val postContent: String? = null,

    @Column(name = "post_type")
    val postType: String? = null,

    @OneToOne
    @JoinColumn(name = "post_author", referencedColumnName = "ID")
    val postAuthor: User? = null,

    @Column(name = "post_slug")
    val postSlugName: String = postTitle.toSlug()
    // val postSlug: String? = postTitle.toSlug()
)
