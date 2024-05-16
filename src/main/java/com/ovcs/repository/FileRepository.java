package com.ovcs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ovcs.model.FileDocument;

import java.util.Optional;
 
@Repository
public interface FileRepository extends JpaRepository<FileDocument, Long> {
    Optional<FileDocument> findByPath(String path);
}
