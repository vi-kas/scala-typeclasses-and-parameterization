package com.pluralsight.example.module2

object GlobomanticsTransferUnTyped {

  sealed trait ISOCountryCode //Alpha-2 country abbreviation according to ISO
  object ISOCountryCode {
    case object SG extends ISOCountryCode
    case object IN extends ISOCountryCode
  }

  abstract class Currency(val isoCode: ISOCountryCode, val desc: String)
  case object SGD extends Currency(ISOCountryCode.SG, "Singapore Dollar")
  case object INR extends Currency(ISOCountryCode.IN, "Indian Rupees")

  case class Amount(value: Double, currency: Currency){
    def add(amount: Double): Amount = this.copy(value = value + amount)
    def sub(amount: Double): Amount = {
      require(value > amount, "Not enough value to subtract")
      this.copy(value = value - amount)
    }

    def add(amount: Amount): Amount = add(amount.value)
    def sub(amount: Amount): Amount = sub(amount.value)
  }

  case class TransferInfo(sending: Amount,
                                receiving: Amount,
                                fee: Amount,
                                conversionRate: Amount)

  def main(args: Array[String]): Unit = {
    val sendingAmount: Amount = Amount(1000.0, SGD)

    val fee: Amount = Amount(0.0058 * sendingAmount.value, sendingAmount.currency)
    val conversionRate: Amount = Amount(55.38, INR)

    val amountToBeConverted: Amount = sendingAmount.sub(fee)
    val receivingAmount: Amount = Amount(amountToBeConverted.value * conversionRate.value, INR)

    val tInfo: TransferInfo =
      TransferInfo(sendingAmount, receivingAmount, fee, conversionRate)

    println(s"TransferInfo -- $tInfo")

  }

}
