package night.kotlin.seminar.kotlin

import java.util.stream.Stream
import kotlin.streams.toList

fun main() {
    val powList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
            .map { it * it }
            .toList()

    for (pow in powList) {
        println(pow)
    }
}

