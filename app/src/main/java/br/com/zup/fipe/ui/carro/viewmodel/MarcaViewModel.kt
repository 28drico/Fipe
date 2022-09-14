package br.com.zup.fipe.ui.carro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.fipe.data.model.MarcaResponseItemItem
import br.com.zup.fipe.domain.model.SingleLiveEvent
import br.com.zup.fipe.domain.usecase.CarroUseCase
import br.com.zup.fipe.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MarcaViewModel(application: Application): AndroidViewModel(application){

    private val carroUseCase = CarroUseCase(application)
    val carroLista = SingleLiveEvent<ViewState<List<MarcaResponseItemItem>>>()

    fun getAllCarrosNetwork(){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    carroUseCase.getAllCarros()
                    carroUseCase.getAllCarrosNetwork()
                }
                carroLista.value = response
            }catch (ex: Exception){
                carroLista.value = ViewState.Error(Exception("erro"))
            }
        }
        }
}