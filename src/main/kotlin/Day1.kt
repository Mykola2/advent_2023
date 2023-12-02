val words = arrayOf(
    "zero", "one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine"
)

fun main(args: Array<String>) {
    println(readLines().sumOf { line ->
        var wordDigitsIndexes = words.flatMap { wordDigitsIndexes(line, it) }
        var digitIndexes = digitIndexes(line)
        val result = (wordDigitsIndexes + digitIndexes)
            .sortedBy { it.first }
        (result.first.second + result.last.second).toInt()
    })
}

fun wordDigitsIndexes(string: String, word: String): List<Pair<Int, String>> {
    var startIndex = 0
    val result = mutableListOf<Pair<Int, String>>()
    while (startIndex < string.length) {
        val indexOf = string.indexOf(word, startIndex)
        if (indexOf == -1) {
            break
        }
        result.add(Pair(indexOf, words.indexOf(word).toString()))
        startIndex = indexOf + 1
    }
    return result
}

fun digitIndexes(string: String): List<Pair<Int, String>> {
    val result = mutableListOf<Pair<Int, String>>()
    for ((index, char) in string.withIndex()) {
        if (char.isDigit()) {
            result.add(Pair(index, char.toString()))
        }
    }
    return result
}