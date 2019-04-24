package spring.secruity.example.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class MyAuthenticationProvider : AuthenticationProvider {
    companion object {
        val idAndPw = mapOf("admin" to "123", "user" to "456")
        val idAndRole = mapOf("admin" to "ROLE_ADMIN", "user" to "ROLE_USER")
    }


    override fun authenticate(authentication: Authentication): Authentication {
        val authToken = authentication as UsernamePasswordAuthenticationToken

        return when (idAndPw[authToken.principal.toString()] == authToken.credentials.toString()) {
            false -> {

                throw BadCredentialsException("Id & Password are Not Matched")
            }
            true -> {
                val userDetail = MyUserDetail(authToken.principal.toString(), authToken.credentials.toString(), idAndRole[authToken.principal.toString()]!!)
                UsernamePasswordAuthenticationToken(userDetail, userDetail.pw, userDetail.authorities)
            }
        }
    }

    override fun supports(authentication: Class<*>?): Boolean = true
}