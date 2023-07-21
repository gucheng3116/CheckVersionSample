package com.gucheng.checkversion

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gucheng.checkversion.ui.theme.CheckVersionSampleTheme

class MainActivity : ComponentActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckVersionSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        var versionName:String? = null
        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            versionName = packageInfo.versionName
            Log.d("Donald", "versionName is $versionName")
        } catch (e: PackageManager.NameNotFoundException) {
            Log.e(TAG, "error is ${e.message}")
        }
        VersionChecker().checkVersion(
            this,
            packageManager,
            versionName,
            "gucheng3116",
            "StatisticHelperRelease"
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier.padding(all =8.dp)) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckVersionSampleTheme {
        Greeting("Android")
    }
}