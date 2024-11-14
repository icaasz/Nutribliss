package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.PinkDark
import ui.components.ButtonBar
import ui.components.TopBar

val poppinsBold = FontFamily(Font(R.font.poppinsbold, FontWeight.Bold))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "Nutribliss", navController = navController)
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {
            // Judul untuk LazyRow
            Text(
                text = "Cemilan Sehat",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = PinkDark,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(snacks) { snack ->
                    SnackCard(snack = snack, navController = navController)
                }
            }

            // LazyColumn untuk minum
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        text = "Hidrasi & Nutrisi untuk Kulit",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = PinkDark,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
                items(juices) { juice ->
                    JuiceCard(juice = juice, navController = navController)
                }
            }
        }
    }
}

data class Juice(val id: Int, val name: String, val benefit: String, val imageResId: Int, val ingredients: List<String>, val recipe: List<String>)

val juices = listOf(
    Juice(1,"Lemon Cucumber Detox Water", "Melembapkan kulit dan membantu detoksifikasi tubuh", R.drawable.infusedwater, ingredients = listOf(
        "1 buah lemon",
        "1/2 mentimun",
        "1 liter air",
        "Daun mint (opsional)"),
        recipe = listOf(
            "Potong lemon dan mentimun menjadi irisan tipis.",
            "Tambahkan irisan lemon dan mentimun ke dalam air.",
            "Tambahkan daun mint jika diinginkan.",
            "Dinginkan di dalam kulkas selama beberapa jam sebelum diminum."
        )
    ),
    Juice(2,"Jus Wortel & Jeruk", "mencegah keriput dan menjaga kulit tetap kenyal serta bercahaya", R.drawable.jeruk, ingredients = listOf(
        "3 wortel",
        "2 jeruk",
        "1/2 cm jahe (opsional)"
    ),
        recipe = listOf(
            "Kupas wortel dan potong menjadi potongan kecil.",
            "Peras jeruk untuk mendapatkan sarinya.",
            "Campur wortel, sari jeruk, dan jahe (jika menggunakan) dalam blender.",
            "Blender hingga halus dan saring jika diinginkan."
        )
    ),
    Juice(3,"Jus Tomat", "mencerahkan kulit dan membantu mengurangi jerawat", R.drawable.tomat, ingredients = listOf(
        "2 tomat matang",
        "1/2 mentimun",
        "Sedikit garam dan lada (opsional)"
    ),
        recipe = listOf(
            "Potong tomat dan mentimun menjadi beberapa bagian.",
            "Masukkan tomat dan mentimun ke dalam blender.",
            "Blender hingga halus, lalu tambahkan garam dan lada jika diinginkan.",
            "Saring jus sebelum disajikan."
        )
    ),
    Juice(4,"Jus Timun & Seledri", "membantu detoksifikasi", R.drawable.timun, ingredients = listOf(
        "1 buah mentimun",
        "2 batang seledri",
        "1 buah apel hijau",
        "1/2 lemon"
    ),
        recipe = listOf(
            "Potong mentimun, seledri, dan apel menjadi potongan kecil.",
            "Peras lemon dan tambahkan sarinya ke bahan lainnya.",
            "Masukkan semua bahan ke dalam blender dan proses hingga halus.",
            "Saring jus sebelum diminum."
        )
    ),
    Juice(5,"Jus Alpukat & Kiwi", "menghidrasi kulit dan mencegah tanda-tanda penuaan", R.drawable.alpukat, ingredients = listOf(
        "1 buah alpukat",
        "2 buah kiwi",
        "200 ml air kelapa",
        "Madu (opsional)"
    ),
        recipe = listOf(
            "Kupas dan potong alpukat dan kiwi.",
            "Masukkan potongan alpukat dan kiwi ke dalam blender.",
            "Tambahkan air kelapa dan madu jika diinginkan.",
            "Blender hingga halus dan sajikan segera."
        )
    ),
    Juice(6,"Jus Pepaya & Nanas", "membantu kulit lebih cerah, halus, dan bebas dari bintik hitam", R.drawable.pepaya, ingredients = listOf(
        "1/2 buah pepaya",
        "1/4 buah nanas",
        "200 ml air",
        "Es batu (opsional)"
    ),
        recipe = listOf(
            "Kupas pepaya dan nanas, lalu potong menjadi potongan kecil.",
            "Masukkan potongan pepaya dan nanas ke dalam blender.",
            "Tambahkan air dan es batu jika diinginkan.",
            "Blender hingga halus dan sajikan segera."
        )
    ),
    Juice(7,"Jus Bit & Apel", "memberi kulit yang lebih sehat dan bercahaya", R.drawable.bit, ingredients = listOf(
        "1 buah bit",
        "1 buah apel",
        "1/2 buah lemon"
    ),
        recipe = listOf(
            "Kupas bit dan potong menjadi potongan kecil.",
            "Potong apel dan buang bijinya.",
            "Peras lemon dan tambahkan sarinya ke bahan lainnya.",
            "Masukkan bit, apel, dan jus lemon ke dalam blender dan proses hingga halus.",
            "Saring jus sebelum disajikan."
        )
    ),
    Juice(8,"Jus Mangga & Wortel", "kaya akan vitamin A untuk kulit", R.drawable.manggaapel, ingredients = listOf(
        "1 buah mangga matang",
        "2 wortel",
        "200 ml air"
    ),
        recipe = listOf(
            "Kupas mangga dan potong menjadi potongan kecil.",
            "Kupas wortel dan potong menjadi potongan kecil.",
            "Masukkan mangga dan wortel ke dalam blender bersama air.",
            "Blender hingga halus dan saring jika diinginkan."
        )
    ),
    Juice(9,"Jus Delima", "meningkatkan produksi kolagen", R.drawable.delima, ingredients = listOf(
        "1 buah delima",
        "1 buah jeruk",
        "200 ml air"
    ),
        recipe = listOf(
            "Belah delima dan ambil biji-bijinya.",
            "Peras jeruk untuk mendapatkan sarinya.",
            "Masukkan biji delima dan sari jeruk ke dalam blender bersama air.",
            "Blender hingga halus dan saring sebelum disajikan."
        )),
    Juice(10,"Berry Smoothie", "membantu hidrasi dan proses detoksifikasi", R.drawable.berry, ingredients = listOf(
        "1/2 cangkir stroberi",
        "1/2 cangkir blueberry",
        "1/2 cangkir yogurt plain",
        "200 ml air atau susu almond",
        "Madu (opsional)"
    ),
        recipe = listOf(
            "Masukkan stroberi, blueberry, yogurt, dan air/susu almond ke dalam blender.",
            "Tambahkan madu jika diinginkan.",
            "Blender hingga halus dan sajikan segera."
        )
    )
)

data class Snack(val id: Int, val name: String, val imageResId: Int, val recipe: List<String>, val ingredients: List<String>)

val snacks = listOf(
    Snack(1,"Avocado Toast", R.drawable.avocado, recipe = listOf(
        "Panggang roti selama 2 menit",
        "Hancurkan buat Alpukat",
        "Tambahkan topping alpukat seusai selera diatas roti"
    ),
        ingredients = listOf(
            "Alpukat",
            "Garam",
            "Bubuk Lada Hitam",
            "Roti tawar gandum",
            "Topping sesuai selera (misalnya, tomat, garam, dan merica)"
        )
    ),
    Snack(2,"Chia Pudding", R.drawable.chia, recipe = listOf(
        "campur semua bahan menjadi satu dalam wadah",
        "setelah semua tercampur, tutup wadah dan masukkan ke kulkas",
        "Diamkan selama semalaman",
        "Sajikan dengan tambahan topping irisan buah segar atau kacang"
    ),
        ingredients = listOf(
            "1/3 cangkir biji chia putih",
            "1 1/2 cangkir susu",
            "2 sdm sirup maple atau madu",
            "1/2 sdt ekstrak vanilla atau cokelat",
            "Buah segar(opsional, sesuai selera) atau potongan kacang sebagi topping"
        )
    ),
    Snack(3,"Almonds & Walnuts", R.drawable.almond, recipe = listOf(
        "Untuk cemilan simple ini tidak perlu diolah, kamu hanya perlu memakannya saja seperti biasa",
    ),
        ingredients = listOf(
            "Almonds dan Walnuts"
        )
    ),
    Snack(4,"Apple Slices with Peanut Butter", R.drawable.apple, recipe = listOf(
        "Buang inti dan potong apel menjadi irisan",
        "Oles dengan selai kacang"
    ),
        ingredients = listOf(
            "Apel",
            "Selai Kacang"
        )
    ),
    Snack(5,"Carrot Sticks with Hummus", R.drawable.carrot, recipe = listOf(
        "Masukkan wortel yang sudah matang ke dalam blender",
        "Haluskan hingga lembut",
        "Tambahkan hummus dan jinten",
        "Pastikan sudah tercampur rata, lalu simpan di lemari es selama 1 jam"
    ),
        ingredients = listOf(
            "Wortel",
            "Teh jinten bubuk",
            "Hummus polos",
            "Seledri",
            "Paprika",
            "Mentimun tanpa biji"
        )
    ),
    Snack(6,"Baked Sweet Potato Fries", R.drawable.pottato, recipe = listOf(
        "Kupas ubi dan potong memanjang, cuci bersih dan rendam di air selama 1 jam",
        "Tiriskan, lalu masukkan ke wadah beri campuran maizena",
        "Masukkan bumbu kering & olive oil, aduk sampai rata",
        "Bakar dalam oven selama 30 menit"
    ),
        ingredients = listOf(
            "2 buah ubi kentang",
            "2 sdm tepung maizena",
            "1 sdm olive oil",
            "1/2 sdt merica",
            "1/2 sdt paprika bubuk",
            "1/2 sdt bawang putih bubuk",
            "1/2 sdt gula merah bubuk",
            "1/2 sdt garam",
            "1/2 sdt kaldu bubuk"
        )
    ),
    Snack(7,"Rice Cake with Almond Butter", R.drawable.rice, recipe = listOf(
        "Oleskan selai kacang pada kue beras",
        "Taburi dengan irisan pisang",
        "Taburi dengan kayu manis"
    ),
        ingredients = listOf(
            "1 kue beras merah",
            "2 sdm mentega almond",
            "1 pisang",
            "Kayu manis"
        )
    ),
    Snack(8,"Cucumber & Guacamole", R.drawable.cucumber, recipe = listOf(
        "Haluskan alpukat",
        "Campur semua bahan dan aduk rata",
        "Sajikan bersama timun atau selada"
    ),
        ingredients = listOf(
            "1 buah alpukat",
            "1/4 jeruk lemon",
            "1/4 bawang bombai",
            "Sejumput garam",
            "1 sdt biji wijen"
        )
    ),
    Snack(9,"Greek Yogurt with Honey", R.drawable.greekhoney, recipe = listOf(
        "Campur greek yougurt dengan madu dan siap dinikmati"
    ),
        ingredients = listOf(
            "Secukupnya plain greek yougurt",
            "Secukupnya madu"
        )
    ),
    Snack(10,"Hard-Boiled Eggs", R.drawable.eggs, recipe = listOf(
        "Masukkan telur ke dalam air mendidih",
        "Rebus selama 10 menit",
        "Angkat telur dan masukkan ke air dingin",
        "Siap dihidangkan"
    ),
        ingredients = listOf(
            "2 buah telur ayam",
            "1 ltr air",
            "300 ml air dingin"
        )
    )
)


@Composable
fun SnackCard(snack: Snack, navController: NavController) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(200.dp)
            .padding(8.dp)
            .clickable { navController.navigate("snackDetail/${snack.id}") },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = snack.imageResId),
                contentDescription = snack.name,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = snack.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun JuiceCard(juice: Juice, navController: NavController) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("juiceDetail/${juice.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                text = juice.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
            )
                Text(
                    text = juice.benefit,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            Image(
                painter = painterResource(id = juice.imageResId),
                contentDescription = juice.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}



@Preview
@Composable
fun HomePreview() {
    val navController = rememberNavController() // Membuat instance NavController
    MyApplicationTheme {
        // Menambahkan NavHost untuk mendukung navigasi
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { Home(navController = navController) }
            // Rute lainnya jika perlu, misalnya:
            composable("snackDetail/{snackId}") { backStackEntry ->
                // Menampilkan detail snack
            }
            composable("juiceDetail/{juiceId}") { backStackEntry ->
                // Menampilkan detail juice
            }
        }
    }
}