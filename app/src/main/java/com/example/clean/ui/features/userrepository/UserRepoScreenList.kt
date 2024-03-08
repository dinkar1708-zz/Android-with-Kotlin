package com.example.clean.ui.features.userrepository

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clean.domain.model.User
import com.example.clean.domain.model.UserRepo
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = userRepo.login,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = userRepo.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Text(
                text = userRepo.type,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelSmall,
            )
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