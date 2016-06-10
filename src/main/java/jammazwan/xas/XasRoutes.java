package jammazwan.xas;

import org.apache.camel.builder.RouteBuilder;


public class XasRoutes extends RouteBuilder {

    
    

    @Override
    public void configure() throws Exception {
    	// Run Once Only
    	from("timer://runOnceOnly?repeatCount=1").to("mock:assert1");
    	
    	// Run Every Three Seconds
    	from("timer://runEveryThreeSeconds?repeatCount=9&fixedRate=3000").log("runEveryThreeSeconds").to("mock:assert2");
    	
    	// Wait 10 Seconds
    	from("timer://wait10Seconds?repeatCount=1&delay=10000").log("wait10Seconds").to("mock:assert3");
    	
    	
    	
    }
}
