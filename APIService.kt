package com.app.ticketwingsuser.apiCalling

import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface APIService {

    @POST("auth/signup")
    fun signup(@Body signUpRequest: SignUpRequest): Observable<SignUpResponse>

    @Multipart
@POST("initiate")
@Headers({
        "Content-Type: application/json",
        "Cache-Control: no-cache"
})
Call<UserInfoServerResponse> getUserInfoRequest(@Part(value="data") UserInfo mUserInfo);

    // MediaUploadl̥
    @Multipart
    @POST("common/mediaUpload")
    fun mediaUpload(
        @Part("langType") fullName: RequestBody?,
        @Part files: MultipartBody.Part,
    ): Observable<MediaUploadResponse>

}
