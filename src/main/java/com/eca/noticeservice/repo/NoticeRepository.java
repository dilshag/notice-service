package com.eca.noticeservice.repo;

import com.eca.noticeservice.entity.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticeRepository extends MongoRepository<Notice, String> {
}