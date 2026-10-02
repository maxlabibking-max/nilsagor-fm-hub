package com.nilsagorfmhub.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Bg = Color(0xFF070B18)
private val Card = Color(0xFF10182B)
private val Blue = Color(0xFF36B8FF)
private val Purple = Color(0xFF8B5CF6)
private val Gold = Color(0xFFFFC857)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NilsagorApp() }
    }
}

@Composable
fun NilsagorApp() {
    var page by remember { mutableStateOf(0) }
    MaterialTheme(colorScheme = darkColorScheme(background = Bg, surface = Card, primary = Blue)) {
        Surface(modifier = Modifier.fillMaxSize(), color = Bg) {
            Column(Modifier.fillMaxSize()) {
                Box(Modifier.weight(1f)) {
                    when (page) {
                        0 -> HomePage { page = 1 }
                        1 -> RadioPage()
                        2 -> CommunityPage()
                        else -> AccountPage()
                    }
                }
                BottomBar(page) { page = it }
            }
        }
    }
}

@Composable
fun Header(title: String, subtitle: String? = null) {
    Column(Modifier.padding(horizontal = 20.dp, vertical = 18.dp)) {
        Text(title, color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        subtitle?.let { Text(it, color = Color.LightGray, fontSize = 13.sp, modifier = Modifier.padding(top = 4.dp)) }
    }
}

@Composable
fun HomePage(openRadio: () -> Unit) {
    LazyColumn(contentPadding = PaddingValues(bottom = 24.dp)) {
        item { Header("Nilsagor FM Hub", "Music • News • Community") }
        item {
            Card(Modifier.padding(horizontal = 16.dp).fillMaxWidth().clickable { openRadio() }, shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = Card)) {
                Column(Modifier.padding(22.dp)) {
                    Text("● LIVE NOW", color = Gold, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    Text("Nilsagor FM", color = Color.White, fontSize = 23.sp, fontWeight = FontWeight.Bold)
                    Text("Feel the real Bangla vibe", color = Color.LightGray)
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = openRadio, colors = ButtonDefaults.buttonColors(containerColor = Blue)) { Text("▶  Listen Live") }
                }
            }
        }
        item { SectionTitle("Quick Access") }
        item { QuickRow("🎵", "Live Radio", "Listen now") { openRadio() } }
        item { QuickRow("📰", "Latest News", "Updates & stories") {} }
        item { QuickRow("👥", "Community", "Posts and discussions") {} }
        item { SectionTitle("Latest Posts") }
        items(listOf("Welcome to Nilsagor FM Hub", "Live music is coming soon", "Stay connected with the community")) { text -> PostCard(text) }
    }
}

@Composable
fun SectionTitle(text: String) { Text(text, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp, 22.dp, 20.dp, 10.dp)) }

@Composable
fun QuickRow(icon: String, title: String, sub: String, onClick: () -> Unit) {
    Row(Modifier.padding(horizontal = 16.dp, vertical = 5.dp).fillMaxWidth().background(Card, RoundedCornerShape(16.dp)).clickable { onClick() }.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 25.sp); Spacer(Modifier.width(14.dp)); Column(Modifier.weight(1f)) { Text(title, color = Color.White, fontWeight = FontWeight.SemiBold); Text(sub, color = Color.Gray, fontSize = 12.sp) }; Text("›", color = Blue, fontSize = 28.sp)
    }
}

@Composable
fun RadioPage() {
    Column(Modifier.fillMaxSize()) {
        Header("Live Radio", "Nilsagor FM Hub")
        Spacer(Modifier.height(35.dp))
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Box(Modifier.size(210.dp).background(Card, RoundedCornerShape(105.dp)), contentAlignment = Alignment.Center) {
                Text("🎙️", fontSize = 64.sp)
            }
        }
        Spacer(Modifier.height(24.dp))
        Text("Nilsagor FM", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
        Text("Ready to play", color = Color.Gray, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(24.dp))
        Button(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(containerColor = Blue)) { Text("▶  PLAY LIVE") }
        Text("Stream URL can be connected from Admin Panel", color = Color.Gray, fontSize = 12.sp, modifier = Modifier.padding(28.dp).align(Alignment.CenterHorizontally))
    }
}

@Composable
fun CommunityPage() {
    LazyColumn(contentPadding = PaddingValues(bottom = 24.dp)) {
        item { Header("Community", "Connect with Nilsagor FM Hub") }
        items(listOf("What are you listening to today?", "Welcome everyone!", "Nilsagor FM Hub community")) { PostCard(it) }
    }
}

@Composable
fun PostCard(text: String) {
    Card(Modifier.padding(horizontal = 16.dp, vertical = 6.dp).fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Card), shape = RoundedCornerShape(18.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text("Nilsagor FM Hub", color = Blue, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp)); Text(text, color = Color.White)
            Spacer(Modifier.height(12.dp)); Text("♡  Like    💬 Comment    ↗ Share", color = Color.LightGray, fontSize = 13.sp)
        }
    }
}

@Composable
fun AccountPage() {
    LazyColumn {
        item { Header("Account", "Your Nilsagor FM Hub profile") }
        item { QuickRow("👤", "Profile", "Sign in to continue") {} }
        item { QuickRow("⚙️", "Settings", "App preferences") {} }
        item { QuickRow("🛠️", "Admin Panel", "Manage website and radio") {} }
        item { QuickRow("ℹ️", "About", "Nilsagor FM Hub") {} }
    }
}

@Composable
fun BottomBar(selected: Int, onSelect: (Int) -> Unit) {
    NavigationBar(containerColor = Color(0xFF0A1020)) {
        listOf("⌂" to "Home", "▶" to "Radio", "👥" to "Community", "●" to "Account").forEachIndexed { i, item ->
            NavigationBarItem(selected = selected == i, onClick = { onSelect(i) }, icon = { Text(item.first, fontSize = 20.sp) }, label = { Text(item.second) })
        }
    }
}
