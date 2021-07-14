package com.ti4n.sampleapp.util

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.ti4n.sampleapp.DataStoreName

val Context.dataStore by preferencesDataStore(name = DataStoreName)