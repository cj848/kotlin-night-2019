package night.kotlin.seminar.kotlin

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DataClassTest {

    data class RequestVO<T>(val request: T,
                            val transactionId: Long,
                            val requesterId: String,
                            val createdAt: LocalDateTime)

    @Test
    fun `dataClass + Generic 활용 예`() {
        val autoGenericTypeInferredRequest = RequestVO("test", 1L, "id", LocalDateTime.now())
        val itIsNoLongerNecessaryDiamond = RequestVO<String>("또 다른 요청", 2L, "id", LocalDateTime.now())

        println(autoGenericTypeInferredRequest)
        println(itIsNoLongerNecessaryDiamond)
    }

    @Test
    fun `dataClass copy 메소드는 특정 값만 복사 할 수 있다`() {
        val request = RequestVO("test", 1L, "id", LocalDateTime.now())

        val copiedRequest = request.copy(transactionId = 2L, createdAt = LocalDateTime.now())

        println(copiedRequest)
        // Kotlin의 == 는 java의 Object.equals 와 동일하며 java 의 ==(참조, 값비교) 와는 ===가 동일하다
        assertThat(request.request == copiedRequest.request).isTrue()
        assertThat(request.transactionId == copiedRequest.transactionId).isFalse()
        assertThat(request.createdAt == copiedRequest.createdAt).isFalse()
    }

    @Test
    fun `dataClass 는 모든 주 생성자 멤버에 대한 equals & hashCode를 기본 구현하고 있다`() {
        val request1 = RequestVO("test", 1L, "id", LocalDateTime.now())
        // kotlin 의 모든 메소드는 기본적으로 overloading 이 가능
        val request2 = request1.copy()
        // Kotlin의 == 는 java의 Object.equals 와 동일하며 equals & hashCode 가 모든 생성자 기준 '자동' 구현 되었기 때문에 테스트 성공
        assertThat(request1 == request2).isTrue()
    }
}