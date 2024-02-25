package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cs4520.assignment3.databinding.FragmentMvvmBinding

class MVVMFragment : Fragment() {
    private var _binding: FragmentMvvmBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMvvmBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        viewModel.result.observe(viewLifecycleOwner) { result ->
            binding.resultTextView.text = result
        }
        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            Toast.makeText(context, errorMsg, Toast.LENGTH_SHORT).show()
            binding.numberInput1.text.clear()
            binding.numberInput2.text.clear()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener { viewModel.performOperation("add", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
        binding.subtractButton.setOnClickListener { viewModel.performOperation("subtract", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
        binding.multiplyButton.setOnClickListener { viewModel.performOperation("multiply", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
        binding.divideButton.setOnClickListener { viewModel.performOperation("divide", binding.numberInput1.text.toString(), binding.numberInput2.text.toString()) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
