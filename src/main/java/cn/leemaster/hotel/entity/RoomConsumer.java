package cn.leemaster.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@Table(name = "ht_room_consumer")
public class RoomConsumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "consumer_id")
    private Integer consumerId;

    @Column(name = "consumer_name")
    @NotNull
    private String consumerName;

    @Column(name = "consumer_idcard")
    @NotNull
    private String consumerIdCard;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consumer_status")
    @JsonIgnore
    private RoomStatus consumerStatus;

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerIdCard() {
        return consumerIdCard;
    }

    public void setConsumerIdCard(String consumerIdCard) {
        this.consumerIdCard = consumerIdCard;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public RoomStatus getConsumerStatus() {
        return consumerStatus;
    }

    public void setConsumerStatus(RoomStatus consumerStatus) {
        this.consumerStatus = consumerStatus;
    }
}
