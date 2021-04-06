package tn.esprit.spring.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Message;
import tn.esprit.spring.repository.MessageRepository;
@Service
public class MessageServiceImpl implements IMessageService {

@Autowired
MessageRepository messageRepository;

private static final Logger l = LoggerFactory.getLogger(MessageServiceImpl.class);

@Override
public List<Message> retrieveAllMessages() {
	// TODO Auto-generated method stub
	List<Message> messages =(List<Message>) messageRepository.findAll();
	for (Message message : messages) {
l.info("user: " + message);
	}
	return messages;

}

@Override
public Message addMessage(Message m) {
	// TODO Auto-generated method stub
	return messageRepository.save(m);
}

@Override
public void deleteMessage(String id) {
	// TODO Auto-generated method stub
	messageRepository.deleteById(Long.parseLong(id));
	
}

@Override
public Message updateMessage(Message m) {
	// TODO Auto-generated method stub
	return messageRepository.save(m);

}

@Override
public Message retrieveMessage(String id) {
	// TODO Auto-generated method stub
	Message m = messageRepository.findById(Long.parseLong(id)).orElse(null);
	return m;
}


}
