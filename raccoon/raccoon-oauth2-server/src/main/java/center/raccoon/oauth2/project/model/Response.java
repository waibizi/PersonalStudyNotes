package center.raccoon.oauth2.project.model;

import center.raccoon.oauth2.framework.aspect.ResponseSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @Author 歪鼻子
 * @Date 2020/7/7 1:05
 * @Description:
 * @Version 1.0
 */
@JsonSerialize(using = ResponseSerializer.class)
@Data
public class Response extends BaseResponse{
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public void rmData(){
        this.data = "";
    }
}
