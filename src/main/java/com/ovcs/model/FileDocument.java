package com.ovcs.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;
 

@Entity
public class FileDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
    private String path;
 
    @Lob
    private String content;
 
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Version> versions = new ArrayList<>();
 
    @jakarta.persistence.Version
    private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Version> getVersions() {
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public FileDocument(Long id, String name, String path, String content, List<Version> versions, Long version) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.content = content;
		this.versions = versions;
		this.version = version;
	}

	public FileDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
}