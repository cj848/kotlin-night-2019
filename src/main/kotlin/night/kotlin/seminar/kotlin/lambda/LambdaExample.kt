package night.kotlin.seminar.kotlin.lambda

// object -> Singleton 의 문법 지원
object LambdaExample {
    // function return 축약 버전
    fun add(number: Long) = { it: Long -> it + number }
    // 풀어쓴 버전
    fun add1(number: Long): (Long) -> (Long) {
        return { it + number }
    }
    // 리턴만 생략
    fun add2(number: Long): (Long) -> (Long) = { it + number }
    // currying function 버전
    // JS 의 경우 function add3(num) = { return it => num + it } 와 동일
    fun add3() = {num: Long -> { it: Long -> it + num }}

    // currying 변수 함수 버전
    // JS 의 경우 const add4 = num => it => num + it 로 더 간단히 가능함
    val add4 = {num: Long -> { it: Long -> it + num }}
}