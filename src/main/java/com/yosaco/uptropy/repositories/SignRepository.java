package com.yosaco.uptropy.repositories;

import com.yosaco.uptropy.domain.Sign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SignRepository extends JpaRepository<Sign, Long> {
    Optional<Sign> findByAddress(String address);
    List<Sign> findByUserUsername(String username);
    Page<Sign> findByUserUsername(String username, Pageable pageable);
}
