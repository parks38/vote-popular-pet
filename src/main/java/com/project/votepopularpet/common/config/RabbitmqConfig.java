package com.project.votepopularpet.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitmqConfig.java
 *
 * @author suna.park
 * @createdDate 2023-07-03.
 */
@Configuration
public class RabbitmqConfig {

  @Value("${spring.rabbitmq.host}")
  private String host;

  @Value("${spring.rabbitmq.username}")
  private String username;

  @Value("${spring.rabbitmq.password}")
  private String password;

  @Value("${spring.rabbitmq.port}")
  private int port;

  /**
   * queue 는 FIFO 모델로 consumer 에게 메세지를 전달합니다.
   * (config. name/durability/exclusive/auto-delete/optional)
   *
   * @return
   */
  @Bean
  Queue queue() {
    return new Queue("hello.queue", false);
  }

  /**
   * producer 는 queue 직접 메세지를 보내지 않고 exchange 를 라우팅 미들웨어로써 사용한다.
   * exchange는 하나 혹은 다수의 큐가 메세지에 들어갈지 혹은 낭비되는 메세지인지 결정을 합니다.
   *
   * @return
   */
  @Bean
  DirectExchange exchange() {
    return new DirectExchange("hello.exchange");
  }

  /**
   * exchange 는 binding 을 이용하여 특정 큐로 메세지를 라우팅 해줍니다.
   *
   * @return
   */
  @Bean
  Binding binding() {
    return BindingBuilder.bind(queue()).to(exchange()).with("hello.key");
  }

  @Bean
  ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setHost(host);
    connectionFactory.setPort(port);
    connectionFactory.setUsername(username);
    connectionFactory.setPassword(password);
    return connectionFactory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate() {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
    rabbitTemplate.setMessageConverter(jsonMessageConverter());
    return rabbitTemplate;
  }

  /**
   * 객체를 JSON 호환
   * @return
   */
  @Bean
  public Jackson2JsonMessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
