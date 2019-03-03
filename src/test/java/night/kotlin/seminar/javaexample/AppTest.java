package night.kotlin.seminar.javaexample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTest {

	@Test
	public void 자바는_한글_가능은_하지만_띄어쓰기_안됨() {
		System.out.println("아쉽지만 한글 메소드 이름은 어거지로 되긴 합니다");
	}

	@Test
	@DisplayName("JUnit 5 부터는 이렇게도 가능은 합니다")
	public void test_english() {
		System.out.println("그러나 코틀린보다는 장황하네요");
	}
}
