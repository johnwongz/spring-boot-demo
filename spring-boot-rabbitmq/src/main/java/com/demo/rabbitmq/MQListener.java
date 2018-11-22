
package com.demo.rabbitmq;


import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQListener {

	/**
	 * 
	 * Direct 消息消费者
	 * 
	 * @param message
	 */
	@RabbitListener(queues = MQConstants.HELLO_QUEUE)
	public void direct(Message message) {
		try {
			String body = new String(message.getBody(), "UTF-8");
			System.err.println("收到direct消息: " + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Fanout消息，消费者A
	 *
	 * @param message
	 */
	@RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "fanout.hello.queue.a", durable = "true"),
            exchange = @Exchange(type=ExchangeTypes.FANOUT, value = MQConstants.HELLO_FANOUT_EXCHANGE))})
	public void fanoutA(Message message) {
		try {
			String body = new String(message.getBody(), "UTF-8");
			System.err.println("A-收到fanout消息: " + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Fanout消息，消费者B
	 *
	 * @param message
	 */
	@RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "fanout.hello.queue.b", durable = "true"),
            exchange = @Exchange(type=ExchangeTypes.FANOUT, value = MQConstants.HELLO_FANOUT_EXCHANGE))})
	public void fanoutB(Message message) {
		try {
			String body = new String(message.getBody(), "UTF-8");
			System.err.println("B-收到fanout消息: " + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Topic消息，topic.cn.#
	 *
	 * @param message
	 */
	@RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "topic.cn.#", durable = "true"),
			exchange = @Exchange(type=ExchangeTypes.TOPIC, value = MQConstants.HELLO_TOPIC_EXCHANGE), key = "topic.cn.#")})
	public void topicCn(Message message) {
		try {
			String body = new String(message.getBody(), "UTF-8");
			System.err.println("Topic消息，topic.cn.#-收到消息: " + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Topic消息，#.news
	 *
	 * @param message
	 */
	@RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "#.news", durable = "true"),
			exchange = @Exchange(type=ExchangeTypes.TOPIC, value = MQConstants.HELLO_TOPIC_EXCHANGE), key = "#.news")})
	public void news(Message message) {
		try {
			String body = new String(message.getBody(), "UTF-8");
			System.err.println("Topic消息，#.news-收到消息: " + body);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
