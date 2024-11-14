package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.PinkPastel

@Composable
fun ButtonBar(
    onHomeClick: () -> Unit,
    onResepClick: () -> Unit,
    onProfileClick: () -> Unit
){
    BottomAppBar (
        modifier = Modifier.fillMaxWidth(),
        containerColor = PinkPastel
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onHomeClick) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "Home", modifier = Modifier.size(30.dp), tint = Color.White)
            }
            IconButton(onClick = onResepClick) {
                val resIcon = painterResource(id = R.drawable.resep)
                Icon(painter = resIcon, contentDescription = "Resep", modifier = Modifier.size(25.dp), tint = Color.White)
            }
            IconButton(onClick = onProfileClick) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", modifier = Modifier.size(30.dp), tint = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun ButtonBarPreview(){
    ButtonBar(
        onHomeClick = {},
        onResepClick = {},
        onProfileClick = {}
    )
}