package night.kotlin.seminar.kotlin

import org.junit.jupiter.api.Test

class IfTest {
    @Test
    fun `if 는 식(expression)으로써 값에 대입 가능하며 리턴값으로도 활용 가능`() {
        val result =
                if ("kotlin" > "java")
                    "Kotlin이 짱이다"
                else "아니다 Java가 짱이쥐!"

        println(result)
        println(stringCompare("kotlin", "scala"))
    }

    fun stringCompare(string1: String, string2: String): String {
        return if (string1 > string2) "$string1 이 더 크다" else "아니여~ $string2 가 더 크제"
    }
}