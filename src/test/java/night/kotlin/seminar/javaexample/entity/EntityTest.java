package night.kotlin.seminar.javaexample.entity;

import static org.assertj.core.api.Java6Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntityTest {

	@Test
	public void entityMakeNewObjectTest() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1L, "아이템_5", 5L));
		items.add(new OrderItem(2L, "아이템_10", 10L));

		Order order = new Order(
			1L,
			new User(1L, "강현식", "cj848@hanmail.net"),
			items
		);

		assertOrder(order);
	}

	@Test
	public void entityMakeNewObjectTest_jdk9_style() {
		Order order = new Order(
			1L,
			new User(1L, "강현식", "cj848@hanmail.net"),
			List.of(
				new OrderItem(1L, "아이템_5", 5L),
				new OrderItem(2L, "아이템_10", 10L)
				   )
		);

		assertOrder(order);
	}

	@Test
	public void entityMakeNewObjectTest_guava_style() {
		Order order = new Order(
			1L,
			new User(1L, "강현식", "cj848@hanmail.net"),
			Lists.newArrayList(
				new OrderItem(1L, "아이템_5", 5L),
				new OrderItem(2L, "아이템_10", 10L)
				   )
		);

		assertOrder(order);
	}


	private void assertOrder(Order order) {
		log.info("주문 id: {}, 총 금액: {}, 유저 이름: {}", order.getId(), order.getAmount(), order.getUser().getName());

		assertThat(order.getId()).isEqualTo(1L);
		assertThat(order.getAmount()).isEqualTo(15L);
		assertThat(order.getUser().getName()).isEqualTo("강현식");
	}

	@Test
	public void entityMakeWithBuilderTest() {
		Order order = Order.builder()
			.setId(1L)
			.setUser(
				User.builder()
					.setEmail("cj848@hanmail.net")
					.setId(1L)
					.setName("강현식")
					.build()
					)
			.setItems(Lists.newArrayList(
				OrderItem.builder()
					.setId(1L)
					.setName("아이템_5")
					.setAmount(5L)
					.build(),
				OrderItem.builder()
					.setId(2L)
					.setName("아이템_10")
					.setAmount(10L)
					.build())
					 )
			.build();

		assertOrder(order);
	}
}
