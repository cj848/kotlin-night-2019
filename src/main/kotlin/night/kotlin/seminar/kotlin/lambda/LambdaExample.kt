package night.kotlin.seminar.kotlin.lambda

// object -> Singleton 의 문법 지원
object LambdaExample {
    // high order function
    // function return 축약 버전
    fun add(number: Long) = { it: Long -> it + number }

    // 풀어쓴 버전
    fun add1(number: Long): (Long) -> (Long) {
        return { it + number }
    }

    // 리턴만 생략
    fun add2(number: Long): (Long) -> (Long) = { it + number }

    // currying 함수 버전
    fun add3(numSupplier: () -> Long) = { num: Long -> { it: Long -> it + num + numSupplier() } }

    // currying 변수 버전
    val add4 = { numSupplier: () -> Long -> { num: Long -> { it: Long -> it + num + numSupplier() } } }
}