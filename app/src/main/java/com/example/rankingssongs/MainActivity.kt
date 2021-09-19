package com.example.rankingssongs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.rankingssongs.data.TopTrack
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
        getSongFilterId()
    }
    fun getSongFilterId(): Unit{
        val call: Call<TopTrack> = JsonPlaceHolderClient.getApiService().getTrack("chart.gettoptracks", "563f17153e9c60240d5e29bb1a508549", "json")
        call.enqueue(object : Callback<TopTrack>{
            override fun onResponse(call: Call<TopTrack>, response: Response<TopTrack>) {
                if(response.isSuccessful){
                        Log.e("asdf", response.body()?.tracks?.track!!.toString())
                        Log.e("asdf", response.body()?.tracks?.track!!.size.toString())
                    for (i in 0..49){
                        Log.e("asdf", response.body()?.tracks?.track!![i].name)
                        val number = (i+1).toString()
                        val song = response.body()?.tracks?.track!![i].name
                        val singer = response.body()?.tracks?.track!![i].artist.name
                        val songData = SongData(number, song, singer)
                        list.add(songData)
                    }
                    binding.recycler.adapter = MainAdapter(list)
                }
            }

            override fun onFailure(call: Call<TopTrack>, t: Throwable) {
                t.printStackTrace()
                Log.e("asdf", "n")
            }
        })
    }
}

