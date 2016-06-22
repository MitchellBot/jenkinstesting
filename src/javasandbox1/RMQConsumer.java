/*
 * Copyright (C) 2016 Yaakov.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package javasandbox1;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;

/**
 *
 * @author Yaakov
 */
class RMQConsumer implements IRMQConsumer {
    
    private String message = "";

    /**
     *  Returns the message at the top of the queue without acknowledging it
     * @return 
     */
    @SuppressWarnings("override")
    public String getMessage()
    {
        Consumer consumer;
        consumer = new DefaultConsumer(RMQConnection.channel)
        {          
            @Override
          public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
              throws IOException 
          {
            message = new String(body, "UTF-8");
          }
        };
        
        if(message == null)
        {
            message = "err: getmessage returned null";
        }
        
        return message;
    } 
    
    /**
     *  Returns and acknowledges the message at the top of the queue
     * @return
     */
    @SuppressWarnings("override")
    public String ackMessage()
    {
        Consumer consumer;
        consumer = new DefaultConsumer(RMQConnection.channel)
        {          
            @Override
          public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
              throws IOException 
            {
                try
                {
                    message = new String(body, "UTF-8");
                }
                finally
                {
                    RMQConnection.channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        if(message == null)
        {
            message = "err: getmessage returned null";
        }
        
        return message;
    }
    
}

