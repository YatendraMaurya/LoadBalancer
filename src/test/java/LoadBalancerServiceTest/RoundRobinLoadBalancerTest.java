package LoadBalancerServiceTest;

import com.loadBalance.Exception.LoadBalancerOverLoadedException;
import com.loadBalance.Model.ServerInstance;
import com.loadBalance.Service.LoadBalancerService;
import com.loadBalance.Service.RoundRobinLoadBalancer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoundRobinLoadBalancerTest {
    @BeforeEach
    public void setup() throws LoadBalancerOverLoadedException {
        LoadBalancerService loadBalancerService = new RoundRobinLoadBalancer();
        for (int i = 0; i < 10; i++) {
            StringBuilder ip = new StringBuilder("192.19.12.");
            ip.append(i);
            loadBalancerService.registerServer(new ServerInstance(1, ip.toString(), 1));
        }
    }
    @Test
    public void shouldReturnServerInRoundRobinManner() {
        LoadBalancerService loadBalancerService = new RoundRobinLoadBalancer();
        //System.out.println(loadBalancerService.getServer("1"));
        assert(loadBalancerService.getServer("1").equals("192.19.12.0"));
        assert(loadBalancerService.getServer("1").equals("192.19.12.1"));

    }
}
