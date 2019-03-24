package night.kotlin.seminar.javaexample.entity.lombok;

import static org.assertj.core.api.Java6Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntityWithLombokTest {

	@Test
	public void entityWithLombokTest() {
		Order order = Order.builder()
			.id(1L)
			.user(
				User.builder()
					.email("cj848@hanmail.net")
					.id(1L)
					.name("강현식")
					.build()
					)
			.items(Lists.newArrayList(
				OrderItem.builder()
					.id(1L)
					.name("아이템_5")
					.amount(5L)
					.build(),
				OrderItem.builder()
					.id(2L)
					.name("아이템_10")
					.amount(10L)
					.build())
					 )
			.build();

		log.info("주문 id: {}, 총 금액: {}, 유저 이름: {}", order.getId(), order.getAmount(), order.getUser().getName());

		assertThat(order.getId()).isEqualTo(1L);
		assertThat(order.getAmount()).isEqualTo(15L);
		assertThat(order.getUser().getName()).isEqualTo("강현식");
	}
}
