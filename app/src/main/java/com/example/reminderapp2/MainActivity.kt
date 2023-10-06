package com.example.reminderapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reminderapp2.data.DataSource
import com.example.reminderapp2.model.Reminder
import com.example.reminderapp2.ui.theme.ReminderApp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReminderApp2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReminderApp2()
                }
            }
        }
    }
}

@Preview
@Composable
fun ReminderApp2() {
    ReminderList(DataSource.reminder)
}

@Composable
fun ReminderList(reminderList: List<Reminder>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(reminderList) {reminder ->
            ReminderCard2(
                reminder = reminder,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ReminderCard2(reminder: Reminder, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Text (
                text = stringResource(id = reminder.stringResourceId),
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
                style= MaterialTheme.typography.headlineSmall
            )
            Image(
                painter = painterResource(id = reminder.imageResourceId),
                contentDescription = stringResource(id = reminder.stringResourceId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)


            )
            Text(
                text = stringResource(id = reminder.dayReminder),
                modifier = Modifier.padding(16.dp)

            )
        }
    }
}

@Preview
@Composable
fun ReminderCard2Preview() {

    ReminderCard2(reminder = DataSource.reminder[0])
}
