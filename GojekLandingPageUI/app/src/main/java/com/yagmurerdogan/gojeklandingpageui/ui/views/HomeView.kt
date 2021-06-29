package com.yagmurerdogan.gojeklandingpageui.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yagmurerdogan.gojeklandingpageui.AppScreen
import com.yagmurerdogan.gojeklandingpageui.ui.base.AppTabBar
import com.yagmurerdogan.gojeklandingpageui.ui.base.AppTabs

@ExperimentalMaterialApi
@Composable
fun HomeView() {
    var tabSelected by remember { mutableStateOf(AppScreen.Home) }
    BackdropScaffold(
        appBar = {
            HomeTabBar(tabSelected, onTabSelected = { tabSelected = it })
        },
        backLayerContent = { },
        frontLayerContent = {
            when (tabSelected) {
                AppScreen.Promo -> PromoScreen()
                AppScreen.Home -> HomeScreen()
                AppScreen.Chat -> ChatScreen()
            }
        }
    )
}

@Composable
fun HomeTabBar(
    tabSelected: AppScreen,
    onTabSelected: (AppScreen) -> Unit
) {
    AppTabBar(
        modifier = Modifier.padding(top = 8.dp)
    ) { tabBarModifier ->
        AppTabs(
            modifier = tabBarModifier,
            titles = AppScreen.values().map { it.name },
            tabSelected = tabSelected,
            onTabSelected = { newTab -> onTabSelected(AppScreen.values()[newTab.ordinal]) }
        )
    }
}
