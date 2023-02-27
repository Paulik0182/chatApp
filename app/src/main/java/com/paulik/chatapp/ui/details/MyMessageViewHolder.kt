package com.paulik.chatapp.ui.details

import android.content.Context
import android.view.ViewGroup
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.ItemMessagesMyBinding
import com.paulik.chatapp.domain.entity.MessageEntity

class MyMessageViewHolder(
    parent: ViewGroup,
    context: Context,
) : BaseMessageViewHolder(
    parent, context, R.layout.item_messages_my
) {

    private val binding: ItemMessagesMyBinding = ItemMessagesMyBinding.bind(itemView)
    private lateinit var messageEntity: MessageEntity

    override fun bind(messageEntity: MessageEntity) {
        this.messageEntity = messageEntity

        binding.textMessageSentTextView.text = messageEntity.text
    }
}
