package com.example.general

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.general.getapi.comments.GetCommentsAdapterClass
import com.example.general.getapi.GetInstance
import com.example.general.getapi.comments.GetCommentsDataClass
import com.example.general.posts.GetPostsData
import com.example.general.posts.GetpostsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetApiActivity : AppCompatActivity() {
    private  val madapter by lazy {
        GetCommentsAdapterClass()
    }
    private val madapterrr by lazy(){
        GetpostsAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_api)

        val getcommentRecycler=findViewById<RecyclerView>(R.id.get_commentRecyclerview)
        val getpostsRecycler=findViewById<RecyclerView>(R.id.get_postsRecyclerview)

        // for first api to fetch
        getcommentRecycler.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter=madapter
        }

        lifecycleScope.launch(Dispatchers.Main) {
            val final=withContext(Dispatchers.IO){
                GetInstance.getInstance().getCommentsApiData()
            }
            if(final.isSuccessful){
                Log.d("TAG", "onCreate: ${Thread.currentThread().name}")
                madapter.datapass(final.body()?: GetCommentsDataClass())
            }
        }

        // for second api to fetch
        getpostsRecycler.apply {
            setHasFixedSize(true)
            adapter=madapterrr
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        }
        lifecycleScope.launch(Dispatchers.Main){
            val postfinaldata=withContext(Dispatchers.IO){
                GetInstance.getInstancee().getPostsApiData()
            }
            if(postfinaldata.isSuccessful){
                Log.e("TAG", "onCreate: $postfinaldata.body()", )
                madapterrr.datapasss(postfinaldata.body()?: GetPostsData())
            }

        }



}

 }

