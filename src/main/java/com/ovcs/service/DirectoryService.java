package com.ovcs.service;

import com.ovcs.model.Directory;
import com.ovcs.model.FileDocument;
import com.ovcs.repository.DirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectoryService {
   @Autowired
   private DirectoryRepository directoryRepository;

   public Directory createDirectory(String name, String path) {
       Directory directory = new Directory();
       directory.setName(name);
       directory.setPath(path);
       return directoryRepository.save(directory);
   }

   public Optional<Directory> readDirectory(String path) {
       return directoryRepository.findByPath(path);
   }

   public Directory addFileToDirectory(String dirPath, FileDocument file) {
       Optional<Directory> dirOpt = directoryRepository.findByPath(dirPath);
       if (dirOpt.isPresent()) {
           Directory directory = dirOpt.get();
           directory.getFiles().add(file);
           return directoryRepository.save(directory);
       }
       throw new RuntimeException("Directory not found");
   }

   public Directory addSubdirectoryToDirectory(String parentDirPath, Directory subdirectory) {
       Optional<Directory> dirOpt = directoryRepository.findByPath(parentDirPath);
       if (dirOpt.isPresent()) {
           Directory directory = dirOpt.get();
           directory.getSubdirectories().add(subdirectory);
           return directoryRepository.save(directory);
       }
       throw new RuntimeException("Directory not found");
   }
}