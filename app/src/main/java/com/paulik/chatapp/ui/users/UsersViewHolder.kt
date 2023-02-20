package com.paulik.chatapp.ui.users

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.ItemRecordUsersBinding
import com.paulik.chatapp.domain.entity.UserEntity
import com.squareup.picasso.Picasso

class UsersViewHolder(
    parent: ViewGroup,
    val context: Context,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_record_users, parent, false)
) {

    private val binding: ItemRecordUsersBinding = ItemRecordUsersBinding.bind(itemView)
    private lateinit var userEntity: UserEntity

    fun bind(userEntity: UserEntity) {
        this.userEntity = userEntity

        binding.userNameTextView.text = userEntity.name

        Picasso.get()
            .load(userEntity.photoUrl)
            .placeholder(R.drawable.photo_default)
            .into(binding.photoUrlImageView)

    }
}
