/**
 * COPYRIGHT (C) 2021 Group 4: David Hernandez, Jennifer Lewis, Seung Jung, Daniel O'Donnell. All Rights Reserved.
 * Group Project M04-A03
 *
 * @author Jennifer Lewis
 * @version 1.01 2021-11-27
 */
package com.example.financeapp.repository;

import com.example.financeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//Interface that handles finding users by id
public interface UserRepository extends JpaRepository<User,String> {

    @Override
    Optional<User> findById(String id);



}
