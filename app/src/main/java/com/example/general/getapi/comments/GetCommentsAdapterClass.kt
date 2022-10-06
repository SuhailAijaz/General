package com.example.general.getapi.comments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.general.R

class GetCommentsAdapterClass():RecyclerView.Adapter<GetCommentsAdapterClass.InnerClass>() {

    class InnerClass(view:View):RecyclerView.ViewHolder(view) {
        val textView1:TextView
        val textView2:TextView
        val textView3:TextView
        val textView4:TextView
        val textView5:TextView
        init {
            textView1=view.findViewById(R.id.textView1)
            textView2=view.findViewById(R.id.textView2)
            textView3=view.findViewById(R.id.textView3)
            textView4=view.findViewById(R.id.textView4)
            textView5=view.findViewById(R.id.textView5)
        }

    }

    private val getlist= mutableListOf<GetCommentsModalClassItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerClass {
        return InnerClass(LayoutInflater.from(parent.context).inflate(R.layout.targetcommentlayout,parent,false))
    }

    override fun onBindViewHolder(holder: InnerClass, position: Int) {
holder.textView1.text=getlist[position].postId.toString()
holder.textView2.text=getlist[position].id.toString()
holder.textView3.text=getlist[position].name
holder.textView4.text=getlist[position].email
holder.textView5.text=getlist[position].body
    }

    override fun getItemCount(): Int {
return getlist.size
    }

    fun datapass(list: List<GetCommentsModalClassItem>) {
        getlist.clear()
        getlist.addAll(list)
        notifyDataSetChanged()
    }
}