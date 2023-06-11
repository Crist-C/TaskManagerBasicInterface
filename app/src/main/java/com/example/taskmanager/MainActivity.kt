package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskFinishedWithImage(
                        stringResource(id = R.string.all_tasks_completed_text),
                        stringResource(id = R.string.nice_work_text)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskFinishedWithImage(title: String, message: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier) {
        Image(
            painter = image,
            contentDescription = "check task finished image"
        )
        TaskFinishedWithText(title, message, modifier)
    }
}

@Composable
fun TaskFinishedWithText(title: String, message: String, modifier: Modifier = Modifier) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = message,
            fontSize = 16.sp
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TaskFinishedPreview() {
    TaskManagerTheme {
        TaskFinishedWithImage(
            title = stringResource(id = R.string.all_tasks_completed_text),
            message = stringResource(id = R.string.nice_work_text)
        )
    }
}