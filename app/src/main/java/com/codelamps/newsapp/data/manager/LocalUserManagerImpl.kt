package com.codelamps.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.codelamps.newsapp.domain.manager.LocalUserManager
import com.codelamps.newsapp.util.Constants
import kotlinx.coroutines.flow.Flow
import java.util.prefs.Preferences

class LocalUserManagerImpl(
    private val context : Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        TODO("Not yet implemented")
    }

    override fun readAppEntry(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}

//private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}