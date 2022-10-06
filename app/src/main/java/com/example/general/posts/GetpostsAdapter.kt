package com.example.general.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.general.R

class GetpostsAdapter:RecyclerView.Adapter<GetpostsAdapter.InsideClass>() {
    class InsideClass(view:View):RecyclerView.ViewHolder(view){
         val textView11:TextView
         val textView12:TextView
         val textView13:TextView
         val textView14:TextView
        init {
            textView11=view.findViewById(R.id.textView11)
            textView12=view.findViewById(R.id.textView12)
            textView13=view.findViewById(R.id.textView13)
            textView14=view.findViewById(R.id.textView14)
        }
    }

    val postlist= mutableListOf<GetPostsDataItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsideClass {
        return InsideClass(LayoutInflater.from(parent.context).inflate(R.layout.targetpostslayout,parent,false))
    }

    override fun onBindViewHolder(holder: InsideClass, position: Int) {
holder.textView11.text=postlist[position].title
holder.textView12.text=postlist[position].body
holder.textView13.text=postlist[position].id.toString()
holder.textView14.text=postlist[position].userId.toString()
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    fun datapasss(postslist:List<GetPostsDataItem>) {

        postlist.clear()
        postlist.addAll(postslist)
        notifyDataSetChanged()

    }
}