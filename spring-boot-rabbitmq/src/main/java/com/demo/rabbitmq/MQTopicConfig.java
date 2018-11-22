
package com.demo.rabbitmq;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Topic交换器
 * 
 */
@Configuration
public class MQTopicConfig {
	
	//创建交换器
    @Bean
    public TopicExchange helloTopicExchange() {
        return new TopicExchange(MQConstants.HELLO_TOPIC_EXCHANGE);
    }
}
