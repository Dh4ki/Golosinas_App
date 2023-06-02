package com.eduardo.ecommerce_golosinas.domain.util

import com.eduardo.ecommerce_golosinas.domain.model.ErrorResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.http.Body

object ConvertErrorBody {

    fun convert(errorBody: ResponseBody?):ErrorResponse?{
        return try {
            errorBody?.source()?.let {
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }

        }catch (e:Exception){
            null
        }
    }
}