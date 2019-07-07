package com.practice.work.repos;

import com.practice.work.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    @Query(value = "select * from issue i where i.book_id = :bookId", nativeQuery = true)
    List<Issue> getAllByBookId(@Param("bookId") Long bookId);

    @Query(value = "select i from Issue i where i.reader.id = :readerId")
    List<Issue> getAllByReaderId(@Param("readerId") Long readerId);
}
