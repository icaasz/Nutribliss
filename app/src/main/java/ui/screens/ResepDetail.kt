package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ui.components.ButtonBar
import ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResepDetail(navController: NavController, recipeId: Int) {
    val recipe = recipes.find { it.id == recipeId }

    Scaffold(
        topBar = {
            TopBar(title = "Detail Resep", navController = navController)
        }
    ) { paddingValues ->
        recipe?.let { recipe ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Gambar Resep
                Image(
                    painter = painterResource(id = recipe.imageResId),
                    contentDescription = recipe.name,
                    modifier = Modifier.size(300.dp)
                        .align(Alignment.CenterHorizontally) // Gambar di tengah
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Nama Resep
                Text(
                    text = recipe.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center // Nama di tengah
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Deskripsi Resep
                Text(
                    text = recipe.description,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start // Deskripsi di kiri
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Menampilkan bahan-bahan
                Text(
                    text = "Bahan-bahan:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))
                recipe.ingredients.forEach { ingredient ->
                    Text(
                        text = "- $ingredient",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Start
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Langkah-langkah Resep
                Text(
                    text = "Langkah-langkah:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))
                recipe.recipe.forEachIndexed { index, step ->
                    Text(
                        text = "${index + 1}. $step",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Start
                    )
                }
            }
        } ?: run {
            Text(
                text = "Resep tidak ditemukan",
                color = Color.Red,
                modifier = Modifier.fillMaxSize(),
                style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp)
            )
        }
    }
}