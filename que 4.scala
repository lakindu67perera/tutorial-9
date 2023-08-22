class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  def getBalance: Double = balance
}

object BankTest extends App {
  val accounts: List[Account] = List(
    new Account(1000),
    new Account(-200),
    new Account(500),
    new Account(-100)
  )

  // 4.1 List of Accounts with negative balances
  val negativeBalanceAccounts: List[Account] = accounts.filter(account => account.getBalance < 0)
  println("Accounts with negative balances:\n")
  negativeBalanceAccounts.foreach(account => println(s"Account balance: ${account.getBalance}"))

  // 4.2 Calculate the sum of all account balances
  val totalBalance: Double = accounts.map(_.getBalance).sum
  println(s"\nTotal balance of all accounts: $totalBalance")

  // 4.3 Calculate the final balances after applying interest
  accounts.foreach(_.applyInterest())
  println("\nFinal balances after applying interest:\n")
  accounts.foreach(account => println(s"Account balance: ${account.getBalance}"))
}
