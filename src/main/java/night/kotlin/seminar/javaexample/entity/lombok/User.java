package night.kotlin.seminar.javaexample.entity.lombok;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
	private Long id;
	private String name;
	private String email;
}
