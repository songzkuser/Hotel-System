package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
public interface StatusRespository extends JpaRepository<RoomStatus,Long> {

    @Modifying(clearAutomatically = true)
    @Query("delete from RoomStatus rs where rs.statusRoom = :roomId")
    public int deleteAllByRoomId(@Param("roomId") Integer roomId);


    @Query("select rs from RoomStatus rs where rs.statusRoom.roomId = :roomId")
    public List<RoomStatus> findAllByRoomId(@Param("roomId") Integer roomId);
}
