package com.guatex.basprojectandroidkotlin




import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_insert.*
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.component_button_insert_conf.*
import kotlinx.android.synthetic.main.component_button_update_conf.*
import kotlinx.android.synthetic.main.item_student.view.*


class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val myIntent = intent

        etu_id.setText(myIntent.getStringExtra("id"))
        etu_codigo.setText(myIntent.getStringExtra("codigo"))
        etu_nombre.setText(myIntent.getStringExtra("nombre"))
        etu_telefono.setText(myIntent.getStringExtra("telefono"))



        b_update.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Confirmación")
                .setMessage("Confirme si desea editar el usuario")
                .setCancelable(true)
                .setPositiveButton("No"){dialog,which->
                }
                .setNegativeButton("Si"){dialog,which->


                    val id = etu_id.text.toString()
                    val codigo = etu_codigo.text.toString()
                    val nombre = etu_nombre.text.toString()
                    val telefono = etu_telefono.text.toString()

                    var user = User()
                    user.id = id
                    user.codigo = codigo
                    user.nombre = nombre
                    user.telefono =  telefono

                    //dataHelper.addStudent(Student(nim,name,gender.text.toString(),faculty))
                    var  userservi = UserService()
                    userservi.updateUser(user)

                    etu_id.setText("")
                    etu_codigo.setText("")
                    etu_nombre.setText("")
                    etu_telefono.setText("")
                    finish()
                }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }




    }
}