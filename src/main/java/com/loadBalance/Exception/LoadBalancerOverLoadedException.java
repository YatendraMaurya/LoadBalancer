package com.loadBalance.Exception;

public class LoadBalancerOverLoadedException extends Throwable {
    public LoadBalancerOverLoadedException(String message) {
        super(message);
    }
}
