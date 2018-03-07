package cn.leemaster.hotel.service;

import cn.leemaster.hotel.entity.User;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-5
 * @Package cn.leemaster.hotel.service
 * @Describtion
 * @since v1.0
 */
public interface UserService {

    public User getUserById(Integer id);

    public int updateUser(User user);

    public int updatePassword(Integer userId,String oldPass,String newPass);

    public User saveUser(User user);

    public boolean checkUser(String userName,String userPass);
}
