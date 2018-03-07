package cn.leemaster.hotel.service.impl;

import cn.leemaster.hotel.dao.UserRespository;
import cn.leemaster.hotel.entity.User;
import cn.leemaster.hotel.service.UserService;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-5
 * @Package cn.leemaster.hotel.service.impl
 * @Describtion
 * @since v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public User getUserById(Integer id) {
        return userRespository.findOne(id);
    }

    @Override
    public int updateUser(User user) {
        return userRespository.updateUser(user.getUserId(),user.getUserName(),user.getUserPhone());
    }

    @Override
    public int updatePassword(Integer userId, String oldPass, String newPass) {
        return userRespository.updatePassword(userId,oldPass,newPass);
    }

    @Override
    public User saveUser(User user) {
        return userRespository.save(user);
    }

    @Override
    public boolean checkUser(String userName, String userPass) {
        User user = userRespository.findUserByName(userName);

        if (user == null) return  false;

        if (user.getUserPassword().equals(userPass)) return true;

        else return false;
    }


}
