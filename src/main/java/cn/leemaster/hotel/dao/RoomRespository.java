package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
public interface RoomRespository extends JpaRepository<Room,Integer> {

    @Query("SELECT r FROM Room r WHERE r.roomStatus = 'Y'")
    public List<Room> findRoomAviable();
}
