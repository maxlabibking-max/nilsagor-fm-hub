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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
private val Bg=Color(0xFF050B18); private val Card=Color(0xFF0D1A31); private val Blue=Color(0xFF149CFF); private val Purple=Color(0xFF7C4DFF); private val Gold=Color(0xFFFFC107)
class MainActivity:ComponentActivity(){override fun onCreate(b:Bundle?){super.onCreate(b);setContent{App()}}}
@Composable fun App(){var tab by remember{mutableIntStateOf(0)};MaterialTheme{Scaffold(containerColor=Bg,bottomBar={NavigationBar(containerColor=Color(0xFF071225)){listOf("Home","Radio","Community","Profile").forEachIndexed{i,t->NavigationBarItem(tab==i,{tab=i},{},label={Text(t)})}}}){p->Box(Modifier.fillMaxSize().padding(p)){when(tab){0->Home();1->Radio();2->Community();3->Profile()}}}}}
@Composable fun Head(t:String){Row(Modifier.fillMaxWidth().padding(18.dp),verticalAlignment=Alignment.CenterVertically){Text("N",color=Gold,fontSize=26.sp,modifier=Modifier.background(Color(0xFF152B4A),CircleShape).padding(10.dp));Spacer(Modifier.width(12.dp));Text(t,color=Color.White,fontSize=22.sp);Spacer(Modifier.weight(1f));Text("⋮",color=Color.White,fontSize=28.sp)}}
@Composable fun Home(){Column{Head("Nilsagor FM Hub");Column(Modifier.padding(16.dp)){Card(colors=CardDefaults.cardColors(Card),shape=RoundedCornerShape(24.dp)){Box(Modifier.fillMaxWidth().background(Brush.linearGradient(listOf(Color(0xFF0A315B),Color(0xFF20104A))).let{it}).padding(22.dp)){Column{Text("● LIVE NOW",color=Color(0xFFFF4D67));Text("Nilsagor FM 24/7",color=Color.White,fontSize=26.sp);Text("Bangla Songs • News • Talk",color=Color.LightGray);Spacer(Modifier.height(16.dp));Button({},colors=ButtonDefaults.buttonColors(Gold)){Text("▶ Listen Live",color=Color.Black)}}}};Spacer(Modifier.height(20.dp));Text("Latest Posts",color=Color.White,fontSize=19.sp);Spacer(Modifier.height(10.dp));Post("Nilsagor FM Hub","বাংলার আকাশে নীলসাগরের সুর 💙")}}}
@Composable fun Post(n:String,b:String){Card(Modifier.fillMaxWidth(),colors=CardDefaults.cardColors(Card),shape=RoundedCornerShape(18.dp)){Column(Modifier.padding(16.dp)){Text(n,color=Gold);Spacer(Modifier.height(8.dp));Text(b,color=Color.White,fontSize=16.sp);Spacer(Modifier.height(12.dp));Text("♡ Like    ○ Comment    ↗ Share",color=Color.LightGray)}}}
@Composable fun Radio(){Column(Modifier.fillMaxSize(),horizontalAlignment=Alignment.CenterHorizontally){Head("Live Radio");Spacer(Modifier.height(35.dp));Box(Modifier.size(220.dp).background(Brush.radialGradient(listOf(Purple,Blue,Bg)),CircleShape),contentAlignment=Alignment.Center){Box(Modifier.size(150.dp).background(Bg,CircleShape),contentAlignment=Alignment.Center){Text("N",color=Gold,fontSize=58.sp)}};Spacer(Modifier.height(22.dp));Text("Nilsagor FM 24/7",color=Color.White,fontSize=24.sp);Text("Now Playing • Live",color=Color.LightGray);Spacer(Modifier.height(20.dp));Button({},colors=ButtonDefaults.buttonColors(Purple)){Text("▶ PLAY")}}}
@Composable fun Community(){Column{Head("Community");Column(Modifier.padding(16.dp)){Post("Dx Labib","Nilsagor FM Hub এখন আমাদের সবার কমিউনিটি ❤️");Spacer(Modifier.height(12.dp));Post("Nilsagor FM Hub","আজকের লাইভ শো শুনতে Radio ট্যাবে যাও 🎧")}}}
@Composable fun Profile(){Column(Modifier.fillMaxSize(),horizontalAlignment=Alignment.CenterHorizontally){Head("My Profile");Spacer(Modifier.height(25.dp));Box(Modifier.size(100.dp).background(Brush.linearGradient(listOf(Blue,Purple)),CircleShape),contentAlignment=Alignment.Center){Text("D",color=Color.White,fontSize=42.sp)};Spacer(Modifier.height(15.dp));Text("Dx Labib",color=Color.White,fontSize=24.sp);Text("Nilsagor FM Hub Community",color=Color.LightGray);Spacer(Modifier.height(25.dp));OutlinedButton({},Modifier.fillMaxWidth().padding(horizontal=24.dp)){Text("Settings")};OutlinedButton({},Modifier.fillMaxWidth().padding(horizontal=24.dp)){Text("Admin Panel",color=Gold)}}}
