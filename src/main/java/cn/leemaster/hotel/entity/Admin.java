package cn.leemaster.hotel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@Table(name = "ht_admin")
@TableGenerator(
        name = "admin_gen",
        table = "ht_keys",
        pkColumnName = "key_name",
        valueColumnName = "key_val",
        pkColumnValue = "HOTEL_ADMIN_ID",
        allocationSize = 1,
        initialValue = (1 << 29) + (1 << 10)
)
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "admin_gen")
    @Column(name = "admin_id")
    private Integer adminId;

    @NotNull
    @Column(name = "admin_password")
    private String adminPassword;

    @NotNull
    @Column(name = "admin_tip")
    private String adminTips = "员工";

    @NotNull
    @Column(name = "admin_role")
    private Character adminRole = 'Y';

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminTips() {
        return adminTips;
    }

    public void setAdminTips(String adminTips) {
        this.adminTips = adminTips;
    }

    public Character getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Character adminRole) {
        this.adminRole = adminRole;
    }
}
