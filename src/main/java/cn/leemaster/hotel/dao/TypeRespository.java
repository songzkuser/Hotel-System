package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.RoomType;
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
public interface TypeRespository extends JpaRepository<RoomType,Integer> {

    @Modifying(clearAutomatically = true)
    @Query("update RoomType rt set rt.typeNum = rt.typeNum + 1 where rt.typeId = :typeId")
    public int modifyTypeNum(@Param("typeId")Integer typeId);

    @Modifying(clearAutomatically = true)
    @Query("update RoomType rt set rt.typeNum = rt.typeNum - 1 where rt.typeId = :typeId")
    public int subTypeNum(@Param("typeId")Integer typeId);
}
