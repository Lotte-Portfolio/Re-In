package com.rein.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rein.entity.File;

public interface FileRepository extends JpaRepository<File, Long> {

}
