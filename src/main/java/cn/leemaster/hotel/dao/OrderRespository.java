package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.Order;
import cn.leemaster.hotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.dao
 * @Describtion
 * @since v1.0
 */

public interface OrderRespository extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o WHERE o.orderUser.userId=:id")
    public List<Order> findOrderByUserId(@Param("id")Integer userId);

    @Modifying(clearAutomatically = true)
    @Query("update Order o set o.orderStatus = 'Y' where o.orderUser = :userId")
    public int modifyRoomStatus(@Param("userId")Integer userId);


    @Query("select o from Order o where o.orderStatus = :status")
    public List<Order> findAllByOrderStatus(@Param("status")Character status);


    @Query("select  o from Order o where o.orderUser.userId = :userId")
    public List<Order> findAllByOrderUser(@Param("userId") Integer userId);



}
