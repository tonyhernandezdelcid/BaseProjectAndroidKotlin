package com.guatex.basprojectandroidkotlin


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.component_button_insert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var list: ArrayList<User> = ArrayList()
    var userAdapter = UserAdapter(this@MainActivity, list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_insert_user.setOnClickListener{
            val intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)
        }

       // val dataHelper = DataHelper(this)
        Log.d("read", "read semua data")
       // val studentlist = dataHelper.getAllStudent()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.14.113:8080/baseprojectapi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var userAPI =  retrofit.create(UserAPI::class.java);
        userAPI.getUsers().enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                System.out.println("consulta exitosa")

                list = response.body()!!



                // Procesar respuesta exitosa
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                // Procesar error en la petición
                System.out.println("consulta error")
                t.printStackTrace()
            }
        })




        rv_user.setHasFixedSize(true);
        rv_user.layoutManager = LinearLayoutManager(this@MainActivity);
        userAdapter.notifyDataSetChanged()
        rv_user.adapter = userAdapter;


      /**  rv_student.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = studentAdapter
        }*/

        refresh_swipe.setOnRefreshListener {
            refresh_swipe.isRefreshing=false
            userAdapter.getUpdate()
            rv_user.setHasFixedSize(true);
            rv_user.layoutManager = LinearLayoutManager(this@MainActivity);
            rv_user.adapter = userAdapter;

        }


        //trayendo listado de usuarios





    }

    override fun onResume() {
        super.onResume()
        refresh_swipe.isRefreshing=false
        userAdapter.getUpdate()
        rv_user.setHasFixedSize(true);
        rv_user.layoutManager = LinearLayoutManager(this@MainActivity);
        rv_user.adapter = userAdapter;
    }

}