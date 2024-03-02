package com.example.clean.ui.features.userrepository

import android.os.Bundle
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import com.example.clean.domain.model.User

object UserSaver : Saver<User, Bundle> {

    private const val KEY_ID = "id"
    private const val KEY_SCORE = "score"
    private const val KEY_LOGIN = "login"
    private const val KEY_TYPE = "type"
    private const val KEY_AVATAR_URL = "avatar_url"

    override fun restore(value: Bundle): User {
        return User(
            id = value.getLong(KEY_ID),
            score = value.getDouble(KEY_SCORE),
            login = value.getString(KEY_LOGIN).orEmpty(),
            type = value.getString(KEY_TYPE).orEmpty(),
            avatarUrl = value.getString(KEY_AVATAR_URL).orEmpty(),
        )
    }

    override fun SaverScope.save(value: User): Bundle {
        return Bundle().apply {
            putLong(KEY_ID, value.id)
            putDouble(KEY_SCORE, value.score)
            putString(KEY_LOGIN, value.login)
            putString(KEY_TYPE, value.type)
            putString(KEY_AVATAR_URL, value.avatarUrl)
        }
    }
}
