package com.pragma.backend.application.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RequestHandler {
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("GET request received");
    }
    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("POST request received");
    }
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("PUT request received");
    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("DELETE request received");
    }
}