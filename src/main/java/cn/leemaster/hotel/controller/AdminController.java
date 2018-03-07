package cn.leemaster.hotel.controller;

import cn.leemaster.hotel.ResponseModel;
import cn.leemaster.hotel.dao.AdminRespository;
import cn.leemaster.hotel.dao.ConsumerRespository;
import cn.leemaster.hotel.dao.RoomRespository;
import cn.leemaster.hotel.dao.StatusRespository;
import cn.leemaster.hotel.entity.Admin;
import cn.leemaster.hotel.entity.Room;
import cn.leemaster.hotel.entity.RoomConsumer;
import cn.leemaster.hotel.entity.RoomType;
import cn.leemaster.hotel.service.RoomService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdminController.java created on 18-3-6
 * @Package cn.leemaster.hotel.controller
 * @Describtion
 * @since v1.0
 */
@RestController
@CrossOrigin(value = "*")
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private AdminRespository adminRespository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private StatusRespository statusRespository;

    @Autowired
    private RoomRespository roomRespository;

    @Autowired
    private ConsumerRespository consumerRespository;

    /**
     * 管理员登录控制器 完成
     * {
     *     userName : "536871937",
     *     userPass : "lxy951119"
     * }
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel login(@RequestBody JSONObject object){

        Integer userName = object.getInteger("userName");

        String userPass = object.getString("userPass");

        Admin admin = adminRespository.findOne(userName);

        ResponseModel model = new ResponseModel();

        Map<String,Object> map = new HashMap<>();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        if (admin.getAdminPassword().equals(userPass))map.put("isRight",true);

        else map.put("isRight",false);

        map.put("super",((admin.getAdminRole().equals(new Character('Y'))) ? true:false));

        model.setResponseData(map);

        return model;
    }

    /**
     * 增加管理员控制器 完成
     * {
     *     adminRole : "Y/N",
     *     adminPass : "lxy951119",
     *     adminTips : "测试管理员"
     * }
     * 返回的是管理员登录 ID 然后就可以了
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel addManage(@RequestBody JSONObject object){

        Character adminRole = object.getString("adminRole").charAt(0);

        String adminPass = object.getString("adminPass");

        String adminTips = object.getString("adminTips");

        Admin admin = new Admin();

        admin.setAdminPassword(adminPass);

        admin.setAdminRole(adminRole);

        admin.setAdminTips(adminTips);

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        Map<String,Object> map = new HashMap<>();

        admin =  adminRespository.save(admin);

        map.put("adminid",admin.getAdminId());

        model.setResponseData(map);

        return model;
    }

    /**
     * 查询入住房间控制器 完成
     * @return
     */
    @RequestMapping(value = "room/in/{roomId}",method = RequestMethod.GET)
    public ResponseModel findAllinRoom(@PathVariable("roomId")Integer roomId){
        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        Map<String,Object> map = new HashMap<>();

        map.put("status",statusRespository.findAllByRoomId(roomId));

        model.setResponseData(map);
        return model;
    }

    /**
     * 查询当前空余客房控制器
     * @return
     */
    @RequestMapping("room/free")
    public ResponseModel findAllFreeRoom(){

        return null;
    }

    /**
     * 按照类型查找房间 完成
     * 房间 状态 为N的时候就需要 切换展示方式了
     * @return
     */
    @RequestMapping("room/type/{typeId}")
    public ResponseModel findAllTypeRoom(@PathVariable("typeId")Integer typeId){

        ResponseModel model = new ResponseModel();

        Map<String,Object> map = new HashMap<>();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        map.put("rooms",roomRespository.findRoomByRoomType(typeId));

        model.setResponseData(map);

        return model;
    }

    /**
     * 新增房间信息 完成
     * {
     *     roomType : "1",
     *     roomFloor : 1,
     *     roomNum ： 101
     * }
     * @return
     */
    @RequestMapping(value = "room",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel addNewRoom(@RequestBody JSONObject object){

        Integer roomType = object.getInteger("roomType");

        Integer roomFloor = object.getInteger("roomFloor");

        Integer roomNum = object.getInteger("roomNum");

        Room room = new Room();

        RoomType type = new RoomType();

        type.setTypeId(roomType);

        room.setRoomFloor(roomFloor);

        room.setRoomNum(roomNum);

        room.setRoomType(type);

        roomRespository.save(room);

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        Map<String,Object> map = new HashMap<>();

        map.put("roomNum",roomNum);

        model.setResponseData(map);

        return model;
    }

    /**
     * 更新房间信息
     * @return
     */
    @RequestMapping(value = "room/{roomId}",method = RequestMethod.PUT)
    public ResponseModel updateRoom(){

        return null;
    }

    /**
     * 修改房间信息
     * @return
     */
    @RequestMapping(value = "room/{roomId}",method = RequestMethod.DELETE)
    public ResponseModel deleteRoom(){

        return null;
    }

    /**
     * 办理房间入住信息 完成
     *  {
     *     roomId : "302",
     *     roomConsumers : [
     *      {
     *          consumerName : "leemaster",
     *          consumerIdCard : "130982199411199378",
     *      },
     *      {
     *          consumerName : "leemaster",
     *          consumerIdCard : "130982199411199378",
     *      }
     *     ]
     * }
     * @return
     */
    @RequestMapping(value = "room/enter",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel enterRoom(@RequestBody JSONObject object){

        Integer roomId = object.getInteger("roomId");

        List<JSONObject> consumerList = object.getObject("roomConsumers",List.class);

        List<RoomConsumer> consumers = new ArrayList<>();

        for(Map item : consumerList){
            RoomConsumer roomConsumer = new RoomConsumer();

            roomConsumer.setConsumerIdCard((String)item.get("consumerIdCard"));

            roomConsumer.setConsumerName((String)item.get("consumerName"));

            consumers.add(roomConsumer);
        }

        roomService.roomIn(roomId,consumers);

        Map<String,Object> map = new HashMap<>();

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        //map.put("status",statusRespository.findAll());

        //map.put("consumer",consumerRespository.findAll());

        model.setResponseData(map);

        return model;
    }

    /**
     * 办理退房手续
     * @return
     */
    @RequestMapping(value = "room/quit/{roomId}",method = RequestMethod.DELETE)
    public ResponseModel quitRoom(){

        return null;
    }

    /**
     * 查询当前未消费订单
     * @return
     */
    @RequestMapping("order")
    public ResponseModel findAllOrders(){

        return null;
    }

    /**
     * 查询当前已经消费订单
     * @return
     */
    @RequestMapping("order/consume")
    public ResponseModel findAllConsumeOrders(){

        return null;
    }

    /**
     * 取消订单
     * @return
     */
    @RequestMapping("order/cancel/{orderId}")
    public ResponseModel cancelOrder(){

        return null;
    }

    /**
     * 按照用户帐号查询用户信息
     * @return
     */
    @RequestMapping("user/{userId}")
    public ResponseModel findUserById(){

        return null;
    }


}
