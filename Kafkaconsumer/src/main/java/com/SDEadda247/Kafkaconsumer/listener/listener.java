package com.SDEadda247.Kafkaconsumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.SDEadda247.Kafkaconsumer.repo.repo;
import com.SDEadda247.Kafkaconsumer.user.user;

@Service
public class listener {
	
	@Autowired
	private repo productRepo;
    
    @KafkaListener(topics="kafkaproducer",groupId ="group_id")
    public void consume(String msg)
    {
        System.out.println("Message: "+msg);
    }
    
    
    @KafkaListener(topics="kafkaproducerjson",groupId ="group_json",containerFactory = "userKafkaListenerContainerFactory")
    public void consume(user msg)
    {
    	productRepo.save(msg);
        System.out.println("Message: "+msg);
    }
    

}
