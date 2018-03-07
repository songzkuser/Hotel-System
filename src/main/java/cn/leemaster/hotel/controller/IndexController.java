package cn.leemaster.hotel.controller;

import cn.leemaster.hotel.ResponseModel;
import cn.leemaster.hotel.dao.RoomRespository;
import cn.leemaster.hotel.entity.Order;
import cn.leemaster.hotel.entity.RoomType;
import cn.leemaster.hotel.entity.User;
import cn.leemaster.hotel.service.OrderService;
import cn.leemaster.hotel.service.RoomService;
import cn.leemaster.hotel.service.TypeService;
import cn.leemaster.hotel.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.controller
 * @Describtion
 * @since v1.0
 */
@RestController
@CrossOrigin(value = "*")
@RequestMapping("/")
public class IndexController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private TypeService typeService;

    /**
     * 用户首页
     * 列出当前可用的各种房间信息 在用户要进行预订的时候检查状态
     * 如果没有当前的 token 存储的话 那么就直接失败 提示用户登录 跳转到登录页面
     * @return
     */
    @RequestMapping("")
    public ResponseModel index(){
        ResponseModel model = new ResponseModel();
        model.setResponseData(new HashMap<>());
        model.setResponseCode(200);
        model.setResponseStatus("请求成功");
        return model;
    }

    /**
     * 登录控制器 完成
     * {
     *     userName : "",
     *     userPass : ""
     * }
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel login(@RequestBody JSONObject object){

        String userName = object.getString("userName");

        String userPass = object.getString("userPass");

        Boolean isRight = userService.checkUser(userName,userPass);

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        Map<String,Object> map = new HashMap<>();

        map.put("isRight" , isRight);
        map.put("token",isRight ? "TOKEN" : null);

        model.setResponseData(map);

        return  model;
    }

    /**
     * 退出登录控制器 前端控制就好了
     * 直接删除 Token 就好了
     * @return
     */
    @RequestMapping("logout")
    public ResponseModel logout(){

        return null;
    }

    /**
     * 用户注册控制器 完成
     * {
     *     userName : "",
     *     userPhone : "",
     *     userPass : ""
     * }
     * TODO 这里需要加上一个 TOKEN 字段 token 字段随便填写 没有 安全问题
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel register(@RequestBody JSONObject object){
        User user = new User();

        String userName = object.getString("userName");

        String userPass = object.getString("userPass");

        String userPhone = object.getString("userPhone");

        user.setUserName(userName);

        user.setUserPassword(userPass);

        user.setUserPhone(userPhone);

        userService.saveUser(user);

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        Map<String,Object> map = new HashMap<>();

        map.put("status",1);

        model.setResponseData(map);

        return model;
    }

    /**
     * 修改密码控制器 完成
     * {
     *     userId : 1073741825
     *     userNew : "",
     *     userOld : ""
     * }
     * @return
     */
    @RequestMapping(value = "pass",method = RequestMethod.PUT,consumes = "application/json")
    public ResponseModel changePassword(@RequestBody JSONObject object){

        Integer userId = object.getInteger("userId");
        String userNew = object.getString("userNew");
        String userOld = object.getString("userOld");

        userService.updatePassword(userId,userOld,userNew);

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        Map<String,Object> map = new HashMap<>();

        map.put("status",1);

        model.setResponseData(map);

        return model;
    }

    /**
     * 修改用户信息控制器 完成
     * {
     *     userId : Integer,
     *     userName : String,
     *     userPhone : String,
     *     userPassword : String,
     *     userRegister : String
     * }
     * @return
     */
    @RequestMapping(value = "modify",method = RequestMethod.PUT,consumes = "application/json")
    public ResponseModel modify(@RequestBody User user){

        userService.updateUser(user);

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        Map<String,Object> map = new HashMap<>();

        map.put("status",1);

        model.setResponseData(map);

        return model;
    }

    /**
     * 列出宾馆房间信息控制器 完成
     * 按照每一个房间类型来进行查询 并且通知用户
     * @return
     */
    @RequestMapping("room")
    public ResponseModel listRoom(){
        ResponseModel model = new ResponseModel();

        Map<String,Object> map = new HashMap<>();

        map.put("rooms",typeService.findAll());

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        model.setResponseData(map);

        return model;
    }

    /**
     * 查询用户订单控制器 完成
     *
     * @return
     */
    @RequestMapping(value = "order/{id}",method = RequestMethod.GET)
    public ResponseModel listOrder(@PathVariable("id") Integer userId){

        Map<String,Object> map = new HashMap<>();

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        map.put("orders",orderService.findOrdersByUser(userId));

        model.setResponseData(map);

        return model;
    }

    /**
     * 查询用户信息控制器 完成
     * 返回用户信息 密码完成了隐藏策略
     * @return
     */
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public ResponseModel getUser(@PathVariable("id") Integer userId){
        ResponseModel model = new ResponseModel();

        Map<String,Object> map = new HashMap<>();

        map.put("user",userService.getUserById(userId));

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        model.setResponseData(map);

        return model;
    }

    /**
     * 预订房间控制器 完成
     * {
     *     userId : 1073741825,
     *     roomType : 1
     * }
     * @return
     */
    @RequestMapping(value = "orderroom",method = RequestMethod.POST,consumes = "application/json")
    public ResponseModel orderRoom(@RequestBody JSONObject object){

        Order order = new Order();

        User user = new User();

        RoomType type = new RoomType();

        user.setUserId(object.getInteger("userId"));

        type.setTypeId(object.getInteger("roomType"));

        order.setOrderUser(user);

        order.setOrderType(type);

        orderService.saveOrder(order);

        ResponseModel model = new ResponseModel();

        model.setResponseCode(200);

        model.setResponseStatus("请求成功");

        model.setResponseData(null);

        return model;
    }



}
