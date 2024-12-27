package com.example.medic

import android.content.Intent
import androidx.compose.ui.Alignment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medic.ui.theme.MedicTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PagerView()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerView() {
    val pagerState = rememberPagerState()
    val context = LocalContext.current
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                count = 3,
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> ScreenOne()
                    1 -> ScreenTwo()
                    2 -> ScreenThree()
                }
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.Center) // Выравнивание по центру вертикали и горизонтали
                    .padding(16.dp),
                activeColor = MaterialTheme.colorScheme.primary,
                inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                indicatorHeight = 8.dp,
                indicatorWidth = 8.dp,
                spacing = 8.dp
            )
            Text(
                text = "Пропустить",
                modifier = Modifier
                    .clickable(onClick = {val intent = Intent(context, RegVoitActivity::class.java)
                        context.startActivity(intent)})
                    .align(Alignment.TopStart)
                    .padding(16.dp),

                fontSize = 16.sp,
                color = Color.Blue // Цвет текста
            )
        }
    }
}

@Composable
fun ScreenOne() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Image(
            painter = painterResource(id = R.drawable.listone),
            contentDescription = "Menu",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


    }
}

@Composable
fun ScreenTwo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Image(
            painter = painterResource(id = R.drawable.listtwo),
            contentDescription = "Menu",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ScreenThree() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Image(
            painter = painterResource(id = R.drawable.listlast),
            contentDescription = "Menu",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}