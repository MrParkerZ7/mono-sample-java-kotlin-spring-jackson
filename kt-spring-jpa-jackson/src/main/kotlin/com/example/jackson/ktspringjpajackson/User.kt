package com.example.jackson.ktspringjpajackson

import org.springframework.boot.CommandLineRunner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = null,
                var name: String? = null, var message: String? = null)

@Repository
interface UserRepository : JpaRepository<User, Int> {
    fun findByMessageLike(message: String?): List<User>
    fun findByNameIgnoreCaseLike(name: String?): List<User>
}

@Component
class UserLoader(private val userRepository: UserRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        userRepository.save(User(name = "Park",
                message = "I have to make imagination programming for my ... nothing actually."))
        userRepository.save(User(name = "Macro",
                message = "I'm a imagination programming I was built for some purpose of human. " +
                        "To help them or some thing advance maybe."))
        userRepository.save(User(name = "KillerIsDead",
                message = "I Just gonna kill something."))
        userRepository.save(User(name = "Darkness",
                message = "Actually I'm just a shadow. but, " +
                        "People are afraid of me because of they can't see anything without the light."))
    }

}