package com.wztedu.spring.proxy2;

import org.junit.jupiter.api.Test;

public class TestVehicle {


    @Test
    public void Run() {
        Vehicle vehicle = new Ship();
        vehicle.run();
    }

    @Test
    public void proxyRun() {
        Vehicle vehicle = new Ship();

        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(vehicle);

        // 获取代理对象, 该对象可以代理执行方法
        // 1. proxy 编译类型 Vehicle
        // 2. 运行类型是代理类型
        Vehicle proxy = vehicleProxyProvider.getProxy();

        // proxy.run();

        String result = proxy.fly(1000);
        System.out.println("result= " + result);
    }

}
