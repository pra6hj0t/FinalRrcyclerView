package com.example.finalrecyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(var context :Activity,var singer_array_List:ArrayList<Singer>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    lateinit var MyListener :onItemClickListener

    interface onItemClickListener{
        fun onClick(position: Int)
    }

    fun setOnItemClickListener(listener : onItemClickListener){
    MyListener = listener
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(view,MyListener)
    }

    override fun getItemCount(): Int {
       return singer_array_List.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = singer_array_List[position]

        holder.singer_image.setImageResource(currentItem.singer_image)
        holder.singer_name.text = currentItem.singer_name
    }
    class MyViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val singer_image = itemView.findViewById<CircleImageView>(R.id.singer_image)
        val singer_name = itemView.findViewById<TextView>(R.id.singer_name)

        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)
            }
        }
    }
}