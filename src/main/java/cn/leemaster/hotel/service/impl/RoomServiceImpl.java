package cn.leemaster.hotel.service.impl;

import cn.leemaster.hotel.dao.RoomRespository;
import cn.leemaster.hotel.entity.Room;
import cn.leemaster.hotel.service.RoomService;
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
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRespository roomRespository;

    @Override
    public List<Room> findRoomsAvialable() {
        return roomRespository.findRoomAviable();
    }
}
