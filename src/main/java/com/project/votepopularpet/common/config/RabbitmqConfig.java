package com.project.votepopularpet.common.config;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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

  @Bean
  Queue queue() {
    return new Queue("hello.queue", false);
  }

  @Bean
  DirectExchange exchange() {
    return new DirectExchange("hello.exchange");
  }

  @Bean
   Binding binding() {
    return BindingBuilder.bind(queue()).to(exchange()).with("hello.key");
  }

//  @Bean
//  RabbitTemplate rabbitTemplate() {
//    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
//    rabbitTemplate.setMessageConverter(jsonMessageConverter());
//    rabbitTemplate.setRoutingKey("hello.key");
//    return rabbitTemplate;
//  }
//
//  @Bean
//  public SimpleMessageListenerContainer container() {
//    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//    container.setConnectionFactory(connectionFactory());
//    return container;
//  }
//
  @Bean
  ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setHost(host);
    connectionFactory.setPort(port);
    connectionFactory.setUsername(username);
    connectionFactory.setPassword(password);
    return connectionFactory;
  }
//
//  public Jackson2JsonMessageConverter jsonMessageConverter() {
//
//    return new Jackson2JsonMessageConverter();
//  }
//
//  @Bean
//  public Module dateTimeModule() {
//    return new JavaTimeModule();
//  }
//
//  @Bean
//  SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//    final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//    factory.setConnectionFactory(connectionFactory);
//    factory.setMessageConverter(jsonMessageConverter());
//    return factory;
//  }
@Bean
public RabbitTemplate rabbitTemplate() {
  RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
  rabbitTemplate.setMessageConverter(jsonMessageConverter());
  return rabbitTemplate;
}

  @Bean
  public Jackson2JsonMessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
