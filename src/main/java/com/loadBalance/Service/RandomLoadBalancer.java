package com.loadBalance.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomLoadBalancer extends LoadBalancerService {
    @Override
    public String getServer(String clientIp) {
        Set<String> servers = serverDB.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        int random = new Random().nextInt(serverList.size());
        return serverList.get(random);
    }
}
