package com.example.di

import com.example.data.api.GithubAuthService
import com.example.data.api.GithubService
import com.example.data.api_builder.AuthenticationInterceptor
import com.example.data.api_builder.LiveDataCallAdapterFactory
import com.example.data.repository.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ApiBuilder @Inject constructor(
    private val authenticatorInterceptor: AuthenticationInterceptor
) {

    fun buildGithubService(
        loggingLevel: HttpLoggingInterceptor.Level
    ): GithubService {
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .addInterceptor(authenticatorInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITHUB_END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(client)
            .build()
            .create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun buildGithubAuthService(): GithubAuthService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITHUB_AUTH_END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAuthService::class.java)
    }
}