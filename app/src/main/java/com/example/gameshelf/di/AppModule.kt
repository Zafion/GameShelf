package com.example.gameshelf.di

import android.content.Context
import androidx.room.Room
import com.example.gameshelf.core.Constants.Companion.JUEGO_TABLE
import com.example.gameshelf.data.network.JuegoDB
import com.example.gameshelf.data.network.JuegoDao
import com.example.gameshelf.domain.repository.JuegoRepository
import com.example.gameshelf.domain.repository.JuegoRepositoryImpl
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Inyección de dependencias utilizando Dagger Hilt(Metodos Provide)

@Module //Modulo de dagger con instancias de las Bases de datos
@InstallIn(SingletonComponent::class)   //Con esto indicamos que las dependencias estarán disponibles en toda la aplicación aúnque se crean una unica vez.
class AppModule {

    //Bd Local con Room con 3 metodos de inyección de dependencias.

    @Provides
    fun provideJuegoDb( //funcion para obtener la instancia de la Bd
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context, JuegoDB::class.java, JUEGO_TABLE).build()

    @Provides   //funcion para obtener el Dao de juego
    fun provideJuegoDao(juegoDB: JuegoDB) = juegoDB.juegoDao()

    @Provides   //funcion para obtener el repositorio 
    fun provideJuegoRepository(
        juegoDao: JuegoDao
    ): JuegoRepository = JuegoRepositoryImpl(
        juegoDao = juegoDao
    )

    //Bd Online con FireBase:

    @Provides
    @Singleton
    fun provideFirestoreInstance(): FirebaseFirestore = FirebaseFirestore.getInstance()

    // Funciones para obtener cada colección de cada consola:

    @Provides
    @Singleton
    fun provideNesCollection(firestore: FirebaseFirestore): CollectionReference =
        firestore.collection("nes")

    @Provides
    @Singleton
    fun provideMsCollection(firestore: FirebaseFirestore): CollectionReference =
        firestore.collection("ms")

    @Provides
    @Singleton
    fun provideMdCollection(firestore: FirebaseFirestore): CollectionReference =
        firestore.collection("md")

    @Provides
    @Singleton
    fun provideSnesCollection(firestore: FirebaseFirestore): CollectionReference =
        firestore.collection("snes")

    @Provides
    @Singleton
    fun provideGbCollection(firestore: FirebaseFirestore): CollectionReference =
        firestore.collection("gb")

    @Provides
    @Singleton
    fun provideGgCollection(firestore: FirebaseFirestore): CollectionReference =
        firestore.collection("gg")

    // Función para obtener una colección con un nombre personalizado, de momento sin uso.
    @Provides
    @Singleton
    fun provideCollection(firestore: FirebaseFirestore, collectionName: String): CollectionReference =
        firestore.collection(collectionName)
}