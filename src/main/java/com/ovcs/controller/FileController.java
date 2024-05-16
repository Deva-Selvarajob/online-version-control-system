package com.ovcs.controller;
 
import com.ovcs.model.FileDocument;
import com.ovcs.model.Version;
import com.ovcs.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;
 
    @PostMapping
    public ResponseEntity<FileDocument> createFile(@RequestParam String name, @RequestParam String path, @RequestParam String content) {
        return ResponseEntity.ok(fileService.createFile(name, path, content));
    }
 
    @GetMapping
    public ResponseEntity<FileDocument> readFile(@RequestParam String path) {
        Optional<FileDocument> file = fileService.readFile(path);
        return file.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @PutMapping
    public ResponseEntity<FileDocument> updateFile(@RequestParam String path, @RequestParam String newContent) {
        return ResponseEntity.ok(fileService.updateFile(path, newContent));
    }
 
    @GetMapping("/versions")
    public ResponseEntity<List<Version>> getFileVersions(@RequestParam String path) {
        return ResponseEntity.ok(fileService.getVersions(path));
    }
}