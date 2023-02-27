package com.paulik.chatapp.ui.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.ItemRecordChatBinding
import com.paulik.chatapp.domain.repo.ChatViewEntity
import com.squareup.picasso.Picasso

class ChatRootViewHolder(
    parent: ViewGroup,
    val context: Context,
    onChatClick: (String) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_record_chat, parent, false)
) {

    private val binding: ItemRecordChatBinding = ItemRecordChatBinding.bind(itemView)
    private lateinit var chatEntity: ChatViewEntity

    fun bind(chatEntity: ChatViewEntity) {
        this.chatEntity = chatEntity

        binding.userNameTextView.text = chatEntity.name
        binding.textMessageTextView.text = chatEntity.text

        Picasso.get()
            .load(chatEntity.photoUrl)
            .fit() // картинка будет размещена по выделенному размеру для нее.
            .placeholder(R.drawable.photo_default)
            .into(binding.photoUrlImageView)
        binding.photoUrlImageView.scaleType =
            ImageView.ScaleType.FIT_CENTER
    }

    init {
        itemView.setOnClickListener {
            onChatClick.invoke(chatEntity.chatId)
        }
    }
}
