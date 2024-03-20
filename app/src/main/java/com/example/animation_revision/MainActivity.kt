package com.example.animation_revision

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animation_revision.ui.theme.Animation_RevisionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Animation_RevisionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UneCarte()
                }
            }
        }
    }
}

@Composable
fun UneCarte(modifier: Modifier = Modifier) {
    var ouvert = rememberSaveable { mutableStateOf(false)}
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row() {
                UnIcone()
                MonNom()
                Spacer(Modifier.weight(1f))
                UnBouton(ouvert.value, {ouvert.value = !ouvert.value})
            }
            if(ouvert.value){
                        
                
                Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "9155 rue Saint-Hubert",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = modifier.padding(horizontal = 10.dp)
                    )
                    Text(
                        text = "1 514 389-5921",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = modifier.padding(horizontal = 10.dp)
                    ) }

            }

        }
    }


@Composable
fun UnIcone(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Filled.Face,
        tint = MaterialTheme.colorScheme.secondary,
        contentDescription = "face",
        modifier = Modifier
            .size(72.dp)
            .padding(4.dp)
    )
}

@Composable
fun MonNom(modifier: Modifier = Modifier) {
    Column(modifier){
        Text(
            text = "Vachon",
            style = MaterialTheme.typography.displaySmall,
            modifier = modifier
        )
        Text(
            text = "Alexandre",
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
        )
    }

}

@Composable
fun UnBouton(
    ouvert: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
    ) {
    IconButton(onClick = onClick,
                modifier = modifier
    ) {
        Icon(
            imageVector = if (ouvert) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = "Ouvrir",
            tint = MaterialTheme.colorScheme.secondary
        )
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Animation_RevisionTheme {
        UneCarte()
        // bonjour monsieur Gill
    }
}