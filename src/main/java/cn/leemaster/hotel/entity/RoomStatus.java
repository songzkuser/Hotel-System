package cn.leemaster.hotel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
@Table(name = "ht_room_status")
public class RoomStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "status_room")
    @NotNull
    private Integer statusRoom;

    @Column(name = "status_consumer")
    @NotNull
    private Integer statusConsumer;

    @Column(name = "status_time")
    private Date statusTime;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Integer getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(Integer statusRoom) {
        this.statusRoom = statusRoom;
    }

    public Integer getStatusConsumer() {
        return statusConsumer;
    }

    public void setStatusConsumer(Integer statusConsumer) {
        this.statusConsumer = statusConsumer;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }
}
