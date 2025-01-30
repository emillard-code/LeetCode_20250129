package com.project.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeSolution {

    public static void main(String[] args) {

        int[][] edges1 = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(findRedundantConnection(edges1)));

        int[][] edges2 = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges2)));

    }

    // Performs DFS and returns true if there's a path between src and target.
    private static boolean isConnected(int src, int target, boolean[] visited, List<Integer>[] adjList) {

        visited[src] = true;

        if (src == target) { return true; }

        boolean isFound = false;

        for (int adj : adjList[src]) {

            if (!visited[adj]) {
                isFound = isFound || isConnected(adj, target, visited, adjList);
            }

        }

        return isFound;

    }

    public static int[] findRedundantConnection(int[][] edges) {

        int N = edges.length;

        List<Integer>[] adjList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            boolean[] visited = new boolean[N];

            // If DFS returns true, we will return the edge.
            if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
                return new int[] { edge[0], edge[1] };
            }

            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);

        }

        return new int[] {};

    }

}
