package com.paulik.chatapp.ui.details

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paulik.chatapp.domain.entity.MessageEntity
import com.paulik.chatapp.domain.repo.MessageRepo
import com.paulik.chatapp.utils.mutable

@SuppressLint("CheckResult")
class DetailsChatViewModel(
    private val messageRepo: MessageRepo,
    private val chatId: String
) : ViewModel() {

    val messageLiveData: LiveData<List<MessageEntity>> = MutableLiveData()

    init {
        messageRepo.getMessageUpdates(chatId).subscribe {// подписка на обновление
            messageRepo.getMessages(chatId).let {
                messageLiveData.mutable().postValue(it)
            }
        }
//        if (messageLiveData.value == null) {
//            messageRepo.getMessages(chatId).let {
//                messageLiveData.mutable().postValue(it)
//            }
//        }
    }

    // todo переделать репозиторий чтобы они были на реактивном программировании.
}