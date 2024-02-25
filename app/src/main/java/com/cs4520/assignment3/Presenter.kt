package com.cs4520.assignment3

interface CalculatorPresenter {
    fun performOperation(operation: String, a: String, b: String)
}

class Presenter(private val view: MVPFragment) : CalculatorPresenter {
    private val model = Model()

    override fun performOperation(operation: String, a: String, b: String) {
        try {
            val result = when (operation) {
                "add" -> model.add(a.toDouble(), b.toDouble())
                "subtract" -> model.subtract(a.toDouble(), b.toDouble())
                "multiply" -> model.multiply(a.toDouble(), b.toDouble())
                "divide" -> model.divide(a.toDouble(), b.toDouble())
                else -> {}
            }
            view.showResult(result.toString())
        } catch (e: Exception) {
            view.showError("Invalid input")
        }
    }
}


// Original code, thought I could trim it down w a switch statement.
// Keeping just in case this fails

//interface CalculatorPresenter {
//    fun add(a: String, b: String)
//    fun subtract(a: String, b: String)
//    fun multiply(a: String, b: String)
//    fun divide(a: String, b: String)
//}
//
//class Presenter(private val view: MVPFragment) : CalculatorPresenter {
//    private val model = Model()
//
//    override fun add(a: String, b: String) {
//        try {
//            val result = model.add(a.toDouble(), b.toDouble())
//            view.showResult(result.toString())
//        } catch (e: Exception) {
//            view.showError("Invalid input")
//        }
//    }
//
//    override fun subtract(a: String, b: String) {
//        try {
//            val result = model.subtract(a.toDouble(), b.toDouble())
//            view.showResult(result.toString())
//        } catch (e: Exception) {
//            view.showError("Invalid input")
//        }
//    }
//
//    override fun multiply(a: String, b: String) {
//        try {
//            val result = model.multiply(a.toDouble(), b.toDouble())
//            view.showResult(result.toString())
//        } catch (e: Exception) {
//            view.showError("Invalid input")
//        }
//    }
//
//    override fun divide(a: String, b: String) {
//        try {
//            val result = model.divide(a.toDouble(), b.toDouble())
//            view.showResult(result.toString())
//        } catch (e: Exception) {
//            view.showError("Invalid input")
//        }
//    }
//
//}

