package com.crud.repository;

import com.crud.entity.IplTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IplRepository extends JpaRepository<IplTeam, Integer> {
}
