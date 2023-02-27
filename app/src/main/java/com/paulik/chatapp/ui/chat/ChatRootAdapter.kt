package com.paulik.chatapp.ui.chat

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.domain.repo.ChatViewEntity

class ChatRootAdapter(
    private var data: List<ChatViewEntity> = mutableListOf(),
    val context: Context,
    private val onDetailsChatClickListener: (String) -> Unit = {}
) : RecyclerView.Adapter<ChatRootViewHolder>() {


    @SuppressLint("NotifyDataSetChanged")
    fun setData(chats: List<ChatViewEntity>) {
        data = chats
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRootViewHolder {
        return ChatRootViewHolder(
            parent,
            context,
            onDetailsChatClickListener
        )
    }

    private fun getItem(position: Int): ChatViewEntity = data[position]

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ChatRootViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}