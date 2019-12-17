

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameOverBinding
import kotlinx.android.synthetic.main.fragment_registration.*

class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_over, container, false)
        val args = GameOverFragmentArgs.fromBundle(arguments!!)
        val name = args.firstname
        val surname = args.lastname
        binding.youlosttext.text = "You lost, $name $surname "
        binding.tryAgainButton.setOnClickListener{view : View ->

            view.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
        }
        binding.gameover = this
        return binding.root
    }


}
