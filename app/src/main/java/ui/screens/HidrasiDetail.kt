package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
fun HidrasiDetail(juiceId: Int, navController: NavController) {
    val juice = juices.find { it.id == juiceId }

    juice?.let { juice ->

        Scaffold(
            topBar = {
                TopBar(
                    title = "Detail",
                    navController = navController // Correct placement of the back action
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = juice.imageResId),
                    contentDescription = juice.name,
                    modifier = Modifier.size(200.dp),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = juice.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Manfaat:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = juice.benefit,
                    fontSize = 16.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Bahan:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))
                juice.ingredients.forEach { ingredient ->
                    Text(
                        text = "- $ingredient",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Start
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Langkah-langkah:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))
                juice.recipe.forEachIndexed { index, step ->
                    Text(
                        text = "${index + 1}. $step",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Start
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HidrasietailPreview(){
    MyApplicationTheme {
        val navController = rememberNavController()
        HidrasiDetail(juiceId = 1, navController = navController)
    }
}