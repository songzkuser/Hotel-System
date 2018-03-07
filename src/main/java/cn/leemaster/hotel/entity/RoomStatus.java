package cn.leemaster.hotel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long statusId;

    @ManyToOne
    @JoinColumn(name = "status_room")
    @NotNull
    private Room statusRoom;

    @OneToMany(mappedBy = "consumerStatus")
    private List<RoomConsumer> roomConsumers;

    @Column(name = "status_time")
    private Date statusTime = new Date();

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Room getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(Room statusRoom) {
        this.statusRoom = statusRoom;
    }

    public List<RoomConsumer> getRoomConsumers() {
        return roomConsumers;
    }

    public void setRoomConsumers(List<RoomConsumer> roomConsumers) {
        this.roomConsumers = roomConsumers;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }
}
