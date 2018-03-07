package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.RoomConsumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.dao
 * @Describtion
 * @since v1.0
 */
public interface ConsumerRespository extends JpaRepository<RoomConsumer,Integer> {

    @Modifying(clearAutomatically = true)
    @Query("delete from RoomConsumer  rc where  rc.consumerStatus.statusId = :statusId")
    public int deleteByStatusId(@Param("statusId") Long statusId);
}
