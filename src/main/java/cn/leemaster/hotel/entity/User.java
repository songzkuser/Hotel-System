package cn.leemaster.hotel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-5
 * @Package cn.leemaster.hotel.entity
 * @Describtion
 * @since v1.0
 */
@Entity
@Table(name = "ht_user")
@TableGenerator(
        name = "user_gen",
        table = "ht_keys",
        pkColumnName = "key_name",
        valueColumnName = "key_val",
        pkColumnValue = "HOTEL_USER_ID",
        allocationSize = 1,
        initialValue = 1 << 30
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "user_gen")
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Column(name = "user_phone")
    @NotNull
    private String userPhone;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_register")
    private Date userRegister = new Date();


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(Date userRegister) {
        this.userRegister = userRegister;
    }
}
