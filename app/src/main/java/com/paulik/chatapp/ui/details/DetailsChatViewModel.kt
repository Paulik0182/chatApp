package com.paulik.chatapp.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paulik.chatapp.domain.entity.MessageEntity
import com.paulik.chatapp.domain.repo.MessageRepo
import com.paulik.chatapp.utils.mutable

class DetailsChatViewModel(
    private val messageRepo: MessageRepo,
    private val chatId: String
) : ViewModel() {

    val messageLiveData: LiveData<List<MessageEntity>> = MutableLiveData()

    init {
        if (messageLiveData.value == null) {
            messageRepo.getMessages(chatId).let {
                messageLiveData.mutable().postValue(it)
            }
        }
    }
}