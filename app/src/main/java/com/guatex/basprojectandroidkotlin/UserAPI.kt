package com.guatex.basprojectandroidkotlin

import retrofit2.Call
import retrofit2.http.*

interface UserAPI {

    // Método para crear un usuario
    @POST("crearusuario")
    fun createUser(@Body user: User): Call<Boolean>

    // Método para obtener todos los usuarios
    @GET("consultausuarios")
    fun getUsers(): Call<List<User>>

    // Método para obtener un usuario por su ID
    @GET("verusrindividual/{id}")
    fun getUser(@Path("id") id: String): Call<User>

    // Método para actualizar un usuario
    @PUT("modificarusuario")
    fun updateUser(@Body user: User): Call<Boolean>

    // Método para eliminar un usuario
    @DELETE("eliminausuario/{id}")
    fun deleteUser(@Path("id") id: String): Call<Boolean>
}