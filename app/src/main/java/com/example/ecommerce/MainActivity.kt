package com.example.ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var myrecycler:RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myrecycler = findViewById(R.id.recycler)


        val retrofitBuilder=Retrofit.Builder().baseUrl("https://deezerdevs-deezer.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterFace::class.java)

        val retrofitdata = retrofitBuilder.getData("eminem")
        retrofitdata.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
             var dataList  =response.body()
                myAdapter = MyAdapter(this@MainActivity,dataList!!.data)
                myrecycler.adapter=myAdapter
                myrecycler.layoutManager = LinearLayoutManager(this@MainActivity)
                Log.d("tag:OnResponse","onResponse"+response.body())
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
               Log.d("onfailyuer","failed")
            }
        })
    }
}