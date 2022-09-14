package br.com.zup.fipe.domain.repository

import br.com.zup.fipe.data.datasource.local.dao.CarroDao
import br.com.zup.fipe.data.datasource.remote.RetrofitService
import br.com.zup.fipe.data.model.MarcaResponseItem
import br.com.zup.fipe.data.model.MarcaResponseItemItem

class CarrosRepository(private val carroDao: CarroDao) {

    fun getAllCarros():List<MarcaResponseItemItem> = carroDao.getAllCarros()

    fun insertAllCarroDatabase(carrosList: List<MarcaResponseItemItem>){
        carroDao.insertAllCarros(carrosList)
    }

    suspend fun getAllCarrosNetwork(): MarcaResponseItem {
        return RetrofitService.apiService.getAllMarcaNetwork()
    }
}