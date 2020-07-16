package center.raccoon.oauth2.project.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author xiaoxiong
 * @Date2020/5/27 20:21
 * @Description:权限实体类
 * @Version 1.0
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 权限ID
     */
    private Integer permissionId;
    /**
     * 权限类型
     */
    private String permissionType;
    /**
     * 权限名字
     */
    private String permissionName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人编号
     */
    private String createUser;
    /**
     * 更新人编号
     */
    private String updateUser;

}
