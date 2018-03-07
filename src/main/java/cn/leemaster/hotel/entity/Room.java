package cn.leemaster.hotel.entity;

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
@Table(name = "ht_room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @ManyToOne
    @JoinColumn(name = "room_type")
    @NotNull
    private RoomType roomType;

    @Column(name = "room_status")
    private Character roomStatus = 'Y';

    @Column(name = "room_floor")
    private Integer roomFloor = 1;

    @Column(name = "room_num")
    private Integer roomNum ;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Character getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Character roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(Integer roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }
}
