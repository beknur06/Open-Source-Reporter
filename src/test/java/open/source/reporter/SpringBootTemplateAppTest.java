package open.source.reporter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(initializers = IntegrationTestInitializer.class)
@SpringBootTest
class SpringBootTemplateAppTest {

	@Test
	void contextLoads() {
		// do nothing, this test for just check is context up
	}
}
