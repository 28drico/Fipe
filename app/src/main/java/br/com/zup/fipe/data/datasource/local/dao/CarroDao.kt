package br.com.zup.fipe.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.fipe.data.model.MarcaResponseItemItem

@Dao
interface CarroDao {

    @Query("SELECT * FROM marcas")
    fun getAllCarros(): List<MarcaResponseItemItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCarros(carrosList: List<MarcaResponseItemItem>)

}