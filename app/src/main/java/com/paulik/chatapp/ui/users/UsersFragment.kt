package com.paulik.chatapp.ui.users

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.FragmentUsersBinding

class UsersFragment : Fragment(R.layout.fragment_users) {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentUsersBinding.bind(view)

        initView()
    }

    private fun initView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = UsersAdapter(
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
        fun newInstance() =
            UsersFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}