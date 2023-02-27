package com.paulik.chatapp.ui.details

import android.content.Context
import android.view.ViewGroup
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.ItemMessagesNotMyBinding
import com.paulik.chatapp.domain.entity.MessageEntity

class NotMyMessageViewHolder(
    parent: ViewGroup,
    context: Context,
) : BaseMessageViewHolder(
    parent, context, R.layout.item_messages_not_my
) {

    private val binding: ItemMessagesNotMyBinding = ItemMessagesNotMyBinding.bind(itemView)
    private lateinit var messageEntity: MessageEntity

    override fun bind(messageEntity: MessageEntity) {
        this.messageEntity = messageEntity

        binding.textMessageReceivedTextView.text = messageEntity.text
    }
}
