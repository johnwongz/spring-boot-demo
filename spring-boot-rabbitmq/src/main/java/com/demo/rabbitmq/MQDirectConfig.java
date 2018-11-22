
package com.demo.rabbitmq;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 点对点模式
 * 
 */
@Configuration
public class MQDirectConfig {

	@Bean
	public Queue helloQueue() { 
		return new Queue(MQConstants.HELLO_QUEUE, true);
	}
}
