package com.app.ticketwingsuser.apiCalling

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientInstance {

    lateinit var retrofit: Retrofit

    const val BASE_URL = "https://app.ticketwings.in/api/"
    const val IMAGE_URL = "https://app.ticketwings.in/assets/uploads/"

    private const val PAYMENT_BASE_URL = "https://testpay.easebuzz.in/payment/"

    val retrofitInstance: Retrofit
        get() {
            if (!this::retrofit.isInitialized) {
                val gson = GsonBuilder().setLenient().create()

                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                val okHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor(interceptor)
                    .connectTimeout(180, TimeUnit.SECONDS)
                    .readTimeout(180, TimeUnit.SECONDS)
                    .build()

                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build()
            }
            return retrofit
        }
}