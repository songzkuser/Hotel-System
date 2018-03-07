package cn.leemaster.hotel.service.impl;

import cn.leemaster.hotel.dao.TypeRespository;
import cn.leemaster.hotel.entity.RoomType;
import cn.leemaster.hotel.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.service.impl
 * @Describtion
 * @since v1.0
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRespository typeRespository;

    @Override
    public List<RoomType> findAll() {
        return typeRespository.findAll();
    }
}
