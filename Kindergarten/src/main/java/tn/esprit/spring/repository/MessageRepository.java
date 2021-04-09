package tn.esprit.spring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Message;



@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	//@Query("SELECT message.sender from Message as message where message.sender.client_id = :clientId")
	//List<Message> findByClientId(int clientId);
	@Query(value="select * from Message msg where msg.id_client_sender=:id",nativeQuery =true)
	List<Message> findAAllBySender(@Param("id") Long id);
	@Query(value="select * from Message msg where msg.id_client_reciever=:id",nativeQuery =true)
	List<Message> findAAllByReciever(@Param("id") Long c);

}
