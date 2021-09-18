package com.example.rankingssongs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.rankingssongs.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var list: ArrayList<SongData> = ArrayList()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        list.add(SongData("1", "asdf", "asdf"))
        binding.recycler.adapter = MainAdapter(list)
        getSongFilterId()
    }
    fun getSongFilterId(): Unit{
        val call: Call<SongData> = JsonPlaceHolderClient.getApiService().getTrack("chart.gettoptracks", "563f17153e9c60240d5e29bb1a508549", "json")
        call.enqueue(object : Callback<SongData>{
            override fun onResponse(call: Call<SongData>, response: Response<SongData>) {
                if(response.isSuccessful){
                    Log.e("asdf", response.body().toString())
                    val songData: SongData = response.body()!!
                }
            }

            override fun onFailure(call: Call<SongData>, t: Throwable) {
                t.printStackTrace()
                Log.e("asdf", "n")
            }
        })
    }
}

