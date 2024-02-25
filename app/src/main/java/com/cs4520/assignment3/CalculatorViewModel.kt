package com.cs4520.assignment3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val model = Model()
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun performOperation(operation: String, a: String, b: String) {
        try {
            val num1 = a.toDouble()
            val num2 = b.toDouble()
            val operationResult = when (operation) {
                "add" -> model.add(num1, num2)
                "subtract" -> model.subtract(num1, num2)
                "multiply" -> model.multiply(num1, num2)
                "divide" -> model.divide(num1, num2)
                else -> throw IllegalArgumentException("Invalid operation")
            }
            _result.postValue(operationResult.toString())
        } catch (e: Exception) {
            _error.postValue(e.message ?: "Error")
        }
    }

}
