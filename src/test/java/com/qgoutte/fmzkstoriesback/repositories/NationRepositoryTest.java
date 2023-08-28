package com.qgoutte.fmzkstoriesback.repositories;

import com.qgoutte.fmzkstoriesback.entities.Continent;
import com.qgoutte.fmzkstoriesback.entities.Nation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NationRepositoryTest {
    @Autowired
    private NationRepository nationRepository;

//TODO
    @Test
    void testFindById(){
        Optional<Nation> nation1 = nationRepository.findById(20);
        assertTrue(nation1.isPresent());
        assertEquals("France", nation1.get().getName());
        Optional<Nation> nation2 = nationRepository.findById(1000);
        assertFalse(nation2.isPresent());
    }

    @Test
    void testFindAll(){
        Iterable<Nation> nations = nationRepository.findAll();

        AtomicReference<Integer> count = new AtomicReference<>(0);
        nations.forEach(nation -> count.getAndSet(count.get()+1));
        assertEquals(205, count.get());
    }

    @Test
    void testFindNationByName(){
        Optional<Nation> nation = nationRepository.findNationByName("France");
        assertTrue(nation.isPresent());
        Optional<Nation> nation2 = nationRepository.findNationByName("Test");
        assertFalse(nation2.isPresent());
    }

    @Test
    void testFindNationByContinent(){
        List<Nation> nations = nationRepository.findNationsByContinent(new Continent("Europe"));
        assertFalse(nations.isEmpty());
        nations = nationRepository.findNationsByContinent(new Continent("Test"));
        assertTrue(nations.isEmpty());
    }

}