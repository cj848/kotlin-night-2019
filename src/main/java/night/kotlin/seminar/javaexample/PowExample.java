package night.kotlin.seminar.javaexample;

import java.util.List;
import java.util.stream.StreamSupport;

public class PowExample {
	public static void main(String[] args) {
		StreamSupport
			.stream(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).spliterator(), false)
			.map(it -> it * it)
			.forEach(System.out::println);

	}
}
