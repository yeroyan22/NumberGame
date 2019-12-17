package com.example.android.navigation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding
import kotlin.random.Random


class GameFragment : Fragment() {
    private val random = Random.nextInt()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        val args = RegistrationArgs.fromBundle(arguments!!)
        val firstname = args.firstname
        val lastname = args.lastname
        val enterNumber = binding.enterNumber.toString()
        binding.game = this

        binding.enterNumber.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable) {
                binding.enterButton.isEnabled = binding.enterNumber.text.toString() != ""
            }

        })

        binding.enterButton.setOnClickListener { view: View ->
            if (3 == binding.enterNumber.text.toString().toInt()) {
                view.findNavController()
                        .navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(enterNumber, firstname, lastname))
                //view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
            } else {
               view.findNavController()
        .navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment(firstname, lastname))
                //view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
            }
        }

        return binding.root
    }
}
