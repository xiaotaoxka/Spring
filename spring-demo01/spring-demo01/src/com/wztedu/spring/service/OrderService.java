package com.wztedu.spring.service;

import com.wztedu.spring.dao.OrderDao;

/**
 * @author xiaotao
 * @version 1.0
 * service 类
 */
public class OrderService {

    // OrderDao属性
    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
