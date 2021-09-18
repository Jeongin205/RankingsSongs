package com.example.rankingssongs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rankingssongs.databinding.SongItemBinding

class MainAdapter( val data: ArrayList<SongData>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    class MainViewHolder(val binding: SongItemBinding) : ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.song_item, parent, false)
        return MainViewHolder(SongItemBinding.bind(inflater))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.data = data[position]
    }

    override fun getItemCount(): Int = data.size

}