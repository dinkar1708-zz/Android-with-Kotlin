package com.example.clean.ui.features.users

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clean.domain.model.User
import com.example.clean.ui.components.FlexibleSingleLineText
import com.example.clean.ui.components.HorizontalDivider
import com.example.clean.ui.theme.AppLightTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsersListView(
    modifier: Modifier, userList: List<User>, onItemClick: (User) -> Unit
) {
    LazyColumn(
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        items(userList.size) { index ->
            UserListItem(user = userList[index], onItemClick = onItemClick)
            HorizontalDivider()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListItem(user: User, onItemClick: (User) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer).padding(8.dp),
        shape = RoundedCornerShape(0.dp),
        onClick = { onItemClick(user) }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = user.avatarUrl)
            Column {
                Text(text = user.score.toString())
                Text(text = user.login)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    val users = mutableListOf(
        User(
            id = 1,
            login = "dinkar1708",
            type = "User",
            avatarUrl = "uavatarUrlavatarUrlavatarUrlavatarUrlrl",
        ), User(
            id = 2,
            login = "dinkar170811",
            type = "User",
            avatarUrl = "avatarUrlavatarUrlavatarUrlavatarUrl",
        )
    )

    AppLightTheme {
        UsersListView(
            modifier = Modifier
                .fillMaxWidth(),
            userList = users,
        ) {}
    }
}