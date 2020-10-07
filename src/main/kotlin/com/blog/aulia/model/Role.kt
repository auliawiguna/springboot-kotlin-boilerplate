package com.blog.aulia.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import com.blog.aulia.model.Role

@Entity
@Table(name = "godongmassmg_roles")
open class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "rolename")
    val roleName: String? = null

    // @Column(name = "user_id")
    // val userId: Long? = null

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "user_id")
    // var userId: User? = null    
)
