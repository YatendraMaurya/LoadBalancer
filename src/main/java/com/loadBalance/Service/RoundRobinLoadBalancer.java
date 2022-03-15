package com.loadBalance.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class RoundRobinLoadBalancer extends LoadBalancerService {
    public static Integer pos = 0;
    @Override
    public String getServer(String clientIp) {
        Set<String> servers = serverDB.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        Collections.sort(serverList);
        String targetServer = null;

        synchronized (pos) {
            if (pos > serverList.size() - 1) {
                pos = 0;
            }
            targetServer = serverList.get(pos);
            pos++;
        }

        return targetServer;
    }
}
