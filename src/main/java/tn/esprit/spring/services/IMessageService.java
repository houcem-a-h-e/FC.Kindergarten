package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Message;

public interface IMessageService {
	
	List<Message> retrieveAllMessages();
	Message addMessage(Message m);
	void deleteMessage(String id);
	Message updateMessage(Message m);
	Message retrieveMessage(String id);

}
