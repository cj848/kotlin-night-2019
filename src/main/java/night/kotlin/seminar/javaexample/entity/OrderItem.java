package night.kotlin.seminar.javaexample.entity;

public class OrderItem {
	private Long id;
	private String name;
	private Long amount;

	public OrderItem() {}

	public OrderItem(Long id, String name, Long amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public static OrderItemBuilder builder() {
		return new OrderItemBuilder();
	}

	public static class OrderItemBuilder {
		private Long id;
		private String name;
		private Long amount;

		public OrderItemBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public OrderItemBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public OrderItemBuilder setAmount(Long amount) {
			this.amount = amount;
			return this;
		}

		public OrderItem build() {
			return new OrderItem(id, name, amount);
		}
	}
}
