package com.example.gameshelf.domain.repository

import com.example.gameshelf.domain.model.Game
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

//Repositorio para obtener los games de FireBase y las funciones a las distintas colecciones, hay una por cada consola


@Singleton  //Con Singleton indicamos que solo haya una instancia de esta implementación en la aplicación.
class GameRepository
@Inject
constructor(
    firestore: FirebaseFirestore
){
    private val nesCollection = firestore.collection("nes")
    private val msCollection = firestore.collection("ms")
    private val mdCollection = firestore.collection("md")
    private val snesCollection = firestore.collection("snes")
    private val gbCollection = firestore.collection("gb")
    private val ggCollection = firestore.collection("gg")

    //con Kotlin Flows notificamos el estado de la petición y convertimos los documentos de firestore en objetos Game

    fun getNesGameList(): Flow<Result<List<Game>>> = flow {
        try {
            emit(Result.Loading())

            val gameList = nesCollection.get().await().map{ document ->
                document.toObject(Game::class.java)
            }

            emit(Result.Success(data = gameList))

        } catch (e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }

    fun getMsGameList(): Flow<Result<List<Game>>> = flow {
        try {
            emit(Result.Loading())

            val gameList = msCollection.get().await().map{ document ->
                document.toObject(Game::class.java)
            }

            emit(Result.Success(data = gameList))

        } catch (e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }

    fun getMdGameList(): Flow<Result<List<Game>>> = flow {
        try {
            emit(Result.Loading())

            val gameList = mdCollection.get().await().map{ document ->
                document.toObject(Game::class.java)
            }

            emit(Result.Success(data = gameList))

        } catch (e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }

    fun getSnesGameList(): Flow<Result<List<Game>>> = flow {
        try {
            emit(Result.Loading())

            val gameList = snesCollection.get().await().map{ document ->
                document.toObject(Game::class.java)
            }

            emit(Result.Success(data = gameList))

        } catch (e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }

    fun getGbGameList(): Flow<Result<List<Game>>> = flow {
        try {
            emit(Result.Loading())

            val gameList = gbCollection.get().await().map{ document ->
                document.toObject(Game::class.java)
            }

            emit(Result.Success(data = gameList))

        } catch (e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }

    fun getGgGameList(): Flow<Result<List<Game>>> = flow {
        try {
            emit(Result.Loading())

            val gameList = ggCollection.get().await().map{ document ->
                document.toObject(Game::class.java)
            }

            emit(Result.Success(data = gameList))

        } catch (e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }


}