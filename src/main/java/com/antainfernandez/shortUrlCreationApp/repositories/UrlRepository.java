package com.antainfernandez.shortUrlCreationApp.repositories;

import com.antainfernandez.shortUrlCreationApp.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}
