package com.ananta.mahasiswa.repo;

import com.ananta.mahasiswa.entity.MahasiswaData;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class MahasiswaDataRepoTest {

    @Autowired
    private MahasiswaDataRepo repo;

    private Logger logger = LoggerFactory.getLogger(MahasiswaDataRepoTest.class);

    @Test
    public void findAllTest() {
        List<MahasiswaData> result = repo.findAll();
        logger.info("isi datanya : " + result.size());
        Assert.notEmpty(result);
    }

}
