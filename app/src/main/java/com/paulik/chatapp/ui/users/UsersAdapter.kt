package com.paulik.chatapp.ui.users

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.domain.entity.UserEntity

class UsersAdapter(
    private var data: List<UserEntity> = mutableListOf(),
    val context: Context,
) : RecyclerView.Adapter<UsersViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chats: List<UserEntity>) {
        data = chats
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(
            parent,
            context
        )
    }

    private fun getItem(position: Int): UserEntity = data[position]

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}