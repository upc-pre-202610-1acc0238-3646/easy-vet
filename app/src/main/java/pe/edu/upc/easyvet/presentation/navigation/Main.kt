package pe.edu.upc.easyvet.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun Main() {

    val selectedTab = rememberSaveable {
        mutableStateOf(MainTab.Home)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                MainTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab.value == tab,
                        onClick = {
                            selectedTab.value = tab
                        },
                        icon = {
                            Icon(painter = painterResource(tab.resourceId),
                                tab.label)
                        },
                        label = {
                            Text(text = tab.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {

            when (selectedTab.value) {
                MainTab.Home -> HomeNavHost()
                else -> Text(selectedTab.value.label)
            }
        }

    }
}