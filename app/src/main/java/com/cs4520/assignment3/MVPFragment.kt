package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.FragmentMvpBinding

class MVPFragment : Fragment(), ViewInterface {
    private var _binding: FragmentMvpBinding? = null
    private val binding get() = _binding!!
    private val presenter = Presenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMvpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener { presenter.performOperation("add", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
        binding.subtractButton.setOnClickListener { presenter.performOperation("subtract", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
        binding.multiplyButton.setOnClickListener { presenter.performOperation("multiply", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
        binding.divideButton.setOnClickListener { presenter.performOperation("divide", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showResult(result: String) {
        binding.resultTextView.text = result
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
        binding.numberInput1.text.clear()
        binding.numberInput2.text.clear()
    }

}
