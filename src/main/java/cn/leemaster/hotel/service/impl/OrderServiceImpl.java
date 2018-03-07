package cn.leemaster.hotel.service.impl;

import cn.leemaster.hotel.dao.OrderRespository;
import cn.leemaster.hotel.entity.Order;
import cn.leemaster.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.service.impl
 * @Describtion
 * @since v1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    private OrderRespository orderRespository;

    @Override
    public List<Order> findOrdersByUser(Integer id) {
        return orderRespository.findOrderByUserId(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRespository.save(order);
    }
}
