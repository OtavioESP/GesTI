package com.example.api.controller;

import com.example.api.domain.time.TimeRequestDTO;
import com.example.api.domain.time.TimeResponseDTO;
import com.example.api.domain.time.TimeResponseDetailDTO;
import com.example.api.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/list")
    public ResponseEntity<List<TimeResponseDTO>> listAllTimes() {
        return ResponseEntity.ok(this.timeService.listAllTimes());
    }

    @GetMapping("/{timeId}/detail")
    public ResponseEntity<TimeResponseDetailDTO> getTimeDetail(@RequestParam UUID timeId) {
        TimeResponseDetailDTO detailedTime = this.timeService.getDetailTime(timeId);
        return ResponseEntity.ok(detailedTime);
    }

    @PostMapping("/create")
    public ResponseEntity<TimeResponseDTO> createTime(@RequestBody TimeRequestDTO body) {
        return ResponseEntity.ok(this.timeService.createTime(body));
    }
}
