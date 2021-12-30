package com.example.currytime.data

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


class DataStoreManager(val context: Context) {

    private val dataStore: DataStore<Preferences> = context.createDataStore(name = "useroldornew")

    private object PreferenceKeys {
        val olduser = preferencesKey<String>("user_status")
    }


    suspend fun saveToDatastore(old: String) {
        dataStore.edit {
            it[PreferenceKeys.olduser] = old
        }

    }

    suspend fun getFromDataStore() = dataStore.data.map {
        val mystatus = it[PreferenceKeys.olduser] ?: "none"
        mystatus

    }
}



