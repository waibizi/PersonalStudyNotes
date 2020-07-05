package center.raccoon.status;

/**
 * @Author 吴典秋
 * @Date 2020/5/29 11:38
 * @Description:
 * @Version 1.0
 */

public enum CodeEnum {
    // 成功返回
    SUCCESS(200, "成功"),
    //新建或修改失败
    MODIFY_ERROR(201, "新建或修改失败"),
    //数据删除失败
    DELETE_ERROR(204, "删除失败"),
    // 查询失败
    QUERY_ERROR(205, "查询失败"),
    //请求错误
    ERROR(400, "请求错误"),
    //没有授权
    NOT_AUTHORIZATION(401, "没有授权"),
    //用户名密码错误
    LOGIN_ERROR_USER(402, "用户名密码错误"),
    //锁定的用户
    LOCKED_USER(403, "锁定的用户"),
    //登出失败
    LOGOUT_ERROR(405, "登出失败"),
    // 无权访问
    ACCESS_DENIED(406, "无权访问"),
    //服务器发生错误
    SERVER_ERROR(500, "服务器发送错误");

    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}