package center.raccoon.oauth2.project.model;

/**
 * @Author 歪鼻子
 * @Date 2020/7/7 1:07
 * @Description:
 * @Version 1.0
 */
public class BaseResponse {

    private String errorcode;

    private String value;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
