package cn.leemaster.hotel.service.impl;

import cn.leemaster.hotel.dao.*;
import cn.leemaster.hotel.entity.Room;
import cn.leemaster.hotel.entity.RoomConsumer;
import cn.leemaster.hotel.entity.RoomStatus;
import cn.leemaster.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private StatusRespository statusRespository;

    @Autowired
    private ConsumerRespository consumerRespository;

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private OrderRespository orderRespository;

    @Override
    public List<Room> findRoomsAvialable() {
        return roomRespository.findRoomAviable();
    }

    /**
     * JPA 默认是选择数据库的链接进行操作的
     * 那么 级连的时候需要进行自己的映射
     * 没有 外键 的时候 就要自己维护关系
     * @param roomId
     * @param consumers
     * @return
     */
    @Override
    @Transactional
    public boolean roomIn(Integer roomId, List<RoomConsumer> consumers) {

        System.out.println(consumers.size());

        Room room = new Room();

        room.setRoomId(roomId);

        RoomStatus status = new RoomStatus();

        status.setStatusRoom(room);

        status.setRoomConsumers(consumers);

        try {
            roomRespository.modifyRoomStatus(roomId,'N');

            RoomStatus roomStatus = statusRespository.save(status);


            for (RoomConsumer consumer : consumers){

                consumer.setConsumerStatus(roomStatus);
            }

            consumerRespository.save(consumers);

            return true;

        }catch (Exception e){

            e.printStackTrace();

            return false;

        }
    }
}
