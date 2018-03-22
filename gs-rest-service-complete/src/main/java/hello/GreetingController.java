package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import com.google.gson.JsonArray;
 

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/admin")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/api/machine")
    public void itemPurchased(@RequestParam("machineid") String machineId, @RequestParam("productid") String productId) {
    		Map<String, Machine> machineDb = Machine.machineDb;
    		Machine machine = machineDb.get(machineId);
    		
    		if (machine instanceof DrinkMachine) {
    			machine = (DrinkMachine) machine;
    			//Set machine total;
    		} else {
    			machine = (SnackMachine) machine;
    		}
    		
    		
    }
    
    
}
