package redis;

import com.boot.KerwinBootsApplication;
import com.boot.util.RedisQueue;
import com.boot.util.RedisStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/19 23:35
 * description:  Redis 课后作业 用redis实现栈和队列
 * version:      V1.0
 * ******************************
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KerwinBootsApplication.class)
public class App {

    @Resource
    RedisStack redisStack;

    @Resource
    RedisQueue redisQueue;

    @Test
    public void stack () {
        redisStack.push("1");
        redisStack.push("2");
        redisStack.push("3");
        System.out.println(redisStack.pop());
        System.out.println(redisStack.pop());
        System.out.println(redisStack.pop());
    }

    @Test
    public void queue () {
        redisQueue.push("1");
        redisQueue.push("2");
        redisQueue.push("3");
        System.out.println(redisQueue.pop());
        System.out.println(redisQueue.pop());
        System.out.println(redisQueue.pop());
    }
}
