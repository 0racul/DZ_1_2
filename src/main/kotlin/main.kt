fun transfers(amountInRubles: Float): Int {

    val amountInCents = amountInRubles * 100

    var comission = ((amountInCents * 0.0075) / 100).toFloat()

    if (comission < 35f){

        comission = 35f

    }

    return comission.toInt()

}

fun likes(likesAmount: Int) = when {
        (likesAmount % 10) > 1 || (likesAmount % 100) != 1 -> "людям"
        (likesAmount % 10) == 1 -> "Человеку"
        (likesAmount % 1000) == 0 -> "людей"
    else -> "людям"
    }

fun musicCharges(initialSum: Int, regularCustomer: Boolean): Float{

    var discount = 0

    val initialSumInCents = initialSum * 100

    if (initialSumInCents > 1000_00 && initialSumInCents < 10001_00) {

        discount = 100_00

    }
    else if (initialSumInCents >= 10001_00){

        discount = initialSumInCents / 100 * 5
    }

    val sumAfterDiscount = ((initialSumInCents - discount).toFloat()) / 100

    return if (regularCustomer) {

        sumAfterDiscount - (sumAfterDiscount / 100)
    }
    else sumAfterDiscount
}


fun main(args: Array<String>){


    val commission = transfers(1000.55f)

    println(commission)

    val likesAmount = 11101
    val ppl = likes(likesAmount)

    println("$likesAmount $ppl")

    val charge = musicCharges(1000500, true)

    println(charge)

}
