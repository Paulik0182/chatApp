package com.paulik.chatapp.ui.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.ItemRecordChatBinding
import com.paulik.chatapp.domain.entity.ChatEntity

class ChatRootViewHolder(
    parent: ViewGroup,
    val context: Context,
    onChatClick: (ChatEntity) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_record_chat, parent, false)
) {

    private val binding: ItemRecordChatBinding = ItemRecordChatBinding.bind(itemView)
    private lateinit var chatEntity: ChatEntity

    fun bind(chatEntity: ChatEntity) {
        this.chatEntity = chatEntity

        binding.userNameTextView.text = chatEntity.usersIds.toString()
        binding.textMessageTextView.text = chatEntity.lastMessage?.text
    }

    init {
        itemView.setOnClickListener {
            onChatClick.invoke(chatEntity)
        }
    }
}
