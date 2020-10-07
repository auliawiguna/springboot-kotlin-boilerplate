package com.blog.aulia.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import com.blog.aulia.model.Role

@Entity
@Table(name = "godongmassmg_users")
open class User (

    @Column(name = "user_login")
    var userLogin: String = "",

    @Column(name = "user_nicename")
    var userNicename: String = "",

    @Column(name = "user_email")
    var userEmail: String = "",

    @Column(name = "user_pass")
    var userPass: String = ""

    // var userLogin: String = "",
    // var userNicename: String = "",
    // var userEmail: String = "",
    // var userPass: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

	@OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
	var roles: MutableSet<Role> = HashSet()

	constructor(user: User) : this(user.userLogin, user.userNicename, user.userEmail, user.userPass) {
		roles = user.roles
        userLogin = user.userLogin
        userEmail = user.userEmail
        userPass = user.userPass
	}    
}
