package com.paulik.chatapp.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.ItemMessagesNotMyBinding
import com.paulik.chatapp.domain.entity.MessageEntity

class DetailsChatViewHolder(
    parent: ViewGroup,
    val context: Context,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_messages_not_my, parent, false)
) {

    private val binding: ItemMessagesNotMyBinding = ItemMessagesNotMyBinding.bind(itemView)
    private lateinit var messageEntity: MessageEntity

    fun bind(messageEntity: MessageEntity) {
        this.messageEntity = messageEntity

        binding.textMessageReceivedTextView.text = messageEntity.text
    }

}
