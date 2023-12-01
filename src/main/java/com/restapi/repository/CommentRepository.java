package com.restapi.repository;

import com.restapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

//    @Query("select c from Comment c inner join c.appUser a where a.id=?1")
//    Optional<Comment> findById(Long id);

}
