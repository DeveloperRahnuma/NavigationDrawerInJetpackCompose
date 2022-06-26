package com.jc.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jc.navigationdrawer.ui.DrawerBody
import com.jc.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                val scaffoldState = rememberScaffoldState()
                val scope  = rememberCoroutineScope()

                Scaffold(
                    topBar = { AppBar(
                        onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    )},
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "Home",
                                    title = "Home",
                                    contentDis = "",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "Home",
                                    title = "Home",
                                    contentDis = "",
                                    icon = Icons.Default.Home
                                )
                            ),
                            onItemClick = {
                                println("clicked on ${it.title}")
                            }
                        )
                    }
                ) {  }
            }
        }
    }
}
