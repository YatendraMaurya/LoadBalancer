package com.loadBalance.Model;

public class ServerInstance {
    int id;
    String ip;
    int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ServerInstance(int id, String ip, int weight) {
        this.id = id;
        this.ip = ip;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
