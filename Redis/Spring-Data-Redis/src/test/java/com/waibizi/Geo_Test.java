package com.waibizi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 19:04
 * @Description:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Geo_Test {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void SetValue(){
        /* 经纬度 */
        Point point_1 = new Point(116.389,24.377);
        redisTemplate.opsForGeo().add("city:location",
                new RedisGeoCommands.GeoLocation<>("歪鼻子",point_1));
        Point point_2 = new Point(117.389,24.877);
        redisTemplate.opsForGeo().add("city:location",
                new RedisGeoCommands.GeoLocation<>("鲁班",point_1));
    }
    /* 查看附近的人 */
    @Test
    public void near() {
        /* 中心点坐标 */
        Point point = new Point(116,24);
        /* 半径 100米 */
        Distance distance = new Distance(100, RedisGeoCommands.DistanceUnit.METERS);
        Circle circle = new Circle(point, distance);
        /* 附近五个人 */
        RedisGeoCommands.GeoRadiusCommandArgs geoRadiusCommandArgs =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(5);
        GeoResults<RedisGeoCommands.GeoLocation> near =
                redisTemplate.opsForGeo().radius("city:location", circle, geoRadiusCommandArgs);
        System.out.println(near.toString());
    }
}
