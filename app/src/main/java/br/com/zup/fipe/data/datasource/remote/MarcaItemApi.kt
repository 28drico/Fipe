package br.com.zup.fipe.data.datasource.remote

import br.com.zup.fipe.data.model.MarcaResponseItem
import retrofit2.http.GET

interface MarcaItemApi {

    @GET("fipe/api/v1/carros/marcas")
    suspend fun getAllMarcaNetwork() : MarcaResponseItem
}