package com.xiran.searchbacked.jpa;

import com.xiran.searchbacked.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
}