package com.example.data.repository

import com.chibatching.kotpref.KotprefModel
import com.example.data.api.AccessToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccessTokenRepository @Inject constructor() {

    private object Pref : KotprefModel() {
        var accessTokenValue by nullableStringPref()
    }

    fun save(token: AccessToken) {
        Pref.accessTokenValue = token.value
    }

    fun load(): AccessToken? {
        return Pref.accessTokenValue?.let {
            AccessToken(it)
        }
    }

    fun clear() {
        Pref.accessTokenValue = null
    }
}
