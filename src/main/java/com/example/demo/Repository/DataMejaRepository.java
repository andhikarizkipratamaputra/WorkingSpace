package com.example.demo.Repository;

import com.example.demo.Model.audit.DataMeja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface DataMejaRepository extends JpaRepository<DataMeja, Long> {



}
