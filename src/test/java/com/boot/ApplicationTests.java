package com.boot;

import com.boot.service.CustomStrategyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KerwinBootsApplication.class)
public class ApplicationTests {

    @Autowired
    CustomStrategyFactory factory;

    @Test
    public void testBeanMaps () {
        System.out.println(factory.getInterfaces());
        factory.getInterfaces().get("ALiBaBaImpl").handle();
    }
}
