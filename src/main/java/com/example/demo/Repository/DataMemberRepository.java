package com.example.demo.Repository;

import com.example.demo.Model.audit.DataMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataMemberRepository extends JpaRepository<DataMember,Long> {
}
