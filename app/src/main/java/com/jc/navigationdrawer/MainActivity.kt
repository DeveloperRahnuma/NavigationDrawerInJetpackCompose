package com.jc.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jc.navigationdrawer.ui.DrawerBody
import com.jc.navigationdrawer.ui.DrawerHeader
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
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title = { Text(text = stringResource(R.string.app_name))},
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary,
                            navigationIcon = { IconButton(onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }){
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Toggle drawer"
                                )
                            } }
                        )
                    },
                    drawerContent = {
                        Column(modifier = Modifier.fillMaxSize()) {
                            DrawerHeader()
                            DrawerBody(
                                items = listOf(
                                    MenuItem(id = "1", title = "Home", contentDis = "", icon = Icons.Default.Home),
                                    MenuItem(id = "2", title = "Settings", contentDis = "", icon = Icons.Default.Settings),
                                    MenuItem(id = "3", title = "Search", contentDis = "", icon = Icons.Default.Search),
                                    MenuItem(id = "4", title = "Send", contentDis = "", icon = Icons.Default.Send)
                                ),
                                onItemClick = {
                                    println("clicked on ${it.title}")
                                }
                            )
                        }

                    }
                ) {  }
            }
        }
    }
}
