package night.kotlin.seminar.javaexample.lambda;

import static org.assertj.core.api.Java6Assertions.*;

import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.LongFunction;

import org.junit.jupiter.api.Test;

class LambdaExampleTest {

	@Test
	public void testHighOrderFunction() {
		LambdaExample exam = new LambdaExample();

		Function<Long, Long> addFunction = exam.createAddFrom(5L);
		assertThat(addFunction.apply(10L)).isEqualTo(15L);
		assertThat(addFunction.apply(20L)).isEqualTo(25L);
	}

	@Test
	public void 자바는_함수대신_Function과_같은_타입으로_함수를_담을수_있다() {
		LongFunction function = (num) -> num + 4L;
		LongFunction function과동일 = new LongFunction() {
			@Override
			public Object apply(long value) {
				return value + 4L;
			}
		};

		System.out.println(function.getClass());
		System.out.println(function과동일.getClass());

		assertThat(function.apply(1L)).isEqualTo(5L);
		assertThat(function과동일.apply(1L)).isEqualTo(5L);
	}
}