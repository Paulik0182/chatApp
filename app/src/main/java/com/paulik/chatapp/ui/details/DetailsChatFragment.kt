package com.paulik.chatapp.ui.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulik.chatapp.App
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.FragmentDetailsChatBinding
import com.paulik.chatapp.domain.repo.MessageRepo

private const val IDS_CHAT_KEY = "IDS_CHAT_KEY"


class DetailsChatFragment : Fragment(R.layout.fragment_details_chat) {

    private var _binding: FragmentDetailsChatBinding? = null
    private val binding get() = _binding!!

    private val app: App get() = requireActivity().application as App

    private val messageRepo: MessageRepo by lazy {
        app.messageRepo
    }

    private lateinit var adapter: DetailsChatAdapter

    private val viewModel: DetailsChatViewModel by lazy {
        DetailsChatViewModel(
            messageRepo,
            requireArguments().getString(IDS_CHAT_KEY)!!
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDetailsChatBinding.bind(view)

        initView()

        viewModel.messageLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = DetailsChatAdapter(
            data = emptyList(),
            context = requireContext()
        )
        binding.recordsRecyclerView.adapter = adapter
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
                arguments = bundleOf(IDS_CHAT_KEY to chatIds)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}