package night.kotlin.seminar.javaexample.entity.lombok;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Order {
	private Long id;
	private User user;
	private List<OrderItem> items;

	public Long getAmount() {
		return items.stream()
			.map(OrderItem::getAmount)
			.reduce(Long::sum)
			.orElse(0L);
	}
}
