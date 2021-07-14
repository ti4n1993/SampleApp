package com.ti4n.sampleapp.util

import android.content.Context
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.map

fun Context.getIntStore(key: String, defaultValue: Int = 0) =
    dataStore.data.map {
        it[intPreferencesKey(key)] ?: defaultValue
    }


suspend fun Context.putIntStore(key: String, value: Int) {
    dataStore.edit {
        it[intPreferencesKey(key)] = value
    }
}

fun Context.getDoubleStore(key: String, defaultValue: Double = 0.0) =
    dataStore.data.map {
        it[doublePreferencesKey(key)] ?: defaultValue
    }


suspend fun Context.putDoubleStore(key: String, value: Double) {
    dataStore.edit {
        it[doublePreferencesKey(key)] = value
    }
}

fun Context.getStringStore(key: String, defaultValue: String = "") =
    dataStore.data.map {
        it[stringPreferencesKey(key)] ?: defaultValue
    }


suspend fun Context.putStringStore(key: String, value: String) {
    dataStore.edit {
        it[stringPreferencesKey(key)] = value
    }
}

fun Context.getBooleanStore(key: String, defaultValue: Boolean = false) =
    dataStore.data.map {
        it[booleanPreferencesKey(key)] ?: defaultValue
    }


suspend fun Context.putBooleanStore(key: String, value: Boolean) {
    dataStore.edit {
        it[booleanPreferencesKey(key)] = value
    }
}

fun Context.getFloatStore(key: String, defaultValue: Float = 0f) =
    dataStore.data.map {
        it[floatPreferencesKey(key)] ?: defaultValue
    }


suspend fun Context.putFloatStore(key: String, value: Float) {
    dataStore.edit {
        it[floatPreferencesKey(key)] = value
    }
}

fun Context.getLongStore(key: String, defaultValue: Long = 0L) =
    dataStore.data.map {
        it[longPreferencesKey(key)] ?: defaultValue
    }


suspend fun Context.putLongStore(key: String, value: Long) {
    dataStore.edit {
        it[longPreferencesKey(key)] = value
    }
}

fun Context.getStringSetStore(key: String, defaultValue: Set<String> = emptySet()) =
    dataStore.data.map {
        it[stringSetPreferencesKey(key)] ?: defaultValue
    }


suspend fun Context.putStringSetStore(key: String, value: Set<String>) {
    dataStore.edit {
        it[stringSetPreferencesKey(key)] = value
    }
}