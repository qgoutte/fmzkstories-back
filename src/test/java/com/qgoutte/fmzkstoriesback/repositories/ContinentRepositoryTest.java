package com.qgoutte.fmzkstoriesback.repositories;

import com.qgoutte.fmzkstoriesback.entities.Continent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContinentRepositoryTest {
    @Autowired
    private ContinentRepository continentRepository;

    @Test
    void testFindById() {
        Optional<Continent> continent1 = continentRepository.findById("Europe");
        assertTrue(continent1.isPresent());
        assertEquals("Europe",continent1.get().getName());
        Optional<Continent> continent2 = continentRepository.findById("Test");
        assertFalse(continent2.isPresent());
    }

    @Test
    void testFindAll(){
        Iterable<Continent> continents = continentRepository.findAll();

        AtomicReference<Integer> count = new AtomicReference<>(0);

        continents.forEach(continent -> count.getAndSet(count.get() + 1));

        assertEquals(6,count.get());
    }
}