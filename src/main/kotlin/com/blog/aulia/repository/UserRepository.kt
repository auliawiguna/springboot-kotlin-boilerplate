package com.blog.aulia.repository

import com.blog.aulia.model.User
import org.springframework.data.repository.CrudRepository  
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional
import kotlin.collections.Collection;

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserLogin(user_login: String)  : User
    fun findByUserEmail(user_email: String)  : User
    // public Optional<User>  findById(id: Long);
    // override fun findById(id: Long): Optional<User> 
}
