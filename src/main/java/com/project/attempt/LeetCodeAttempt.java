package com.project.attempt;

import java.util.Arrays;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[][] edges1 = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(redundantConnection(edges1)));

        int[][] edges2 = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(redundantConnection(edges2)));

    }

    public static int[] redundantConnection(int[][] edges) {

        for (int i = edges.length - 1; i >= 0; i--) {

            boolean firstNode = false;
            boolean secondNode = false;

            for (int j = 0; j < edges.length; j++) {

                if (edges[i] == edges[j]) { continue; }

                if (edges[i][0] == edges[j][0] || edges[i][0] == edges[j][1]) {
                    firstNode = true;
                }

                if (edges[i][1] == edges[j][0] || edges[i][1] == edges[j][1]) {
                    secondNode = true;
                }

                if (firstNode && secondNode) { return edges[i]; }

            }

        }

        return null;

    }

}
