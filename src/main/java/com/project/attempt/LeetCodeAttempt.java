package com.project.attempt;

import java.util.Arrays;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[][] edges1 = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(redundantConnection(edges1)));

        int[][] edges2 = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(redundantConnection(edges2)));

    }

    // This method returns an edge that can be removed while still maintaining the tree structure
    // of the graph. Returns null if no such edge exists.
    public static int[] redundantConnection(int[][] edges) {

        // Since the challenge specifications specified we want the latest edge if there are
        // multiple possible edges as a solution, we start looping from the end of the array.
        for (int i = edges.length - 1; i >= 0; i--) {

            // While looping through the array, what we want to look out for is whether the two
            // nodes in the current edges[i] can be found elsewhere in the graph. If they both
            // can be found elsewhere, it means that deleting the current edge will not disconnect
            // the two nodes from the rest of the graph as they're still connected elsewhere. We
            // set both booleans to false and set them to true if their respective nodes can be
            // detected elsewhere.
            boolean firstNode = false;
            boolean secondNode = false;

            // We do a second loop through the array to detect the presence
            // of the nodes in edges[i] elsewhere in the graph.
            for (int j = 0; j < edges.length; j++) {

                // We skip when we are iterating over the exact same edge.
                if (edges[i] == edges[j]) { continue; }

                if (edges[i][0] == edges[j][0] || edges[i][0] == edges[j][1]) {
                    firstNode = true;
                }

                if (edges[i][1] == edges[j][0] || edges[i][1] == edges[j][1]) {
                    secondNode = true;
                }

                // If both nodes could be found in the graph, then the current edges[i]
                // can be safely deleted without ruining the tree structure of the graph.
                // Hence, we return it when both booleans hold true.
                if (firstNode && secondNode) { return edges[i]; }

            }

        }

        // If we reach this point, it means no edge could be found that can be safely deleted
        // without disturbing the tree structure of the graph.
        return null;

    }

}
