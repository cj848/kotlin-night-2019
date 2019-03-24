package night.kotlin.seminar.javaexample.entity.lombok;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderItem {
	private Long id;
	private String name;
	private Long amount;
}
