package com.nilsagorfmhub.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
    var tab by remember { mutableStateOf(0) }
    MaterialTheme(colorScheme = darkColorScheme(primary = Blue, background = Bg, surface = Card)) {
        Surface(modifier = Modifier.fillMaxSize(), color = Bg) {
            Column(Modifier.fillMaxSize()) {
                Box(Modifier.weight(1f)) {
                    when (tab) {
                        0 -> HomePage()
                        1 -> RadioPage()
                        2 -> CommunityPage()
                        else -> AccountPage()
                    }
                }
                BottomBar(tab) { tab = it }
            }
        }
    }
}

@Composable
fun HomePage() {
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Nilsagor FM Hub", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("বাংলাদেশের অনলাইন রেডিও ও কমিউনিটি", color = Color.LightGray, fontSize = 14.sp)
        Spacer(Modifier.height(22.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Card), shape = RoundedCornerShape(24.dp)) {
            Column(Modifier.padding(20.dp)) {
                Text("● LIVE NOW", color = Gold, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                Text("Nilsagor FM", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("আপনার পছন্দের গান ও অনুষ্ঠান শুনুন", color = Color.LightGray)
                Spacer(Modifier.height(16.dp))
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Blue)) { Text("▶  Listen Live") }
            }
        }
        Spacer(Modifier.height(20.dp))
        Text("Quick Access", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Quick("📻", "Radio", Modifier.weight(1f))
            Quick("👥", "Community", Modifier.weight(1f))
        }
        Spacer(Modifier.height(20.dp))
        Text("Latest Posts", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Post("Nilsagor FM Hub", "আজকের লাইভ অনুষ্ঠান উপভোগ করুন 🎧")
    }
}

@Composable fun Quick(icon: String, title: String, modifier: Modifier) {
    Card(modifier, colors = CardDefaults.cardColors(containerColor = Card), shape = RoundedCornerShape(18.dp)) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) { Text(icon, fontSize = 28.sp); Text(title, color = Color.White) }
    }
}

@Composable fun Post(name: String, text: String) {
    Card(colors = CardDefaults.cardColors(containerColor = Card), shape = RoundedCornerShape(18.dp)) {
        Column(Modifier.padding(16.dp)) { Text(name, color = Blue, fontWeight = FontWeight.Bold); Spacer(Modifier.height(6.dp)); Text(text, color = Color.White) }
    }
}

@Composable
fun RadioPage() {
    var playing by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(35.dp)); Text("LIVE RADIO", color = Gold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(Modifier.height(20.dp)); Text("Nilsagor FM", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(if (playing) "Now Playing" else "Ready to play", color = Color.LightGray)
        Spacer(Modifier.height(45.dp))
        Box(Modifier.size(210.dp).background(Purple.copy(alpha=.35f), CircleShape), contentAlignment = Alignment.Center) {
            Button(onClick = { playing = !playing }, modifier = Modifier.size(120.dp), shape = CircleShape, colors = ButtonDefaults.buttonColors(containerColor = Blue)) { Text(if (playing) "❚❚" else "▶", fontSize = 28.sp) }
        }
        Spacer(Modifier.height(30.dp)); Text("Stream link can be connected from the admin system.", color = Color.Gray, fontSize = 13.sp)
    }
}

@Composable fun CommunityPage() {
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Community", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold); Spacer(Modifier.height(16.dp))
        Post("Admin", "Nilsagor FM Hub কমিউনিটিতে স্বাগতম!")
        Spacer(Modifier.height(10.dp)); Post("Nilsagor FM", "আপনার মতামত ও পোস্ট এখানে শেয়ার করুন।")
    }
}

@Composable fun AccountPage() {
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Account", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold); Spacer(Modifier.height(20.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Card), shape = RoundedCornerShape(20.dp)) {
            Column(Modifier.padding(20.dp)) { Text("Guest User", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold); Text("Google login can be connected later", color = Color.Gray) }
        }
        Spacer(Modifier.height(15.dp)); Row(Modifier.fillMaxWidth().padding(8.dp)) { Text("⚙  Settings", color = Color.White, fontSize = 17.sp) }
        Row(Modifier.fillMaxWidth().padding(8.dp)) { Text("🛡  Admin Panel", color = Color.White, fontSize = 17.sp) }
        Row(Modifier.fillMaxWidth().padding(8.dp)) { Text("ℹ  About Nilsagor FM Hub", color = Color.White, fontSize = 17.sp) }
    }
}

@Composable fun BottomBar(selected: Int, onSelect: (Int) -> Unit) {
    NavigationBar(containerColor = Card) {
        listOf("⌂" to "Home", "◉" to "Radio", "♟" to "Community", "●" to "Account").forEachIndexed { i, item ->
            NavigationBarItem(selected = selected == i, onClick = { onSelect(i) }, icon = { Text(item.first, fontSize = 20.sp) }, label = { Text(item.second) })
        }
    }
}
