package center.raccoon.oauth2.project.controller;

import center.raccoon.oauth2.project.service.OnlineService;
import center.raccoon.result.RaccoonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 歪鼻子
 * @Date 2020/7/7 15:12
 * @Description: 在线人数管理
 * @Version 1.0
 */
@RestController
public class OnLineController {
    @Autowired
    private OnlineService onlineService;

    @DeleteMapping("/kickOut")
    public RaccoonResult kickOut(String userName){
        System.out.println(userName);
        onlineService.kickOut(userName);
        return RaccoonResult.success("下线成功");
    }
}
