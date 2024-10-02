package com.example.coffemachine

fun main () {
    serveCoffee()
}

fun serveCoffee() {
    println("Who is this cup of coffee for?")
    val person = readln()

    println("Please choose the type of coffee:")
    println("1. Espresso")
    println("2. Cappuccino")
    println("3. Latte")

    // Handle coffee type input
    val coffeeType = when (readln()) {
        "1" -> "Espresso"
        "2" -> "Cappuccino"
        "3" -> "Latte"
        else -> {
            println("Invalid choice. Please select a valid coffee type.")
            return
        }
    }

    println("How many spoons of sugar does $person take?")

    val sugarCount = try {
        readln().toInt()
    } catch (e: NumberFormatException) {
        println("Please enter a valid number for sugar.")
        return
    }

    makeCoffee(coffeeType, sugarCount, person)
}

fun makeCoffee(coffeeType: String, sugarCount: Int, name: String) {
    val sugarDescription = when (sugarCount) {
        0 -> "no sugar"
        1 -> "1 spoon of sugar"
        in 2..Int.MAX_VALUE -> "$sugarCount spoons of sugar"
        else -> "an invalid amount of sugar"
    }

    // Print the coffee preparation details
    println("Serving a $coffeeType with $sugarDescription for $name.")
}
