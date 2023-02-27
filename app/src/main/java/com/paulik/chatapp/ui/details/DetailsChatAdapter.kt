package com.paulik.chatapp.ui.details

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.domain.entity.MessageEntity

private const val MY_MESSAGE_TYPE = 0
private const val NOT_MY_MESSAGE_TYPE = 1

class DetailsChatAdapter(
    private var data: List<MessageEntity> = mutableListOf(),
    val context: Context,
) : RecyclerView.Adapter<BaseMessageViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chats: List<MessageEntity>) {
        data = chats
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMessageViewHolder {
        // принимаем решение, что загружать
        return when (viewType) {
            MY_MESSAGE_TYPE -> {
                MyMessageViewHolder(
                    parent,
                    context
                )
            }
            NOT_MY_MESSAGE_TYPE -> {
                NotMyMessageViewHolder(
                    parent,
                    context
                )
            } // todo пока сделано не совсем правильно
            else -> throw IllegalStateException("Неизвестное сообщение")
        }
    }

    override fun getItemViewType(position: Int): Int {
        // если это мое то я возвращаю MY... иначе NOT_MY...
        return if (getItem(position).mine) MY_MESSAGE_TYPE else NOT_MY_MESSAGE_TYPE
    }

    private fun getItem(position: Int): MessageEntity = data[position]

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseMessageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}