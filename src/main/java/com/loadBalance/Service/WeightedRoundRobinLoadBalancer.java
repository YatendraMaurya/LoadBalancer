package com.loadBalance.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeightedRoundRobinLoadBalancer extends LoadBalancerService{
    private static Integer pos = 0;
    @Override
    public String getServer(String clientIp) {
        Set<String> servers = serverDB.keySet();
        List<String> serverList = new ArrayList<>();
        for (String s : servers) {
            int weight = serverDB.get(s).getWeight();
            while (weight > 0) {
                serverList.add(s);
                weight--;
            }
        }
        if (pos > serverList.size() - 1)
            pos = 0;

        return serverList.get(pos++);
    }
}
