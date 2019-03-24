package night.kotlin.seminar.kotlin.entity.builder

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

import night.kotlin.seminar.javaexample.entity.Order as JavaOrder
import night.kotlin.seminar.javaexample.entity.OrderItem as JavaOrderItem
import night.kotlin.seminar.javaexample.entity.User as JavaUser

class EntityLikeBuilderTest {
    private val log = LoggerFactory.getLogger(EntityLikeBuilderTest::class.java)

    @Test
    fun entityJavaEntityTest() {
        val order = JavaOrder().apply {
            id = 1L
            user = JavaUser().apply {
                email = "cj848@hanmail.net"
                id = 1L
                name = "강현식"
            }
            items = listOf(
                    JavaOrderItem().apply {
                        id = 1L
                        name = "아이템_5"
                        amount = 5L
                    },
                    JavaOrderItem().apply {
                        id = 2L
                        name = "아이템_10"
                        amount = 10L
                    }
            )
        }

        log.info("주문 id: ${order.id}, 총 금액: ${order.amount}, 유저 이름: ${order.user?.name}")

        assertThat(order.id).isEqualTo(1L)
        assertThat(order.amount).isEqualTo(15L)
        assertThat(order.user!!.name).isEqualTo("강현식")
    }

    @Test
    fun entityLikeBuilderTest() {
        val order = Order().apply {
            id = 1
            user = User().apply {
                email = "cj848@hanmail.net"
                id = 1L
                name = "강현식"
            }
            items = listOf(
                    OrderItem().apply {
                        id = 1L
                        name = "아이템_5"
                        amount = 5L
                    },
                    OrderItem().apply {
                        id = 2L
                        name = "아이템_10"
                        amount = 10L
                    }
            )
        }

        log.info("주문 id: ${order.id}, 총 금액: ${order.amount}, 유저 이름: ${order.user?.name}")

        assertThat(order.id).isEqualTo(1L)
        assertThat(order.amount).isEqualTo(15L)
        assertThat(order.user!!.name).isEqualTo("강현식")
    }

    @Test
    fun apply예제() {
        Order().apply({
            // 이게 풀어쓴 표현
            // 사실 apply 의 block 이 이 전달된 함수이다
            id = 1L
        })
        Order().apply { // Lambda 를 이런식으로 생략해서 표현이 가능

            id = 1L
        }

    }
}