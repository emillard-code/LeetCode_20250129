package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void redundantConnectionTest() {

        int[][] edges1 = new int[][]{{1,2},{1,3},{2,3}};
        int[] solution1 = new int[]{2,3};
        assertArrayEquals(solution1, LeetCodeAttempt.redundantConnection(edges1));

        int[][] edges2 = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] solution2 = new int[]{1,4};
        assertArrayEquals(solution2, LeetCodeAttempt.redundantConnection(edges2));

    }

}
