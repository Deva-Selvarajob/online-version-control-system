package com.ovcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovcs.model.FileDocument;
import com.ovcs.model.Version;
import com.ovcs.repository.FileRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
 
@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;
 
    public FileDocument createFile(String name, String path, String content) {
        FileDocument file = new FileDocument();
        file.setName(name);
        file.setPath(path);
        file.setContent(content);
        file.getVersions().add(createVersion(content));
        return fileRepository.save(file);
    }
 
    public Optional<FileDocument> readFile(String path) {
        return fileRepository.findByPath(path);
    }
 
    public FileDocument updateFile(String path, String newContent) {
        Optional<FileDocument> fileOpt = fileRepository.findByPath(path);
        if (fileOpt.isPresent()) {
            FileDocument file = fileOpt.get();
            file.setContent(newContent);
            file.getVersions().add(createVersion(newContent));
            return fileRepository.save(file);
        }
        throw new RuntimeException("File not found");
    }
 
    public List<Version> getVersions(String path) {
        Optional<FileDocument> fileOpt = fileRepository.findByPath(path);
        if (fileOpt.isPresent()) {
            return fileOpt.get().getVersions();
        }
        throw new RuntimeException("File not found");
    }
 
    private Version createVersion(String content) {
        Version version = new Version();
        version.setContent(content);
        version.setTimestamp(LocalDateTime.now());
        return version;
    }
}