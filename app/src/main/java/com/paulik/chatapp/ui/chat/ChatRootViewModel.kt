package com.paulik.chatapp.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.paulik.chatapp.domain.entity.ChatEntity
import com.paulik.chatapp.domain.repo.ChatRepo
import com.paulik.chatapp.utils.mutable

class ChatRootViewModel(
    private val chatRepo: ChatRepo,
//    private val userId: String
) : ViewModel() {

    class Factory(private val chatRepo: ChatRepo) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ChatRootViewModel(chatRepo) as T
        }
    }

    val chatLiveData: LiveData<List<ChatEntity>> = MutableLiveData()
    val selectedDetailsChatLiveData: LiveData<ChatEntity> = MutableLiveData()

    init {
        if (chatLiveData.value == null) {
            chatRepo.getChat().let {
                chatLiveData.mutable().postValue(it)
            }
        }
    }

    fun onChatClick(chatEntity: ChatEntity) {
        selectedDetailsChatLiveData.mutable().postValue(chatEntity)
    }
}