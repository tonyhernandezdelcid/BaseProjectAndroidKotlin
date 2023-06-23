package com.guatex.basprojectandroidkotlin

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserService {

    // Instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.14.113:8080/baseprojectapi/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Método para crear un usuario
    fun createUser(user: User) {

      var userAPI =  retrofit.create(UserAPI::class.java);

         userAPI.createUser(user).enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                // Procesar respuesta exitosa
                System.out.println("hola");
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // Procesar error en la petición
            }


         })
    }


    // Método para obtener todos los usuarios
    fun getUsers(){
        var userAPI =  retrofit.create(UserAPI::class.java);
        userAPI.getUsers().enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                System.out.println("consulta exitosa")
                // Procesar respuesta exitosa
            }
            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                // Procesar error en la petición
                System.out.println("consulta error")
                t.printStackTrace()
            }
        })
    }


    // Método para obtener un usuario por su ID
    fun getUser(id: String) {
        var userAPI =  retrofit.create(UserAPI::class.java);
        userAPI.getUser(id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                // Procesar respuesta exitosa
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                // Procesar error en la petición
            }
        })
    }


    // Método para actualizar un usuario
    fun updateUser(user: User) {
        var userAPI =  retrofit.create(UserAPI::class.java);
        userAPI.updateUser(user).enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                // Procesar respuesta exitosa
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // Procesar error en la petición
            }
        })
    }


    // Método para eliminar un usuario
    fun deleteUser(id: String) {
        var userAPI =  retrofit.create(UserAPI::class.java);
        userAPI.deleteUser(id).enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                // Procesar respuesta exitosa
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // Procesar error en la petición
            }
        })
    }




}