package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.MessageEntity
import com.paulik.chatapp.domain.entity.MessageStatus
import com.paulik.chatapp.domain.repo.MessageRepo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.*

class MessageRepoImpl : MessageRepo {

    private val messages: MutableList<MessageEntity> = mutableListOf(
        MessageEntity(
            "20",
            "Привет",
            "2",
            Calendar.getInstance().timeInMillis,
            "10",
            MessageStatus.LOADING,
            false
        ),
        MessageEntity(
            "21",
            "Это я, Привет",
            "1",
            Calendar.getInstance().timeInMillis,
            "10",
            MessageStatus.LOADING,
            true
        ),
        MessageEntity(
            "30",
            "Как дела",
            "2",
            Calendar.getInstance().timeInMillis,
            "10",
            MessageStatus.LOADING,
            false
        ),
        MessageEntity(
            "31",
            "Норм",
            "1",
            Calendar.getInstance().timeInMillis,
            "10",
            MessageStatus.LOADING,
            true
        ),
        MessageEntity(
            "40",
            "ОК",
            "2",
            Calendar.getInstance().timeInMillis,
            "10",
            MessageStatus.LOADING,
            false
        ),
        MessageEntity(
            "410",
            "Привет, это другой чат",
            "3",
            Calendar.getInstance().timeInMillis,
            "25",
            MessageStatus.LOADING,
            false
        ),
        MessageEntity(
            "42",
            "ОК, Другой чат",
            "1",
            Calendar.getInstance().timeInMillis,
            "25",
            MessageStatus.LOADING,
            true
        ),
    )

    // для подписки на обновления (прочитать про BehaviorSubject - это аналог LiveData)
    private val messagesObservable = BehaviorSubject.createDefault<List<MessageEntity>>(messages)
    override fun sendMessage(chatId: String, text: String) {
        messages.add(
            MessageEntity(
                UUID.randomUUID().toString(),
                text,
                "12",
                Calendar.getInstance().timeInMillis,
                chatId,
                MessageStatus.LOADING,
                true
            )
        )
        messagesObservable.onNext(messages)
    }

    override fun markMessageAsViewed(messageId: String) {
        TODO("Not yet implemented")
    }

    override fun getMessages(chatId: String): List<MessageEntity> {
        return messages.filter { it.chatId == chatId } // фильтруем сообщения по id (загружаем только нужные сообщения)
    }

    override fun getMessageUpdates(chatId: String): Observable<List<MessageEntity>> {
        // фильтруем сообщения именно здесь, так как во viewModel это делать нельзя, раньше получалось
        // что все сообщения передовались на UI и фильтровались там.
        // В данном случае получили объект Observable  + одно приобразование. приобразований может быть множество
        return messagesObservable.map { message ->
            message.filter { it.chatId == chatId }
        }
    }
}