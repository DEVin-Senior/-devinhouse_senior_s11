package com.example.apireactcrud.repository;

import com.example.apireactcrud.model.AutoridadeUser;
import com.example.apireactcrud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoridadeRepository extends JpaRepository<AutoridadeUser, String> {

}
