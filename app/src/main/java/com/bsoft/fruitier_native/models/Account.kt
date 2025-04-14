package com.bsoft.fruitier_native.models

import io.github.jan.supabase.auth.user.UserInfo

data class Account( val userInfo: UserInfo, val profile: Profile)