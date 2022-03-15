package com.loadBalance.Service;

import com.loadBalance.Exception.LoadBalancerOverLoadedException;
import com.loadBalance.Model.ServerInstance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.loadBalance.Constant.MAX_SERVER;

public abstract class LoadBalancerService {

    public abstract String getServer(String clientIp);
    public static Map<String, ServerInstance> serverDB = new ConcurrentHashMap<>();

    public void registerServer(ServerInstance serverInstance) throws LoadBalancerOverLoadedException {
        if (serverDB.size() == MAX_SERVER) {
            throw new LoadBalancerOverLoadedException("Load Balancer maximum limit has reached");
        }
        serverDB.putIfAbsent(serverInstance.getIp(), serverInstance);
    }
}
