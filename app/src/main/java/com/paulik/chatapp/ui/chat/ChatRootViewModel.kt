package com.paulik.chatapp.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.paulik.chatapp.domain.entity.ChatEntity
import com.paulik.chatapp.domain.entity.ChatViewEntity
import com.paulik.chatapp.domain.repo.ChatRepo
import com.paulik.chatapp.domain.repo.UsersRepo
import com.paulik.chatapp.utils.mutable

class ChatRootViewModel(
    private val chatRepo: ChatRepo,
    private val usersRepo: UsersRepo
) : ViewModel() {

    class Factory(private val chatRepo: ChatRepo, private val usersRepo: UsersRepo) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ChatRootViewModel(chatRepo, usersRepo) as T
        }
    }

    val chatLiveData: LiveData<List<ChatViewEntity>> = MutableLiveData()
    val selectedDetailsChatLiveData: LiveData<ChatEntity> = MutableLiveData()

    init {
        if (chatLiveData.value == null) {
            chatRepo.getChats().let {
                chatLiveData.mutable().postValue(
                    it.map { chat ->
                        val contact = usersRepo.getUser(chat.usersIds[1])
                        ChatViewEntity(
                            chat.id,
                            name = contact.name,
                            text = chat.lastMessage?.text,
                            time = chat.lastMessage?.time,
                            photoUrl = contact.photoUrl
                        )
                    }
                )
            }
        }
    }

    fun onChatClick(chatId: String) {
        // достаем из chatRepo chatId
        selectedDetailsChatLiveData.mutable().postValue(chatRepo.getChat(chatId))
    }
}