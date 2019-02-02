package com.amqp.consumer.smarthome.smar_db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartRepository extends JpaRepository<myEntity, Long> {

}
