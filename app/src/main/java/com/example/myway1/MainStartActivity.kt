package com.example.myway1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myway1.R.*
import com.example.myway1.ui.theme.MyWay1Theme


class MainStartActivity : ComponentActivity() {

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWay1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                  //  MyScaffold()
                    Greeting2("Gregor")

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier ) {

    val padding = 16.dp

    Column (
        Modifier
            .padding(padding)
            //.clickable(onClick = onClick)
            .fillMaxWidth()

    ){
        Text(
            text = stringResource(R.string.ansprache    ),
            color = Color.White
        )
        Divider(color = colorResource(R.color.white))
        Spacer ( Modifier.requiredHeight (50. dp ) )
        Text(
            text = stringResource(R.string.frage1) ,
            color = Color.White
        )
        Divider(color = colorResource(R.color.white))
        Spacer ( Modifier.requiredHeight (10. dp ) )
        Text(
            text = stringResource(R.string.frage2 ),
            color = Color.White
        )

    }


}


