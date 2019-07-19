package com.forezp.demo;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitProdeucer {
    public static void  main(String[] args){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("localhost");
//        connectionFactory.setPort("");
        try {
            //链接
            Connection connection = connectionFactory.newConnection();
            //信道
            Channel channel = connection.createChannel();
            //声明交换器
            String exchangeName = "hello-exchange";
            channel.exchangeDeclare(exchangeName,"direct",true);

            String routingKey = "hola";
            //发布消息
            byte [] message = "quit".getBytes();
            channel.basicPublish(exchangeName,routingKey,null,message);

            channel.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
