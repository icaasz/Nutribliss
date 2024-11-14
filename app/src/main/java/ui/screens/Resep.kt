package ui.screens

import android.content.ClipDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import ui.components.ButtonBar
import ui.components.TopBar
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Resep(navController: NavController) {
    Scaffold(
        topBar = { TopBar(title = "Resep Clean Eating", navController = navController) }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = androidx.compose.ui.Modifier
                .padding(paddingValues)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(recipes) { index, recipe ->
                RecipeCard(recipe = recipe, onClick = {
                    navController.navigate("resep_detail/${recipe.id}")
                })
            }
        }
    }
}


data class Recipe(val id: Int, val name: String, val description: String, val imageResId: Int, val ingredients: List<String>, val recipe: List<String>)

val recipes = listOf(
    Recipe(1,"Avocado Salad", "Salad dengan alpukat dan sayuran segar", R.drawable.saladalpukat,
        ingredients = listOf("1 buah alpukat", "Tomat", "Lettuce", "Lemon", "Garlic"),
        recipe = listOf("Potong alpukat dan tomat.", "Campurkan semua bahan.", "Tambahkan perasan lemon dan bumbu.")),
    Recipe(2,"Quinoa Bowl", "Quinoa dengan sayur dan kacang almond", R.drawable.quinoa,
        ingredients = listOf("100g Quinoa", "Sayuran (bayam, tomat)", "Almond", "Olive oil"),
        recipe = listOf("Masak quinoa.", "Tumis sayuran.", "Campurkan quinoa dan sayuran.")),
    Recipe(3,"Grilled Chicken", "Ayam panggang dengan sayur", R.drawable.grilledchick,
        ingredients = listOf("2 potong dada ayam", "Sayuran (wortel, brokoli, zucchini)", "Minyak zaitun", "Bumbu BBQ"),
        recipe = listOf("Lumuri ayam dengan bumbu BBQ.", "Panggang ayam hingga matang.", "Tumis sayuran dan sajikan dengan ayam.")),
    Recipe(4,"Zucchini Pasta", "Pasta dari zucchini", R.drawable.zucchini,
        ingredients = listOf("2 buah zucchini", "Bawang putih", "Minyak zaitun", "Keju parmesan"),
        recipe = listOf("Iris zucchini menjadi mie tipis.", "Tumis bawang putih dengan minyak zaitun.", "Tambahkan zucchini dan masak hingga lembut.", "Taburkan keju parmesan di atasnya.")),
    Recipe(5,"Grilled Salmon with Quinoa", "Ayam panggang rendah lemak dengan sayuran segar", R.drawable.grilledsalmon, ingredients = listOf("1 potong fillet salmon", "100g Quinoa", "Sayuran (bayam, wortel)", "Lemon", "Minyak zaitun"),
        recipe = listOf("Panggang fillet salmon dengan sedikit minyak zaitun.", "Masak quinoa.", "Tumis sayuran dan sajikan dengan salmon panggang.")),
    Recipe(6,"Tofu Stir-Fry", "Tumis tahu dengan sayuran", R.drawable.tofu,
        ingredients = listOf("200g tahu", "Sayuran (brokoli, wortel, paprika)", "Kecap asin", "Minyak wijen"),
        recipe = listOf("Tumis tahu hingga kecokelatan.", "Tambahkan sayuran dan kecap asin.", "Tumis hingga semua bahan matang.")),
    Recipe(7,"Oatmeal Bowl", "Oatmeal dengan buah-buahan", R.drawable.oatmeal,
        ingredients = listOf("50g oatmeal", "1 buah pisang", "Beberapa potong stroberi", "Madu", "Susu almond"),
        recipe = listOf("Masak oatmeal dengan susu almond.", "Tambahkan potongan buah dan madu di atasnya.")),
    Recipe(8,"Greek Yogurt Parfait", "Yogurt dengan granola dan buah", R.drawable.greekyougurt,
        ingredients = listOf("200g yogurt Yunani", "Granola", "Blueberry", "Madu"),
        recipe = listOf("Masukkan yogurt ke dalam mangkuk.", "Tambahkan granola dan blueberry di atasnya.", "Teteskan madu di atasnya.")),
    Recipe(9,"Vegetable Soup", "Sup sayur segar", R.drawable.vegetable,
        ingredients = listOf("Wortel", "Brokoli", "Kentang", "Bawang bombay", "Kaldu sayur"),
        recipe = listOf("Tumis bawang bombay.", "Masukkan sayuran dan kaldu, masak hingga empuk.", "Sajikan hangat.")),
    Recipe(10,"Stuffed Bell Peppers", "Paprika isi daging ayam dan sayuran yang rendah kalori", R.drawable.stuffed, ingredients = listOf("4 buah paprika", "200g daging ayam giling", "Bawang putih", "Tomat", "Nasi merah"),
        recipe = listOf("Potong bagian atas paprika dan buang bijinya.", "Tumis bawang putih dan daging ayam.", "Isi paprika dengan campuran ayam dan nasi merah.", "Panggang hingga matang."))
)

@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
            Image(
                painter = painterResource(id = recipe.imageResId),
                contentDescription = recipe.name,
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
            }
            Text(text = recipe.name, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            Text(
                text = recipe.description,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun ResepPreview() {
    MyApplicationTheme {
        val navController = rememberNavController()
        Resep(navController = navController)
    }
}