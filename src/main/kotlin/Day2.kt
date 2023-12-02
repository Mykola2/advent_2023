fun main(args: Array<String>) {
    val result = mutableListOf<Int>()
    readLines().forEach { gameLine ->
        val data = gameLine.split(":")[1]
            .split(";")
            .map { sets -> sets.trim().split(", ") }
        result.add(maxCubesByColor(data).values.reduce { agg, i -> agg * i })

    }
    println(result.sum())
}

fun maxCubesByColor(sets: List<List<String>>): Map<String, Int> {
    val maxCubesByColor = mutableMapOf(Pair("red", 0), Pair("blue", 0), Pair("green", 0))
    sets.flatten().forEach { set ->
            val split = set.split(" ")
            if (maxCubesByColor[split[1]]!! < split[0].toInt()) {
                maxCubesByColor[split[1]] = split[0].toInt()
            }
        }
    return maxCubesByColor
}

