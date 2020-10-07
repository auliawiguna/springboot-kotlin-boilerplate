package com.blog.aulia.repository

import com.blog.aulia.model.Role
import org.springframework.data.repository.CrudRepository  
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface RoleRepository : CrudRepository<Role, Long> {
    fun findByRoleName(role_name: String)  : Role?
}
