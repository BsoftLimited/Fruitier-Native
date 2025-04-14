package com.bsoft.fruitier_native.utils

import androidx.compose.foundation.layout.Column
import com.bsoft.fruitier_native.models.Account
import com.bsoft.fruitier_native.models.Profile
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.serializer.KotlinXSerializer

private val supabase = createSupabaseClient(
    supabaseUrl = "https://xyzcompany.supabase.co",
    supabaseKey = "your_public_anon_key") {
    defaultSerializer = KotlinXSerializer()
    install(Auth)
    install(Postgrest)
}

class Repository {
    private val auth = supabase.auth

    private suspend fun fetchProfile(id: String): Profile?{
        try {
            val results = supabase.postgrest.from("profiles").select()

            return results.decodeList<Profile>().find { it.id == id }
        }catch (e: Exception){
            throw e;
        }
    }

    suspend fun login(email: String, password: String): Account? {
        try {
            auth.signInWith(Email) {
               this.email = email
               this.password = password
            }
            val userInfo = auth.currentUserOrNull()!!
            val profile = fetchProfile(userInfo.id)!!

            return Account( userInfo, profile )
        }catch (e: Exception){
           println(e.message)
        }
        return null
    }

    suspend fun create(firstName: String, lastName: String, userName: String, email: String, password: String): Account? {
        try {
            val user = auth.signUpWith(Email) {
                this.email = email
                this.password = password
                this.data = buildJsonObject {
                    put("user_name", userName)
                    put("first_name", firstName)
                    put("last_name", lastName)
                }
            }
            val profile = fetchProfile(user!!.id)!!

            return Account( userInfo = user, profile )
        }catch (e: Exception){
            println(e.message)
        }
        return null
    }
}