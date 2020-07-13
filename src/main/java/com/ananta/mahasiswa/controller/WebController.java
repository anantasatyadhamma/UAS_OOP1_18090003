package com.ananta.mahasiswa.controller;

import com.ananta.mahasiswa.entity.MahasiswaData;
import com.ananta.mahasiswa.services.MahasiswaDataService;
import com.ananta.mahasiswa.model.MahasiswaDataModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Controller
public class WebController {

  @Autowired
  private MahasiswaDataService service;

  @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("mhs", service.getAllData());
        return "index";
    }

    @GetMapping("/tambah")
    public String tampilkanTambahForm(Model model) {
        model.addAttribute("mhs", new MahasiswaDataModel());
        return "tambah-mhs";
    }
    @PostMapping("/simpan")
    public String simpan(MahasiswaDataModel mhs) {
        service.save(service.convertToEntity(mhs));
        return "redirect:/";
    }
    @GetMapping("/ubah/{nim}")
    public String edit(@PathVariable("nim") String nim, Model model) {
        Optional<MahasiswaData> result = service.findById(nim);
        if(result.isPresent()) {
            MahasiswaData data = result.get();
            model.addAttribute("mhs", data);
            return "edit-mhs";
        } else return "redirect:/";
    }

    @GetMapping("/hapus/{nim}")
    public String hapus(@PathVariable("nim") String nim) {
        service.removeById(nim);
        return "redirect:/";
    }

}
