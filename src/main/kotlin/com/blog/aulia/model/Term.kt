package com.blog.aulia.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "godongmassmg_terms")
data class Term (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val term_id: Long? = 0,

    val name: String? = null,
    val slug: String? = null,
    val term_group: Int = 0
)
