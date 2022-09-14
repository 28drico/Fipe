package br.com.zup.fipe.data.datasource.remote

import br.com.zup.fipe.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {
    companion object{
        const val Base_URL = " https://parallelum.com.br/"

        private val retrofit: Retrofit by lazy {
            val httpClient = OkHttpClient.Builder()
            httpClient.readTimeout(30, TimeUnit.SECONDS)
            httpClient.connectTimeout(30, TimeUnit.SECONDS)
            httpClient.writeTimeout(30,TimeUnit.SECONDS)

            if (BuildConfig.DEBUG){
                val logInterceptor = HttpLoggingInterceptor()
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                httpClient.addInterceptor(logInterceptor)
            }

            Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
        }
        @JvmStatic
        val apiService: MarcaItemApi
        get() = retrofit.create(MarcaItemApi::class.java)
    }
}