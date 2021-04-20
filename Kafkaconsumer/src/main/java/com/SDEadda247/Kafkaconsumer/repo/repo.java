package com.SDEadda247.Kafkaconsumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SDEadda247.Kafkaconsumer.user.user;

public interface repo extends JpaRepository<user,Long>{

}
