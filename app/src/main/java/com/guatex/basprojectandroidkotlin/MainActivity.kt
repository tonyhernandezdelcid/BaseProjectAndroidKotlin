package com.guatex.basprojectandroidkotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.component_button_insert.*
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_insert_student.setOnClickListener{
            val intent = Intent(this,InsertActivity::class.java)
            startActivity(intent)
        }

        val dataHelper = DataHelper(this)
        Log.d("read","read semua data")
        val studentlist = dataHelper.getAllStudent()
        var studentAdapter = StudentAdapter(this@MainActivity,studentlist)
        rv_student.setHasFixedSize(true);
        rv_student.layoutManager = LinearLayoutManager(this@MainActivity);
        rv_student.adapter = studentAdapter;

      /**  rv_student.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = studentAdapter
        }*/

        refresh_swipe.setOnRefreshListener {
            refresh_swipe.isRefreshing=false
            studentAdapter.getUpdate()
        }
    }

}