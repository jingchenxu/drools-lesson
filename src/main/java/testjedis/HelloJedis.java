package testjedis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author semantic
 * @description 不喜欢写配置文件，用代码来测试下java使用redis
 */
public class HelloJedis {

    private Jedis jedis;

    @Before
    public void setup() {
        //开始连接redis数据库
        jedis = new Jedis("192.168.178.138",6379);
        //登录
        jedis.auth("xu560464");
    }

    @Test
    public void testString() {
        //添加数据
        jedis.set("name","jingchenxu");
        System.out.println("看看我的名字是什么"+jedis.get("name"));
    }
}
