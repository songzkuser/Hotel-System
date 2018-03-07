package cn.leemaster.hotel.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-5
 * @Package cn.leemaster.hotel.entity
 * @Describtion
 * @since v1.0
 */
@Entity
@Table(name = "ht_order")
@TableGenerator(
        name = "order_gen",
        table = "ht_keys",
        pkColumnName = "key_name",
        valueColumnName = "key_val",
        pkColumnValue = "HOTEL_ORDER_ID",
        allocationSize = 1,
        initialValue = 1 << 30
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "order_gen")
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_time")
    private Date orderTime = new Date();

    @ManyToOne
    @JoinColumn(name = "order_user")
    private User orderUser;

    @Column(name = "order_status")
    private Character orderStatus = 'N';

    @ManyToOne
    @JoinColumn(name = "order_type")
    private RoomType orderType;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Character getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Character orderStatus) {
        this.orderStatus = orderStatus;
    }

    public RoomType getOrderType() {
        return orderType;
    }

    public void setOrderType(RoomType orderType) {
        this.orderType = orderType;
    }
}
