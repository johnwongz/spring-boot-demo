package com.demo.service.base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SimpleTest extends AbstractJUnit4SpringContextTests{

}
