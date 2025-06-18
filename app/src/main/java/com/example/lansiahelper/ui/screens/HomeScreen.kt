package com.example.lansiahelper.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lansiahelper.data.Repository
import com.example.lansiahelper.model.HomeMenuItem
import com.example.lansiahelper.ui.navigation.AppRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val menuItems = listOf(
        HomeMenuItem("Pengingat Obat", Icons.Default.MedicalServices, AppRoutes.MEDICATIONS),
        HomeMenuItem("Kontak Penting", Icons.Default.People, AppRoutes.CONTACTS)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Bantuan Lansia", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) {\ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            EmergencyButton(context)
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                menuItems.forEach { item ->
                    MenuButton(item = item) {
                        navController.navigate(item.route)
                    }
                }
            }
        }
    }
}

@Composable
fun EmergencyButton(context: Context) {
    Button(
        onClick = {
            // Meminta izin CALL_PHONE diperlukan di runtime untuk Android 6.0+
            try {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${Repository.EMERGENCY_NUMBER}"))
                context.startActivity(intent)
            } catch (e: SecurityException) {
                Toast.makeText(context, "Izin menelepon belum diberikan", Toast.LENGTH_LONG).show()
            }
        },
        modifier = Modifier
            .size(200.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error
        ),
        elevation = ButtonDefaults.buttonElevation(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Panggilan Darurat",
                modifier = Modifier.size(80.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "SOS",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MenuButton(item: HomeMenuItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier.size(150.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                modifier = Modifier.size(60.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}
