package classObject.encapsulation

class BankAccount(private var balance: Double) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("$amount deposit successfully!")
        }
        else {
            println("Invalid deposit amount")
        }
    }

    fun withdraw(amount: Double) {
        if (balance > amount && amount > 0) {
            balance -= amount
            println("$amount withdraw successfully!")
        }
        else {
            println("Your balance is insufficient to withdraw this amount")
        }
    }

    fun checkBalance() {
        println("Your balance is $balance\n")
    }
}

fun main() {
    val bankAccount = BankAccount(1000.0)
    bankAccount.checkBalance()

    bankAccount.deposit(400.0)
    bankAccount.checkBalance()

    bankAccount.withdraw(550.0)
    bankAccount.checkBalance()

    bankAccount.withdraw(1000.0)
    bankAccount.checkBalance()

    bankAccount.deposit(-20.0)
    bankAccount.checkBalance()
}