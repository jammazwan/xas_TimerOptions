package jammazwan.xas;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XasTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testRunOnceOnly() throws Exception {
		MockEndpoint mock1 = getMockEndpoint("mock:assert1");
		mock1.expectedMessageCount(1);
		mock1.setAssertPeriod(1000);
		mock1.assertIsSatisfied();
	}

	@Test
	public void testRunEveryThreeSeconds() throws Exception {
		MockEndpoint mock2 = getMockEndpoint("mock:assert2");
		mock2.expectedMessageCount(9);
		mock2.setAssertPeriod(4000);
		mock2.assertIsSatisfied();
	}

	@Test
	public void testWait10Seconds() throws Exception {
		MockEndpoint mock3 = getMockEndpoint("mock:assert3");
		mock3.expectedMessageCount(1);
		mock3.assertIsSatisfied();
	}

}
