package com.example.gameshelf.domain.repository

// Resultados posibles de carga de FireBase (operación asincrona)

sealed class Result <T> (
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T?) : Result<T>(data)

    class Error<T>(message: String?, data: T? = null) : Result<T>(data, message)

    class Loading<T>(data: T? = null) : Result<T>(data)
}