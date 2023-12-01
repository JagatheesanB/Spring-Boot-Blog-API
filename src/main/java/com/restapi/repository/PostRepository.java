package com.restapi.repository;

import com.restapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //    @Query("select p from Post p inner join p.appUser a where a.id=?1")
    //    Optional<Post> findById(Long id);



}
