package com.ynov.kotlin.rickmorty.presentation.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.model.RMCharacter
import kotlinx.android.synthetic.main.character_layout.view.*

class CharacterListAdapter: RecyclerView.Adapter<CharacterListAdapter.ViewHolder>(){

    private var characterList: MutableList<RMCharacter> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.character_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun updateList(characterList: List<RMCharacter>){
        this.characterList.clear()
        this.characterList.addAll(characterList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList.get(position))
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var textViewName : TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(rmChacter: RMCharacter){
            itemView.nameTextView.text = rmChacter.name
        }
    }
}