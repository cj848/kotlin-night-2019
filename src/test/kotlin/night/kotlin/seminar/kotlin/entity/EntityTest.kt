package night.kotlin.seminar.kotlin.entity

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityTest {
    @Test
    fun `엔티티 테스트`() {
        val order = Order(
                1,
                User(
                        1,
                        "강현식",
                        "cj848@hanmail.net"
                ),
                listOf(
                        OrderItem(
                                1,
                                "아이템_5",
                                5
                        ),
                        OrderItem(
                                2,
                                "아이템_10",
                                10
                        )
                )
        )

        assertThat(order.id).isEqualTo(1L)
        assertThat(order.amount).isEqualTo(15L)
        assertThat(order.user.name).isEqualTo("강현식")
        println(order)
        println("주문 id: ${order.id}, 총 금액: ${order.amount}, 유저 이름: ${order.user.name}")
    }
}