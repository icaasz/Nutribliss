package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import ui.components.ButtonBar
import ui.components.TopBar

@Composable
fun SnackDetail(snackId: Int, navController: NavController) {
    // Mencari snack berdasarkan id
    val snack = snacks.find { it.id == snackId }

    if (snack != null) {
        Scaffold(
            topBar = {
                TopBar(title = snack.name, navController = navController)
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Gambar Cemilan
                Image(
                    painter = painterResource(id = snack.imageResId),
                    contentDescription = snack.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(bottom = 16.dp)
                )

                // Nama Cemilan
                Text(
                    text = snack.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                // Menampilkan bahan-bahan
                Text(
                    text = "Bahan-bahan:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )
                snack.ingredients.forEachIndexed { index, ingredient ->
                    Text(
                        text = "${index + 1}. $ingredient",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
                // Langkah-langkah Resep
                Text(
                    text = "Langkah-langkah:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )
                snack.recipe.forEachIndexed { index, step ->
                    Text(
                        text = "${index + 1}. $step",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    } else {
        Text(text = "Snack tidak ditemukan", color = Color.Red)
    }
}

@Preview
@Composable
fun SnackDetailPreview(){
    MyApplicationTheme {
        SnackDetail(snackId = 1, navController = rememberNavController())
    }
}
