package com.guatex.basprojectandroidkotlin

import java.util.*

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_student.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UserAdapter (private val context: Context, private var userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun onBind(user: User){
            itemView.tv_nim.text = user.id.toString()
            itemView.tv_name.text = user.codigo
            itemView.tv_faculty.text = user.nombre

                itemView.iv_student.setImageResource(R.drawable.maleprofile)

            itemView.setOnLongClickListener{
                val alertDialogBuilder = AlertDialog.Builder(itemView.context)
                alertDialogBuilder.setTitle("Confirm")
                    .setMessage("Are you sure to delete "+user.nombre+"?")
                    .setCancelable(true)
                    .setPositiveButton("No"){dialog,which->
                        Toast.makeText(itemView.context, "Cancel Delete ", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Yes"){dialog,which->

                        var usrservi = UserService()
                        usrservi.deleteUser(user.id)
                        //val db = DataHelper(itemView.context)
                       // db.deleteStudent(student) MANDAR A LLAMAR A API PARA ELIMINAR
                       // userList.remove(user)

                        //getUpdate()
                        notifyDataSetChanged()
                        Toast.makeText(itemView.context,"Delete success",Toast.LENGTH_SHORT).show()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
                true
            }

            itemView.setOnClickListener {
                getUpdate();
            }
        }




    }

    fun getUpdate(){
        //val db = DataHelper(context)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.14.113:8080/baseprojectapi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var userAPI =  retrofit.create(UserAPI::class.java);
        userAPI.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                System.out.println("consulta exitosa")

                userList = response.body()!!



                // Procesar respuesta exitosa
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Procesar error en la petición
                System.out.println("consulta error")
                t.printStackTrace()
            }
        })


       // userList = db.getAllUsers()
        notifyDataSetChanged()
    }



}