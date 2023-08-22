package com.qgoutte.fmzkstoriesback.repositories;

import com.qgoutte.fmzkstoriesback.entities.Continent;
import com.qgoutte.fmzkstoriesback.entities.Fm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FmRepositoryTest {
    @Autowired
    private FmRepository fmRepository;

    @Test
    void testFindById(){
        Optional<Fm> fm1 = fmRepository.findById("FM23");
        assertTrue(fm1.isPresent());
        assertEquals("FM23",fm1.get().getId());
        assertEquals("Football Manager 2023",fm1.get().getName());
        Optional<Fm> fm2 = fmRepository.findById("Test");
        assertFalse(fm2.isPresent());
    }

    @Test
    void testFindAll(){
        Iterable<Fm> fm = fmRepository.findAll();

        AtomicReference<Integer> count = new AtomicReference<>(0);

        fm.forEach(continent -> count.getAndSet(count.get() + 1));

        assertEquals((int) fmRepository.count(),count.get());
    }

}