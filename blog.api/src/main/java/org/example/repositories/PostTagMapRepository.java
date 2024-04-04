package org.example.repositories;

import org.example.entities.PostTagMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagMapRepository extends JpaRepository<PostTagMapEntity, Integer> {

}