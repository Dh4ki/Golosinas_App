package com.eduardo.ecommerce_golosinas.domain.util

import com.eduardo.ecommerce_golosinas.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

object ResponseToRequest {
    fun <T> send(result : Response<T> ) : Resource<T>{
        return  try {
            if (result.isSuccessful){//201
                Resource.Success(result.body()!!)
            }
            else{
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }
        }catch (e: HttpException){
            e.printStackTrace()
            Resource.Failure(e.message?: "Error desconocido en la petición HTTP")
        }catch (e: IOException){
            e.printStackTrace()
            Resource.Failure("Veriifica tu conexcion a internet")
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e.message?: "Error desconocido")
        }
    }
}