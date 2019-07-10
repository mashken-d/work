package com.practice.work.repos;

import com.practice.work.models.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface ReadersRepository extends JpaRepository<Readers, Long> {
    @Query(value = "select * from readers r where r.fl_name = :name", nativeQuery = true)
    List<Readers> findByfl_name(@Param("name") String fl_name);
}
