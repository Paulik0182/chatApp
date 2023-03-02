package com.paulik.chatapp.ui.details

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paulik.chatapp.R
import com.paulik.chatapp.domain.ErrorMessage
import com.paulik.chatapp.domain.entity.MessageEntity
import com.paulik.chatapp.domain.interactors.MessageCreatorInteractor
import com.paulik.chatapp.domain.repo.MessageRepo
import com.paulik.chatapp.ui.CloseDialog
import com.paulik.chatapp.ui.root.CreationChatMessageErrors
import com.paulik.chatapp.utils.mutable
import com.paulik.chatapp.utils.toString

@SuppressLint("CheckResult")
class DetailsChatViewModel(
    private val messageRepo: MessageRepo,
    private val chatId: String,
    private val messageCreatorInteractor: MessageCreatorInteractor

) : ViewModel() {

    val messageLiveData: LiveData<List<MessageEntity>> = MutableLiveData()

    // для дополнительного уведомления
    val dialogLiveData: LiveData<CloseDialog> = MutableLiveData()

    // для сообщения ошибки
    val errorLiveData: LiveData<CreationChatMessageErrors> = MutableLiveData()

    init {
        messageRepo.getMessageUpdates(chatId).subscribe {// подписка на обновление
            messageRepo.getMessages(chatId).let {
                messageLiveData.mutable().postValue(it)
            }
        }
    }

    // todo переделать репозиторий чтобы они были на реактивном программировании.

    fun onSaveNewMessage(
        context: Context,
        id: String,
        authorId: String,
        chatId: String,
        text: String,
        time: Long?,
        mine: Boolean
    ) {
        when {
            text.isEmpty() -> {
                CreationChatMessageErrors.TextChatMessage(
                    ErrorMessage.TEXT_CHAT_MESSAGE.toString(context)
                )
            }
            else -> {
                messageCreatorInteractor.send(
                    id = id,
                    authorId = authorId,
                    chatId = chatId,
                    text = text,
                    time = time,
                    mine = mine
                )
                dialogLiveData.mutable().postValue(
                    CloseDialog.ShowCloseDialog(context.getString(R.string.shipped))
                )
                null
            }
        }?.let {
            errorLiveData.mutable().postValue(it)
            return
        }
    }
}