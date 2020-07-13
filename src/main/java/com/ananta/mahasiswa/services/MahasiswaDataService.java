package com.ananta.mahasiswa.services;

import com.ananta.mahasiswa.entity.MahasiswaData;
import com.ananta.mahasiswa.model.MahasiswaDataModel;
import com.ananta.mahasiswa.repo.MahasiswaDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaDataService {

    @Autowired
    private MahasiswaDataRepo repo;

    public List<MahasiswaData> getAllData() {
        return repo.findAll();
    }

    public MahasiswaData convertToEntity(MahasiswaDataModel model) {
      MahasiswaData result = new MahasiswaData();
      result.setNim(model.getNim());
      result.setNama(model.getNama());
      result.setJurusan(model.getJurusan());
      result.setAlamat(model.getAlamat());
      return result;
  }

  public MahasiswaData save(MahasiswaData mhs) {
      return repo.save(mhs);
  }
  public Optional<MahasiswaData> findById(String nim) {
    return repo.findById(nim);
}

public void removeById(String nim) {
    repo.deleteById(nim);
}

}
