package com.paulik.chatapp.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.domain.entity.MessageEntity

abstract class BaseMessageViewHolder(
    parent: ViewGroup,
    val context: Context,
    private val layoutId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    abstract fun bind(messageEntity: MessageEntity)
}
