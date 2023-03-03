package com.paulik.chatapp.ui.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulik.chatapp.App
import com.paulik.chatapp.databinding.FragmentDetailsChatBinding
import com.paulik.chatapp.domain.interactors.MessageCreatorInteractor
import com.paulik.chatapp.domain.repo.MessageRepo
import com.paulik.chatapp.ui.root.CreationChatMessageErrors
import com.paulik.chatapp.ui.root.ViewBindingFragment
import com.paulik.chatapp.utils.toastMake
import java.util.*

private const val ID_CHAT_KEY = "ID_CHAT_KEY"


class DetailsChatFragment : ViewBindingFragment<FragmentDetailsChatBinding>(
    FragmentDetailsChatBinding::inflate
) {

    private val app: App get() = requireActivity().application as App

    // это передача контекста всего экрана, всего приложения (при повороте экрана не меняется)
    private val app1: App get() = requireActivity().applicationContext as App

    private val messageRepo: MessageRepo by lazy {
        app.messageRepo
    }

    private val messageCreatorInteractor: MessageCreatorInteractor by lazy {
        app.messageCreatorInteractor
    }

    private lateinit var adapter: DetailsChatAdapter

    private val timeSendingMessage = Calendar.getInstance()

    private val viewModel: DetailsChatViewModel by lazy {
        DetailsChatViewModel(
            messageRepo = messageRepo,
            chatId = requireArguments().getString(ID_CHAT_KEY)!!,
            messageCreatorInteractor = messageCreatorInteractor
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObservers()
    }

    private fun initView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = DetailsChatAdapter(
            data = emptyList(),
            context = requireContext()
        )
        binding.recordsRecyclerView.adapter = adapter

        binding.sendMessageButton.setOnClickListener {
            saveNewMessage()
        }
    }

    private fun saveNewMessage() {
        viewModel.onSaveNewMessage(
            context = requireActivity(),
            id = UUID.randomUUID().toString(),
            authorId = "1",
            chatId = requireArguments().getString(ID_CHAT_KEY)!!,
            text = binding.descriptionEditText.text.toString(),
            time = timeSendingMessage.timeInMillis,
            mine = true
        )
        binding.descriptionEditText.text = null
    }

    private fun initObservers() {
        viewModel.messageLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is CreationChatMessageErrors.TextChatMessage -> {
                    binding.descriptionEditText.error = it.errorsChatMessage
                }
                else -> {}
            }
        }

        viewModel.systemAlertLiveData.observe(viewLifecycleOwner) {
            context?.toastMake(it.message)
        }
    }

    interface Controller {
        // todo
    }

    private fun getController(): Controller = activity as Controller

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getController()
    }

    companion object {

        @JvmStatic
        fun newInstance(chatIds: String) =
            DetailsChatFragment().apply {
                arguments = bundleOf(ID_CHAT_KEY to chatIds)
            }
    }
}