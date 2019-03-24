package night.kotlin.seminar.kotlin.lambda

// object -> Singleton 의 문법 지원
object LambdaExample {
    fun add(number: Long) = { it: Long -> it + number }
    fun add1(number: Long): (Long) -> (Long) {
        return { it + number }
    }
    fun add2(number: Long): (Long) -> (Long) = { it + number }
}