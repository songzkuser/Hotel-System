package cn.leemaster.hotel.dao;

import cn.leemaster.hotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-5
 * @Package cn.leemaster.hotel.dao
 * @Describtion
 * @since v1.0
 */
public interface UserRespository extends JpaRepository<User,Integer> {

    @Modifying(clearAutomatically = true)
    @Query("update User u set  u.userName = :userName , u.userPhone = :userPhone where u.userId = :userId")
    public int updateUser(@Param("userId")Integer userId,
                          @Param("userName") String userName,
                          @Param("userPhone")String userPhone);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.userPassword = :newPass where u.userId = :userId and u.userPassword = :oldPass")
    public int updatePassword(@Param("userId") Integer userId,
                              @Param("oldPass") String oldPass,
                              @Param("newPass") String newPass);

    @Query("select u from User u where u.userName = :userName")
    public User findUserByName(@Param("userName") String userName);
}
