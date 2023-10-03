package br.edu.ibmec.cloud.nuvem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.cloud.nuvem.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
