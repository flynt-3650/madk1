package ru.flynt3650.project

import java.time.LocalDateTime

fun main() {
    val expenseList = ExpenseList(mutableListOf())

    expenseList.addExpense(Expense(50.0, "Food", LocalDateTime.now()))
    expenseList.addExpense(Expense(20.0, "Transport", LocalDateTime.now()))
    expenseList.addExpense(Expense(30.0, "Food", LocalDateTime.now()))
    expenseList.addExpense(Expense(100.0, "Entertainment", LocalDateTime.now()))

    println()
    expenseList.displayExpenses()

    println()
    expenseList.calculateExpensesByType()
}

data class Expense(val sum: Double, val type: String, val date: LocalDateTime)

data class ExpenseList(var expenses: MutableList<Expense>) {
    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun displayExpenses() {
        for (i in expenses) {
            println(i)
        }
    }

    fun calculateExpensesByType() {
        val typeToSum: MutableMap<String, Double> = mutableMapOf()

        for (i in expenses) {
            val type = i.type
            val sum = i.sum

            if (type in typeToSum) {
                typeToSum[type] = typeToSum[type]?.plus(sum) ?: 0.0
            } else {
                typeToSum[type] = sum
            }
        }

        for ((type, sum) in typeToSum) {
            println("Type: $type, Total: $sum")
        }
    }
}