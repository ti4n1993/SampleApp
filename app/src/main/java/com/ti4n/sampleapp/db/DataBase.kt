package com.ti4n.sampleapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(), version = 1)
abstract class DataBase : RoomDatabase() {


}