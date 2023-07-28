package com.example.gameshelf.data.network

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gameshelf.domain.model.Juego
import android.content.Context


@Database(entities = [Juego::class], version = 2, exportSchema = false)
abstract class JuegoDB : RoomDatabase() {
    abstract fun juegoDao(): JuegoDao

    companion object {
        @Volatile
        private var INSTANCE: JuegoDB? = null

        fun getDatabase(context: Context): JuegoDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JuegoDB::class.java,
                    "juego_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
