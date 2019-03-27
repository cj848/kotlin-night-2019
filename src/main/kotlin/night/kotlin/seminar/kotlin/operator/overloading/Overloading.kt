package night.kotlin.seminar.kotlin.operator.overloading

data class Point(val x: Int, val y: Int) {
    operator fun plus(point: Point) = Point(point.x + x, point.y + y)
    operator fun minus(point: Point) = Point(x - point.x, y - point.y)
}
operator fun Point.unaryMinus() = Point(-x, -y)

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5)

    println(list[0] == 1)
    list += 6
    println("$list, sixth element: ${list[5]}")

    val map = mutableMapOf("key" to "value", "key1" to "value1")

    map["key2"] = "value2"
    map += mapOf("55" to "66")
    println(map["key1"])
    println(map["key2"])
    println(map["55"])
    println("map에는 55키가 존재하는가? : ${"55" in map}")

    val point = Point(10, 20)
    println(-point)
    println(point + point)
    println("point + point == point.plus(point) 와 동일하다: ${point + point == point.plus(point)}")
    println(point - point)
}
