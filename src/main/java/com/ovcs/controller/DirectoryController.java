package com.ovcs.controller;
import com.ovcs.model.Directory;
import com.ovcs.model.FileDocument;
import com.ovcs.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.Optional;
 
@RestController
@RequestMapping("/directories")
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;
 
    @PostMapping
    public ResponseEntity<Directory> createDirectory(@RequestParam String name, @RequestParam String path) {
        return ResponseEntity.ok(directoryService.createDirectory(name, path));
    }
 
    @GetMapping
    public ResponseEntity<Directory> readDirectory(@RequestParam String path) {
        Optional<Directory> directory = directoryService.readDirectory(path);
        return directory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @PutMapping("/add-file")
    public ResponseEntity<Directory> addFileToDirectory(@RequestParam String dirPath, @RequestBody FileDocument file) {
        return ResponseEntity.ok(directoryService.addFileToDirectory(dirPath, file));
    }
 
    @PutMapping("/add-subdirectory")
    public ResponseEntity<Directory> addSubdirectoryToDirectory(@RequestParam String parentDirPath, @RequestBody Directory subdirectory) {
        return ResponseEntity.ok(directoryService.addSubdirectoryToDirectory(parentDirPath, subdirectory));
    }
}