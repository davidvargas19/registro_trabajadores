package com.davidvargas.trabajadoresroom.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TrabajadorEntity::class], version = 1)
abstract class TrabajadorDB: RoomDatabase() {

        abstract fun trabajadorDao(): TrabajadorDao

        companion object {

            private lateinit var context: Context
            private val database: TrabajadorDB by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
                Room.databaseBuilder(context, TrabajadorDB::class.java, "trabajador.db")
                    .allowMainThreadQueries()
                    .build()
            }

            fun getDatabase(context: Context): TrabajadorDB{
                Companion.context = context.applicationContext

                return database
            }
        }

    }
