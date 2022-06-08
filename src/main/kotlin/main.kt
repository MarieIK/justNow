fun main() {
    agoToText(86_399)
    agoToText(55)
    agoToText(1_000_000)
    agoToText(156_800)
    agoToText(2_500)
}

fun agoToText(timeInSecond: Int) {
    val result = "был(а)" + when {
        timeInSecond < 60 -> " только что"
        timeInSecond < 3_600 -> " " + secondToMinutesOrHours(timeInSecond) +
                changeEndingWordsInMinutes(timeInSecond) + " назад"
        timeInSecond < 86_400 -> " " + secondToMinutesOrHours(timeInSecond) +
                changeEndingWordsInHours(timeInSecond) + " назад"
        timeInSecond < 172_800 -> " сегодня"
        timeInSecond < 259_200 -> " вчера"
        else -> " давно"
    }
    println(result)
}

fun secondToMinutesOrHours(timeInSecond: Int): Int {
    val timeInMinutesOrHours = when {
        timeInSecond < 3_600 -> timeInSecond / 60
        timeInSecond < 86_400 -> timeInSecond / 3_600
        else -> 0
    }
    return timeInMinutesOrHours
}

fun changeEndingWordsInMinutes(timeInSecond: Int) = when (secondToMinutesOrHours(timeInSecond)) {
    1, 21, 31, 41, 51 -> " минуту"
    2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> " минуты"
    else -> " минут"
}

fun changeEndingWordsInHours(timeInSecond: Int) = when (secondToMinutesOrHours(timeInSecond)) {
    1, 21 -> " час"
    2, 3, 4, 22, 23, 24 -> " часа"
    else -> " часов"
}