package com.paulik.chatapp.ui.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.paulik.chatapp.R
import com.paulik.chatapp.databinding.ActivityMainBinding
import com.paulik.chatapp.domain.entity.ChatEntity
import com.paulik.chatapp.ui.chat.ChatRootFragment
import com.paulik.chatapp.ui.details.DetailsChatFragment

private const val TAG_ROOT_CONTAINER_LAYOUT_KEY = "TAG_MAIN_CONTAINER_LAYOUT_KEY"
private const val TAG_DETAILS_CHAT_KEY = "TAG_DETAILS_CHAT_KEY"

class RootActivity : AppCompatActivity(),
    ChatRootFragment.Controller,
    DetailsChatFragment.Controller {

    private lateinit var binding: ActivityMainBinding

    private val chatRootFragment: ChatRootFragment by lazy { ChatRootFragment() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {

            swapFragment(chatRootFragment)
        } else {
            //todo иначе достать из --
        }
    }

    private fun swapFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                binding.fragmentContainerFrameLayout.id,
                fragment,
                TAG_ROOT_CONTAINER_LAYOUT_KEY
            ).commit()
    }

    private fun openDetailsChatFragment(chatIds: String) {
        val fragment: Fragment = DetailsChatFragment.newInstance(chatIds)
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            ).add(binding.fragmentContainerFrameLayout.id, fragment, TAG_DETAILS_CHAT_KEY)
            .addToBackStack(null)
            .commit()
    }

    override fun openDetailsChat(chatEntity: ChatEntity) {
        openDetailsChatFragment(chatEntity.id)
    }

}