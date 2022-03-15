package LoadBalancerServiceTest;

import com.loadBalance.Exception.LoadBalancerOverLoadedException;
import com.loadBalance.Model.ServerInstance;
import com.loadBalance.Service.LoadBalancerService;
import com.loadBalance.Service.RoundRobinLoadBalancer;
import org.junit.jupiter.api.Test;

import static com.loadBalance.Service.LoadBalancerService.serverDB;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoadBalancerServiceTest {

    @Test
    public void shouldRegisterSeverInstance() throws LoadBalancerOverLoadedException {
        LoadBalancerService loadBalancerService = new RoundRobinLoadBalancer();
        loadBalancerService.registerServer(new ServerInstance(1, "192.1.1.1", 1));
        assert(serverDB.containsKey("192.1.1.1"));
    }

    @Test
    public void shouldThrowOverLoadedException() throws LoadBalancerOverLoadedException {
        LoadBalancerService loadBalancerService = new RoundRobinLoadBalancer();
        for(int i = 0; i< 10; i++){
            StringBuilder ip = new StringBuilder("192.19.12.");
            ip.append(i);
            loadBalancerService.registerServer(new ServerInstance(1, ip.toString(), 1));
        }
        assertThrows (LoadBalancerOverLoadedException.class, () -> loadBalancerService.registerServer(new ServerInstance(1, "192.1.1.32", 1)));
    }
}
