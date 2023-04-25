package com.wztedu.spring.web;

import com.wztedu.spring.service.OrderService;

/**
 * @author xiaotao
 * @version 1.0
 * Servlet 就是 Controller
 */
public class OrderAction {
    private OrderService orderService;

    // getter
    public OrderService getOrderService() {
        return orderService;
    }

    // setter
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
