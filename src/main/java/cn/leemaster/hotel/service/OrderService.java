package cn.leemaster.hotel.service;


import cn.leemaster.hotel.entity.Order;

import java.util.List;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.service
 * @Describtion
 * @since v1.0
 */
public interface OrderService {

    public List<Order> findOrdersByUser(Integer id);

    public Order saveOrder(Order order);
}
