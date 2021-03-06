package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.dao
 * @Describtion
 * @since v1.0
 */
public interface AdminRespository extends JpaRepository<Admin,Integer> {
}
