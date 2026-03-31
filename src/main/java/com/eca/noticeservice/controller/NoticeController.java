package com.eca.noticeservice.controller;

import com.eca.noticeservice.entity.Notice;
import com.eca.noticeservice.repo.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
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

    @GetMapping("/{id}")
    public ResponseEntity<Notice> getById(@PathVariable String id) {
        Optional<Notice> notice = noticeRepository.findById(id);

        if (notice.isPresent()) {
            return ResponseEntity.ok(notice.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> update(@PathVariable String id, @RequestBody Notice updatedNotice) {
        Optional<Notice> optionalNotice = noticeRepository.findById(id);

        if (optionalNotice.isPresent()) {
            Notice existingNotice = optionalNotice.get();
            existingNotice.setTitle(updatedNotice.getTitle());
            existingNotice.setContent(updatedNotice.getContent());

            Notice savedNotice = noticeRepository.save(existingNotice);
            return ResponseEntity.ok(savedNotice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        Optional<Notice> optionalNotice = noticeRepository.findById(id);

        if (optionalNotice.isPresent()) {
            noticeRepository.deleteById(id);
            return ResponseEntity.ok("Notice deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



/*
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
}*/
