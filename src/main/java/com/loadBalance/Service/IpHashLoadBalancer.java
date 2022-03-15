package com.loadBalance.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IpHashLoadBalancer extends LoadBalancerService{
    @Override
    public String getServer(String clientIP) {
        if (clientIP == null) {
            clientIP = "127.0.0.1";
        }
        Set<String> servers = serverDB.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        int index = clientIP.hashCode() % serverList.size();
        if (index < 0)
            index*=-1;
        return serverList.get(index);
    }
}
