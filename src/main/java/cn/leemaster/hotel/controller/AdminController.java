package cn.leemaster.hotel.controller;

import cn.leemaster.hotel.ResponseModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    /**
     * 管理员登录控制器
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel login(){
        return null;
    }

    /**
     * 增加管理员控制器
     * @return
     */
    @RequestMapping("add")
    public ResponseModel addManage(){

        return null;
    }

    /**
     * 查询入住房间控制器
     * @return
     */
    @RequestMapping("room/in")
    public ResponseModel findAllinRoom(){

        return null;
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
     * 按照类型查找房间
     * @return
     */
    @RequestMapping("room/type/{typeId}")
    public ResponseModel findAllTypeRoom(){

        return null;
    }

    /**
     * 新增房间信息
     * @return
     */
    @RequestMapping(value = "room",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel addNewRoom(){

        return null;
    }

    /**
     * 删除房间信息
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
     * 办理房间入住信息
     * @return
     */
    @RequestMapping(value = "room/enter",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel enterRoom(){

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
