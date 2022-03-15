package com.loadBalance;

import com.loadBalance.Exception.LoadBalancerOverLoadedException;
import com.loadBalance.Model.ServerInstance;
import com.loadBalance.Service.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            LoadBalancerService roundRobinLoadBalancer = new RoundRobinLoadBalancer();
            LoadBalancerService loadBalancerService = new RandomLoadBalancer();
            LoadBalancerService weightedRoundRobinLoadBalancer = new WeightedRoundRobinLoadBalancer();
            LoadBalancerService ipHashLoadBalancer = new IpHashLoadBalancer();
            registerLoadBalancer(ipHashLoadBalancer, 10);
            runLoadBalancer(roundRobinLoadBalancer, 100);
        } catch (LoadBalancerOverLoadedException e) {
            e.printStackTrace();
        }
    }

    private static void registerLoadBalancer(LoadBalancerService loadBalancer, int numberOfInstance)
            throws LoadBalancerOverLoadedException {
        for (int i = 0; i<numberOfInstance ;i++) {
            StringBuilder ip = new StringBuilder("192.19.12.");
            ip.append(i);
            int weight = new Random().nextInt(3);
            ServerInstance server = new ServerInstance(i, ip.toString(), weight);
            loadBalancer.registerServer(server);
        }
    }

    private static void runLoadBalancer(LoadBalancerService loadBalancer, int numberOfQuery) {
        StringBuilder clientIP = new StringBuilder("192.19.12.");
        for (int i = 0; i<numberOfQuery ;i++) {
            clientIP.append(i);
            String serverId = loadBalancer.getServer(clientIP.toString());
            System.out.println(String.format("[%s] index:%s,%s", loadBalancer.getClass().getSimpleName(), i, serverId));
        }
    }
}
