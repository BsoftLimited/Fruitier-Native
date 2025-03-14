package com.bsoft.fruitier_native

import android.net.http.HttpResponseCache.install
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bsoft.fruitier_native.ui.Main
import dagger.hilt.android.AndroidEntryPoint
import

val supabase = createSupabaseClient(
    supabaseUrl = "https://xyzcompany.supabase.co",
    supabaseKey = "your_public_anon_key"
) {
    install(Postgrest)
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            Main()
        }
    }
}