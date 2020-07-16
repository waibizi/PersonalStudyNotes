import java.io.UnsupportedEncodingException;

/**
 * @Author 歪鼻子
 * @Date 2020/7/5 21:35
 * @Description:
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String test = "HelloWorld";
        System.out.println(test.getBytes("UTF-8").length);
        System.out.println(test.getBytes("gbk").length);
        System.out.println(test.trim().getBytes("UTF-8").length);
        System.out.println(test.trim().getBytes("GBK").length);

    }
}
