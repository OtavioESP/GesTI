package com.example.api.controller;

import com.example.api.domain.status.StatusResponseDTO;
import com.example.api.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/{statusId}")
    public ResponseEntity<StatusResponseDTO> get(@PathVariable Integer statusId) {
        StatusResponseDTO status = this.statusService.getStatus(statusId);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StatusResponseDTO>> list() {
        List<StatusResponseDTO> statusList = this.statusService.listAllStatus();
        return ResponseEntity.ok(statusList);
    }
}
