package com.paulik.chatapp.ui.details

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.domain.entity.MessageEntity

class DetailsChatAdapter(
    private var data: List<MessageEntity> = mutableListOf(),
    val context: Context,
) : RecyclerView.Adapter<DetailsChatViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chats: List<MessageEntity>) {
        data = chats
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsChatViewHolder {
        return DetailsChatViewHolder(
            parent,
            context
        )
    }

    private fun getItem(position: Int): MessageEntity = data[position]

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DetailsChatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}