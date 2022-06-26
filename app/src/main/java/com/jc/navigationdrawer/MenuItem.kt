package com.jc.navigationdrawer

import android.icu.text.CaseMap
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id : String,
    val title : String,
    val icon : ImageVector,
    val contentDis : String,
)