package ui.screens

import android.widget.TableRow
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.LightBlue
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.PinkPastel
import ui.components.ButtonBar
import ui.components.TopBar

val poppinsRegular = FontFamily(Font(R.font.poppinsregular))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "About", navController = navController)
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(48.dp))

                val profileImage: Painter = painterResource(id = R.drawable.nisa)
                Image(
                    painter = profileImage,
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .padding(top = 0.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Nama
                Text(
                    text = "Khairunnisa",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsRegular
                )

                // Bio atau Info Tambahan
                Text(
                    text = "Informatika - Politeknik Negeri Batam",
                    fontSize = 14.sp,
                    fontFamily = poppinsRegular,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Detail Informasi lainnya
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    ProfileDetailRow(label = "Email", value = "khairunnisanisa405@gmail.com")
                    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                    ProfileDetailRow(label = "Jurusan", value = "Teknik Informatika")
                    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                    ProfileDetailRow(label = "Program Studi", value = "Teknologi Rekayasa Perangkat Lunak")
                }
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Nutribliss",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsRegular,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Text(
                    text = "Nutribliss adalah aplikasi kesehatan yang dirancang untuk membantu menjalani gaya hidup lebih sehat dengan prinsip \"clean eating\". Nutribliss menawarkan berbagai resep yang difokuskan pada kesehatan, termasuk cemilan sehat, makanan berat, dan minuman yang kaya manfaat. Setiap kategori ressep memberikan saran dan langkah-langkah pembuatan yang mampu membantu menjaga pola makan yang seimbang serta gaya hidup sehat, yang tidak hanya berdampak pada tubuh tetapi juga pada kulit dan kecantikan.",
                    fontSize = 12.sp,
                    fontFamily = poppinsRegular,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Justify
                )
            }
        }
    )
}
@Composable
fun ProfileDetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label ",
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            fontFamily = poppinsRegular,
            color = Color.Gray,
            modifier = Modifier.width(120.dp)
        )
        Text(
            text = value,
            fontSize = 12.sp,
            fontFamily = poppinsRegular,
            color = Color.Black
        )
    }
}



@Preview
@Composable
fun AboutPreview() {
    MyApplicationTheme{
        val navController = rememberNavController()
        About(navController = navController)
    }
}