class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Invalid deposit amount.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Invalid withdrawal amount.")
    }
  }

  def transfer(amount: Double, targetAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      targetAccount.deposit(amount)
      println(s"Transferred $amount to target account. New balance: $balance")
    } else {
      println("Invalid transfer amount.")
    }
  }

  def getBalance: Double = balance
}

object AccountTest extends App {
  val account1 = new Account(1000)
  val account2 = new Account(500)

  println("Initial balances:")
  println(s"Account 1: ${account1.getBalance}")
  println(s"Account 2: ${account2.getBalance}")

  account1.deposit(200)
  account1.withdraw(150)
  account1.transfer(300, account2)

  println("Final balances:")
  println(s"Account 1: ${account1.getBalance}")
  println(s"Account 2: ${account2.getBalance}")
}
