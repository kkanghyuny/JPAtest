package com.example.demo.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team.domain.Team;

public interface TeamRepository  extends JpaRepository<Team, Long> {
}
