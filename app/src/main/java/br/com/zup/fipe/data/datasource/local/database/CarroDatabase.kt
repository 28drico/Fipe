package br.com.zup.fipe.data.datasource.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.fipe.data.datasource.local.dao.CarroDao
import br.com.zup.fipe.data.model.MarcaResponseItemItem

@Database(entities = [MarcaResponseItemItem::class], version = 4)
abstract class CarroDatabase : RoomDatabase(){
    abstract fun carroDao(): CarroDao

    companion object{
        @Volatile
        private var INSTANCE: CarroDatabase? = null

        fun getCarrosDataBase(context: Context): CarroDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarroDatabase::class.java,
                    "carro_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}