package night.kotlin.seminar.kotlin

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AppTest {

    @Test
    fun `한글로도 테스트 메소드 이름을 만들 수 있습니다`() {
        println("한글로 잘 나옵니다")
    }
}