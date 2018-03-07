package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.Room;
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
public interface RoomRespository extends JpaRepository<Room,Integer> {

    @Query("SELECT r FROM Room r WHERE r.roomStatus = 'Y'")
    public List<Room> findRoomAviable();


    @Modifying(clearAutomatically = true)
    @Query("update Room r set r.roomStatus = :roomStatus where  r.roomId = :roomId")
    public int modifyRoomStatus(@Param("roomId") Integer roomId,@Param("roomStatus")Character roomStatus);

    @Query("select r from Room r where r.roomType.typeId = :typeId")
    public List<Room> findRoomByRoomType(@Param("typeId") Integer typeId);

}
