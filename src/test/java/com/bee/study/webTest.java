package com.bee.study;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by liangbe on 2017/4/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class webTest {

    @Test
    public void exampleTest() {
        String body = "Hello World";
        assertThat(body).isEqualTo("Hello World");
    }
}
