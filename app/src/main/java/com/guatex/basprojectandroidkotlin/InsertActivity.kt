package com.guatex.basprojectandroidkotlin

import android.app.AlertDialog
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_insert.*
import kotlinx.android.synthetic.main.component_button_insert_conf.*



class InsertActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
       // val dataHelper = DataHelper(this)
        b_insert.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Confirm")
                .setMessage("Are you sure to insert it?")
                .setCancelable(true)
                .setPositiveButton("No"){dialog,which->
                }
                .setNegativeButton("Yes"){dialog,which->

                    val codigo = et_codigo.text.toString()
                    val nombre = et_codigo.text.toString()
                    val telefono = et_codigo.text.toString()

                    var user = User()
                    user.codigo = codigo
                    user.nombre = nombre
                    user.telefono =  telefono

                    //dataHelper.addStudent(Student(nim,name,gender.text.toString(),faculty))
                  var  userservi = UserService()
                    userservi.createUser(user)

                    et_codigo.setText("")
                    et_nombre.setText("")
                    et_telefono.setText("")
                    finish()
                }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}