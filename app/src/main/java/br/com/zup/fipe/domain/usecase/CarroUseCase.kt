package br.com.zup.fipe.domain.usecase

import android.app.Application
import br.com.zup.fipe.data.datasource.local.database.CarroDatabase
import br.com.zup.fipe.data.model.MarcaResponseItemItem
import br.com.zup.fipe.domain.repository.CarrosRepository
import br.com.zup.fipe.viewstate.ViewState

class CarroUseCase(application: Application) {

    private val carroDao = CarroDatabase.getCarrosDataBase(application).carroDao()
    private val carrosRepository = CarrosRepository(carroDao)

    suspend fun getAllCarrosNetwork(): ViewState<List<MarcaResponseItemItem>> {
        return try {
            val carros = carrosRepository.getAllCarrosNetwork()
            carrosRepository.insertAllCarroDatabase(carros)
            ViewState.Success(carros)
        }catch (ex : Exception){
            getAllCarros()
        }
    }

    fun getAllCarros():ViewState<List<MarcaResponseItemItem>>{
        return try {
            val carros = carrosRepository.getAllCarros()
            ViewState.Success(carros)
        }catch (ex:Exception){
            ViewState.Error(Exception("erro"))
        }
    }
}