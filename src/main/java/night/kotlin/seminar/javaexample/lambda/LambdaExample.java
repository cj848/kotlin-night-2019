package night.kotlin.seminar.javaexample.lambda;

import java.util.function.Function;

public class LambdaExample {

	public Function<Long, Long> createAddFrom(final Long number) {
		return num -> number + num;
	}
}
