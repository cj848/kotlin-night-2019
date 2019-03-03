package night.kotlin.seminar.javaexample.entity;

import java.util.List;

public class Order {
	private Long id;
	private User user;
	private List<OrderItem> items;

	public Order(Long id, User user, List<OrderItem> items) {
		this.id = id;
		this.user = user;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Long getAmount() {
		return items.stream()
			.map(OrderItem::getAmount)
			.reduce(Long::sum)
			.orElse(0L);
	}

	public static OrderBuilder builder() {
		return new OrderBuilder();
	}

	public static class OrderBuilder {
		private Long id;
		private User user;
		private List<OrderItem> items;

		public OrderBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public OrderBuilder setUser(User user) {
			this.user = user;
			return this;
		}

		public OrderBuilder setItems(List<OrderItem> items) {
			this.items = items;
			return this;
		}

		public Order build() {
			return new Order(id, user, items);
		}
	}
}

