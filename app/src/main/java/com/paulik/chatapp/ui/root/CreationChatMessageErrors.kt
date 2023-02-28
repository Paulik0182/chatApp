package com.paulik.chatapp.ui.root

sealed class CreationChatMessageErrors(val errorsChatMessage: String) {
    class TextChatMessage(errorsChatMessage: String) :
        CreationChatMessageErrors(errorsChatMessage)
}
