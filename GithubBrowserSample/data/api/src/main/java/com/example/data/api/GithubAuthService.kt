/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.data.api

import com.example.data.api.AccessTokenParameter
import com.example.data.api.AccessTokenResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * REST API access points
 */
interface GithubAuthService {
    @POST("login/oauth/access_token")
    @Headers("Accept: application/json")
    suspend fun createAccessToken(@Body parameter: AccessTokenParameter): AccessTokenResponse
}
