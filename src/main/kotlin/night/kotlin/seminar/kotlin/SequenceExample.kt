package night.kotlin.seminar.kotlin

fun main() {

    val badPerformanceList = listOf(1, 2, 3, 4, 5)
            .filter { it % 2 == 0 }
            .map { it * it}

    println("badPerformanceList 사이즈 : ${badPerformanceList.size}")

    val likeJava8StreamList = listOf(1, 2, 3, 4, 5)
            .asSequence()
            .filter { it % 2 == 0 }
            .map { it * it}
            .toList()

    println("list 사이즈 : ${likeJava8StreamList.size}")
    println("badPerformanceList == likeJava8StreamList : ${badPerformanceList == likeJava8StreamList}")
}