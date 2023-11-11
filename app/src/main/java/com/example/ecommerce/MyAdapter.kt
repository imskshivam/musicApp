package com.example.ecommerce

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context,val dataList: List<Data>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return  dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  currentData = dataList[position]
        val mediaPlayer = MediaPlayer.create(context,currentData.preview.toUri())
        holder.Title.text = currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.Image);

        holder.play.setOnClickListener{
            mediaPlayer.start()
        }


        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }
    }

    inner class MyViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        val Image:ImageView=itemview.findViewById(R.id.MusicImage)
        val Title:TextView = itemview.findViewById<TextView>(R.id.MusicTitle)
        val play:ImageButton=itemview.findViewById(R.id.play)
        val pause:ImageButton=itemview.findViewById(R.id.pause)


    }
}