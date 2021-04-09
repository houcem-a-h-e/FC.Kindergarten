package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.MessageRepository;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.services.IMessageService;
import tn.esprit.spring.services.IParentService;

@RestController
public class MessageRestController {
	
    @Autowired
    private IMessageService messageService;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ParentRepository ParentRepository;
    @Autowired
    IParentService parentService;
    

    
 // http://localhost:8080/Kindergarten/servlet/retrieve-all-messages-env
  	@GetMapping("/retrieve-all-messages-env/{Parent-id}")
  	@ResponseBody
  	public List<ArrayList<Message>> getMessageEnv(@PathVariable("Parent-id") Long c) {
  		
  		List<Message> list = messageRepository.findAAllBySender(c);
  	list.addAll(messageRepository.findAAllByReciever(c));
  	List<Parent> specificParent = ParentRepository.findAll();
  	int x,y;
  	List<ArrayList<Message>> msg=new ArrayList<ArrayList<Message>>();
  	for(x=0;x<specificParent.size();x++){
  		List<Message> msgParents=new ArrayList<Message>();
  		for(y=0;y<list.size();y++){
  	  		Long a=specificParent.get(x).getId();
  	  		if(list.get(y).getSender().getId()==a || list.get(y).getReciever().getId()==a){
  	  			msgParents.add(list.get(y));
  	  		}
  	  	}
  		msg.add((ArrayList<Message>) msgParents);
  	}
  	return msg;
  	}
  //http://localhost:8080/Kindergarten/servlet/add-message
	@PostMapping("/add-message")
	@ResponseBody
	public Message addMessage(@RequestBody Message m,@RequestParam Long sender_id,@RequestParam Long reciever_id) {

	    Message message=new Message();   
		Parent sender=parentService.retrieveParent(sender_id);
		Parent reciever=parentService.retrieveParent(reciever_id);
		message.setSender(sender);
		message.setReciever(reciever);
		message.setDescription_chat(m.getDescription_chat());
	        messageRepository.save(message);
	return message;
	}
	
	@DeleteMapping("/remove-message/{message-id}")
	@ResponseBody
	public void removeMessage(@PathVariable("message-id") String messageId) {
		messageService.deleteMessage(messageId);
	}
	
	@PutMapping("/modify-message")
	@ResponseBody
	public Message modifyMessage(@RequestBody Message message) {
	return messageService.updateMessage(message);
	}
	
	
}
