package com.pluralsight.example.module2

object GlobomanticsTransfer {

  sealed trait ISOCountryCode //Alpha-2 country abbreviation according to ISO
  object ISOCountryCode {
    case object SG extends ISOCountryCode
    case object IN extends ISOCountryCode
  }

  abstract class Currency(val isoCode: ISOCountryCode, val desc: String)
  case object SGD extends Currency(ISOCountryCode.SG, "Singapore Dollar")
  case object INR extends Currency(ISOCountryCode.IN, "Indian Rupees")
  object Currency {
    type SGD = SGD.type
    type INR = INR.type
  }

  case class Amount[T](value: Double, currency: T){
    def add(amount: Double): Amount[T] = this.copy(value = value + amount)
    def sub(amount: Double): Amount[T] = {
      require(value > amount, "Not enough value to subtract")
      this.copy(value = value - amount)
    }

    def add(amount: Amount[T]): Amount[T] = add(amount.value)
    def sub(amount: Amount[T]): Amount[T] = sub(amount.value)
  }

  case class TransferInfo[T, U](sending: Amount[T],
                                receiving: Amount[U],
                                fee: Amount[T],
                                conversionRate: Amount[U])

  def main(args: Array[String]): Unit = {
    import Currency._
    val sendingAmount: Amount[SGD] = Amount(1000.0, SGD)

    val fee: Amount[SGD] = Amount(0.0058 * sendingAmount.value, sendingAmount.currency)
    val conversionRate: Amount[INR] = Amount(55.38, INR)

    val amountToBeConverted: Amount[SGD] = sendingAmount.sub(fee)
    val receivingAmount: Amount[INR] = Amount(amountToBeConverted.value * conversionRate.value, INR)

    val tInfo: TransferInfo[SGD, INR] =
      TransferInfo(sendingAmount, receivingAmount, fee, conversionRate)

    println(s"TransferInfo -- $tInfo")

  }
}