package com.example.authenticationlearn.di

import com.example.authenticationlearn.domain.repository.LoginRepository
import com.example.authenticationlearn.domain.repository.RegisterRepository
import com.example.authenticationlearn.domain.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth():FirebaseAuth= Firebase.auth

    @Singleton
    @Provides
    fun provideFireStore():FirebaseFirestore= FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun provideRegisterRepository(fAuth: FirebaseAuth,db:FirebaseFirestore):RegisterRepository=RegisterRepository(fAuth,db)

    @Singleton
    @Provides
    fun provideLoginRepository(fAuth: FirebaseAuth,db: FirebaseFirestore):LoginRepository=LoginRepository(fAuth,db)

    @Singleton
    @Provides
    fun provideUserRepository(db: FirebaseFirestore):UserRepository=UserRepository(db)
}