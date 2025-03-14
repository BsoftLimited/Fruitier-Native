package com.bsoft.fruitier_native.viewmodels

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

private val supabase = createSupabaseClient(
    supabaseUrl = "https://xyzcompany.supabase.co",
    supabaseKey = "your_public_anon_key") {
    install(Auth)
    install(Postgrest)
}

class Repository {
    suspend fun login(email: String, password: String) {
        val auth = supabase.auth

       try {
           auth.signInWith(Email) {
               this.email = email
               this.password = password
           }
       }catch (e: Exception){
           println(e.message)
       }
    }

    suspend fun create(firstName: String, lastName: String, email: String, password: String): UserInfo? {
        val auth = supabase.auth

        try {
            val user = auth.signUpWith(Email) {
                this.email = email
                this.password = password
                this.data = buildJsonObject {
                    put("first_name", firstName)
                    put("last_name", lastName)
                }
            }

            return user!!
        }catch (e: Exception){
            println(e.message)
        }
        return null
    }
}