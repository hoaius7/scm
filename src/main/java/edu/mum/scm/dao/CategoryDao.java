package edu.mum.scm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import edu.mum.scm.domain.Category;
@Repository
public interface CategoryDao extends JpaRepository<Category, Long>{

}
