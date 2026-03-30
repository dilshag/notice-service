package com.eca.noticeservice.controller;

import com.eca.noticeservice.entity.Notice;
import com.eca.noticeservice.repo.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @PostMapping
    public Notice save(@RequestBody Notice notice) {
        return noticeRepository.save(notice);
    }

    @GetMapping
    public List<Notice> getAll() {
        return noticeRepository.findAll();
    }
}