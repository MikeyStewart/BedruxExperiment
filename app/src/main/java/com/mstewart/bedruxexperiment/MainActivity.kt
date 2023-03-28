package com.mstewart.bedruxexperiment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.mstewart.bedruxexperiment.arch.dummyData
import com.mstewart.bedruxexperiment.arch.mapJsonToScreens
import com.mstewart.bedruxexperiment.ui.theme.BedruxExperimentTheme
import com.mstewart.bedruxexperiment.ui.views.AppScaffold
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

        val appConfigJson = MutableStateFlow("")

        remoteConfig.apply {
            fetchAndActivate()
                .addOnCompleteListener {
                    appConfigJson.update {
                        this.getString("app_config")
                    }
                }
        }

        setContent {
            BedruxExperimentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO: Move to repository
//                    val screens = mapJsonToScreens(dummyData)
                    val appState = appConfigJson.collectAsState()
                    val screens = mapJsonToScreens(appState.value)

                    AppScaffold(screens)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BedruxExperimentTheme {
        // TODO: Move to repository
        val screens = mapJsonToScreens(dummyData)

        AppScaffold(screens)
    }
}