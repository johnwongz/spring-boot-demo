
package com.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rabbitmq.MQConstants;

@RestController
public class SenderController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/direct")
	public String direct(String message) {
		System.err.println("发送direct消息: " + message);
		rabbitTemplate.convertAndSend(MQConstants.HELLO_QUEUE, message);
		return "success";
	}
	
	@GetMapping("/fanout")
	public String fanout(String message) {
		System.err.println("发送fanout消息: " + message);
		rabbitTemplate.convertAndSend(MQConstants.HELLO_FANOUT_EXCHANGE, null, message);
		return "success";
	}
	
	
	/**
	 * topic 和 direct 类似, 在routing_key形式中, 可以使用通配符:
	 *  *表示一个词.
	 *  #表示零个或多个词
	 */

	@GetMapping("/topic")
	public String topic(String message) {
		System.err.println("发送topic消息: " + message);
		rabbitTemplate.convertAndSend(MQConstants.HELLO_TOPIC_EXCHANGE, "topic.cn.news", "topic.cn.news-" + message);
		rabbitTemplate.convertAndSend(MQConstants.HELLO_TOPIC_EXCHANGE, "topic.hk.news", "topic.hk.news-" + message);
		rabbitTemplate.convertAndSend(MQConstants.HELLO_TOPIC_EXCHANGE, "topic.cn.sports", "topic.cn.sports-" + message);
		rabbitTemplate.convertAndSend(MQConstants.HELLO_TOPIC_EXCHANGE, "topic.hk.sports", "topic.hk.sports-" + message);
		return "success";
	}
}
