package com.ovcs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ovcs.model.Directory;

import java.util.Optional;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {
   Optional<Directory> findByPath(String path);
}