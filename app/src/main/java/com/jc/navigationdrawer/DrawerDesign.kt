package com.jc.navigationdrawer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.navigationdrawer.MenuItem

@Composable
fun DrawerHeader(){
    Box(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f).background(Color.Blue),
        ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Header", fontSize = 60.sp)
        }

    }
}


@Composable
fun DrawerBody(
    items : List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle : TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick : (MenuItem) -> Unit
){

    LazyColumn(modifier){
        items(items){ item ->
            Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {
                onItemClick(item)
            },){
                Icon(imageVector = item.icon,contentDescription = item.contentDis )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}