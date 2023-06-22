package com.guatex.basprojectandroidkotlin




import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_update.*
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


    }
}