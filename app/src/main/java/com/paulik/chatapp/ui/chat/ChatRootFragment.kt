package com.paulik.chatapp.ui.chat

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulik.chatapp.App
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.FragmentChatRootBinding
import com.paulik.chatapp.domain.entity.ChatEntity
import com.paulik.chatapp.domain.repo.ChatRepo
import com.paulik.chatapp.domain.repo.UsersRepo

private const val IDS_USERS_KEY = "IDS_USERS_KEY"

class ChatRootFragment : Fragment(R.layout.fragment_chat_root) {

    private var _binding: FragmentChatRootBinding? = null
    private val binding get() = _binding!!

    private val app: App get() = requireActivity().application as App
    private val chatRepo: ChatRepo by lazy {
        app.chatRepo
    }

    private val usersRepo: UsersRepo by lazy {
        app.usersRepo
    }

    private lateinit var adapter: ChatRootAdapter

    private val viewModel: ChatRootViewModel by viewModels {
        ChatRootViewModel.Factory(
            chatRepo, usersRepo
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentChatRootBinding.bind(view)

        initView()

        viewModel.chatLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        viewModel.selectedDetailsChatLiveData.observe(viewLifecycleOwner) {
            getController().openDetailsChat(it)
        }
    }

    private fun initView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ChatRootAdapter(
            data = emptyList(),
            context = requireContext(),
            onDetailsChatClickListener = { chatId ->
                viewModel.onChatClick(chatId)
            } // todo не понял зачем
        )
        binding.recordsRecyclerView.adapter = adapter
    }

    interface Controller {
        fun openDetailsChat(chatEntity: ChatEntity)
    }

    private fun getController(): Controller = activity as Controller

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getController()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChatRootFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}