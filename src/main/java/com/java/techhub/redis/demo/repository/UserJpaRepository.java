/**
 * 
 */
package com.java.techhub.redis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.techhub.redis.demo.model.User;

/**
 * @author mahes
 *
 */
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
