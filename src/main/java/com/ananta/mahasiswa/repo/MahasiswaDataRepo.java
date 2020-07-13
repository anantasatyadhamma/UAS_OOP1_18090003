package com.ananta.mahasiswa.repo;

import com.ananta.mahasiswa.entity.MahasiswaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaDataRepo extends JpaRepository<MahasiswaData, String> {
}
