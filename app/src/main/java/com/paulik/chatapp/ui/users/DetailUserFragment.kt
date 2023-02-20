package com.paulik.chatapp.ui.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.FragmentDetailUserBinding

class DetailUserFragment : Fragment(R.layout.fragment_detail_user) {

    private var _binding: FragmentDetailUserBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDetailUserBinding.bind(view)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DetailUserFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}