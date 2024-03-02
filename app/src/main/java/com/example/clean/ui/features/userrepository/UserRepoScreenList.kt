package com.example.clean.ui.features.userrepository

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clean.domain.model.User
import com.example.clean.domain.model.UserRepo
import com.example.clean.ui.components.FlexibleSingleLineText
import com.example.clean.ui.theme.AppLightTheme
@Composable
fun UserRepoListScreen(modifier: Modifier, repositories: List<UserRepo>, user: User) {
    LazyColumn(modifier = modifier) {
        items(repositories) { repository ->
            RepositoryListItem(
                userRepo = repository
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepositoryListItem(userRepo: UserRepo) {
    Card(
//        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = userRepo.login,
                style = TextStyle(
                    color = Color.White, fontSize = 18.sp
                ),
            )
            FlexibleSingleLineText(
                Modifier
                    .weight(1f)
                    .padding(horizontal = 18.dp),
                userRepo.type
            )
            Text(text = userRepo.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserRepositoryListPreview() {
    val user = User(
        id = 1,
        login = "dinakr279844",
        type = "User",
        url = "url",
        avatarUrl = "avatarUrl",
        score = 1.0
    )

    val userRepositories = mutableListOf(
        UserRepo(
            id = 1,
            login = "dinkar1708",
            type = "User",
            url = "",
            avatarUrl = "",
            description = "sdlfjsdf dfjlkdj f"
        )
    )

    AppLightTheme {
        UserRepoListScreen(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            repositories = userRepositories,
            user = user
        )
    }
}