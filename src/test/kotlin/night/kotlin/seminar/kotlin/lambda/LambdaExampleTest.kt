package night.kotlin.seminar.kotlin.lambda

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LambdaExampleTest {
    @Test
    fun `코틀린은 펑션을 리턴할 할 수 있다`() {
        assertThat(LambdaExample.add(1).invoke(1L)).isEqualTo(2L)
        assertThat(LambdaExample.add1(1).invoke(1L)).isEqualTo(2L)
        assertThat(LambdaExample.add2(1).invoke(1L)).isEqualTo(2L)

        // currying 을 서포트하는 문법도 지원
        assertThat(LambdaExample.add(1)(2)).isEqualTo(3L)
        // currying 형태의 함수 형태로도 지원 약간 불편하지만 조금 더 명확한듯..
        assertThat(LambdaExample.add3()(1)(2)).isEqualTo(3L)
        // currying 형태의 변수 형태로도 지원
        assertThat(LambdaExample.add4(1)(2)).isEqualTo(3L)

        val addOne = LambdaExample.add(1)
        println(addOne)
        assertThat(addOne(5)).isEqualTo(6L)
    }

    @Test
    fun `변수에 함수를 직접 담을 수 있고 함수 타입을 출력해보면 Function이 아닌 함수 타입이 출력된다`() {
        val func = { num: Long -> num + 4 }

        print(func)

        assertThat(func(1))
        assertThat(func.invoke(1))
    }

}