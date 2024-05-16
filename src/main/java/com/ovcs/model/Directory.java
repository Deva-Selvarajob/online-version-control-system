package com.ovcs.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
 
@Data
@Entity
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
    private String path;
 
    @OneToMany
    private List<FileDocument> files = new ArrayList<>();
 
    @OneToMany
    private List<Directory> subdirectories = new ArrayList<>();
 
    @jakarta.persistence.Version
    private Long version;
}