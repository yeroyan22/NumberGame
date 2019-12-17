package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentRegistrationBinding


/**
 * A simple [Fragment] subclass.
 */
class Registration : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistrationBinding>(inflater,
                R.layout.fragment_registration, container, false)
        val firstname = binding.firstName.toString()
        val lastname = binding.lastName.toString()
        binding.startButton.setOnClickListener { view: View ->
            view.findNavController()
                    .navigate(RegistrationDirections.actionRegistrationToGameFragment(firstname, lastname))
            //view.findNavController().navigate(R.id.action_registration_to_gameFragment)
        }
        binding.registration = this
        return binding.root
    }


}
