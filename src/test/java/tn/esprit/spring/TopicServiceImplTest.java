package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import tn.esprit.spring.entity.Topic;
//import tn.esprit.spring.services.TopicService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceImplTest {
	private static final Logger l = LogManager.getLogger(TopicServiceImplTest.class);
	//@Autowired
	//TopicService ts;
	//@Test
	//public void testretrieveAllUsers() {
	//ts.retrieveAllTopics();
	//}
	//@Test
	//public void testaddTopic() {
		//Topic t;
		//ts.addTopic(t);
	//}
	//@Test
	//public void testdeleteTopic() {
		
		//int id_topic=1;
		//ts.deleteTopic(id_topic);	
	//}
	//@Test
	//public void testupdateTopic() {
	//	Topic t;
	//	ts.updateTopic(t);
	//}
	//@Test
	/*public void testretrieveTopic() {
		int id_topic=3;
		 Topic t=ts.retrieveTopic(id_topic);
		 assertEquals(t.getId_topic(),id_topic);
	}*/
}
