
package com.demo.rabbitmq;


import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 发布订阅/广播模式
 * 
 */
@Configuration
public class MQFanoutConfig {
	
	/**
	 * 
	 * Fanout 不处理路由键 只要与之绑定的队列都能收到消息
	 *
	 * @return
	 */
    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange(MQConstants.HELLO_FANOUT_EXCHANGE);
    }
}
