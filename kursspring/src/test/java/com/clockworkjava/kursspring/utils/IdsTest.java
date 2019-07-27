package com.clockworkjava.kursspring.utils;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IdsTest {

    @Test
    public void testEmptySet(){
        int result = Ids.generateNewId(Collections.emptySet());
        assertEquals(0, result);
    }

    @Test
    public void testGenerateNewId(){
        Set<Integer> sampleSet = new HashSet<>();
        sampleSet.add(6);
        sampleSet.add(7);
        sampleSet.add(8);
        int result = Ids.generateNewId(sampleSet);
        assertEquals(9, result);
    }
}
