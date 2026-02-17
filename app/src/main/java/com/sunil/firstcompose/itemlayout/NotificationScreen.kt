package com.sunil.firstcompose.itemlayout

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sunil.firstcompose.R
import com.sunil.firstcompose.ui.theme.BlogAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview
@Composable
fun NotificationScreen(){
    val count = rememberSaveable { mutableIntStateOf(0) }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {

        MediaComposable()
        CoroutineScopeComposable()
        Spacer(modifier = Modifier.padding(10.dp))
        ListComposable()
        Spacer(modifier = Modifier.padding(10.dp))
        NotificationCounter(count.value, {count.value++})
        MessageBar(count.value)

        //Derived()

        Loader()

    }
}


@Composable
fun MessageBar(count: Int) {
    ElevatedCard {
        Row(
            Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(imageVector = Icons.Outlined.Favorite , contentDescription = "",
                Modifier.padding(4.dp))
            Text(text = "Message sent so far $count")
        }
    }
}

@Composable
fun NotificationCounter(count: Int, increaseCount: () -> Int) {
    var theme = remember { mutableStateOf(false) }

    BlogAppTheme(darkTheme = theme.value) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "You have sent $count notification")

            Button(onClick = {
                theme.value = !theme.value

                increaseCount()

                Log.e("count", "$count")

            }) {
                Text(text = "Send Notification")
            }
        }
    }

}

@Composable
fun ListComposable(){
    val categoryState = remember { mutableStateOf(emptyList<String>()) }

    // When I want to execute once or on any condition, LaunchedEffect is used.
    // Basically it is Coroutine Scope and composable.
    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchListCategory()
    }

    LazyColumn {
        items(categoryState.value) {item ->
            Text(text = item)
        }
    }
}

private fun fetchListCategory(): List<String> {
    return listOf("Sunday","Monday","Tuesday")
}


@Composable
fun CoroutineScopeComposable(){
    val count = rememberSaveable { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()

    var text = "Counter is running ${count.value}"

    if (count.intValue == 10) {
        text = "Counter is stopped"
    }

    Column {
        Text(text = text)
        Button(onClick = {
            scope.launch {
                Log.e("coroutineLaunch","Started...")

                try {
                    for (i in 1..10) {
                        delay(1000L)
                        count.intValue++
                    }

                }catch (e: Exception){
                    Log.e("coroutineLaunch","Exception:- ${e.message}")
                }

            }
        }) {
            Text(text = "Start")
        }


    }



    LaunchedEffect(key1 = Unit) {
        delay(1000)

        count.intValue=10
    }

    Counter(count.value)


}

@Composable
fun Counter(value: Int) {
    val state  = rememberUpdatedState(value)
    LaunchedEffect(key1 = value){
        delay(5000)

        Log.e("coroutineLaunch","Updated value:- ${state.value}")
    }

    Text(text = "Counter is $value")
}

@Composable
fun MediaComposable() {
    val context = LocalContext.current

    DisposableEffect(key1 = Unit) {
        val mediaPlayer= MediaPlayer.create(context, R.raw.ishq_song)
        mediaPlayer.start()

        Log.e("coroutineLaunch","Song Started...")

        onDispose {
            Log.e("coroutineLaunch","Song Stopped...")

            mediaPlayer.stop()
            mediaPlayer.release()
        }

    }

}


@Composable
fun Loader() {
    val degree= produceState(initialValue = 0) {
        while (true) {
            delay(16)
            value = (value+10) % 360
        }
    }


    Box(contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize(1f),
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(imageVector = Icons.Outlined.Refresh,
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(degree.value.toFloat())
                )

                Text("Loading...")
            }
        })
}

@Composable
fun Derived() {
    val tableOf = remember { mutableStateOf(5) }

    val index = produceState(1) {
        repeat(9){
            delay(1000)
            value = it + 1

        }
    }

    val message by remember {
        derivedStateOf {
            "${index.value} * ${tableOf.value} = ${index.value * tableOf.value}"
        }
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .size(40.dp, 120.dp)
    ){
        Text(text = message,
            style = MaterialTheme.typography.titleLarge)

    }


}

