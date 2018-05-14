package de.normalisiert.utils.graphs;

import java.util.Vector;

import org.junit.Test;

public class TestStronglyConnectedComponents {

	@Test
	public void testApi() {
		boolean[][] adjMatrix = new boolean[10][];

		for (int i = 0; i < 10; i++) {
			adjMatrix[i] = new boolean[10];
		}

		/*
		 * adjMatrix[0][1] = true; adjMatrix[1][2] = true; adjMatrix[2][0] = true;
		 * adjMatrix[2][4] = true; adjMatrix[1][3] = true; adjMatrix[3][6] = true;
		 * adjMatrix[6][5] = true; adjMatrix[5][3] = true; adjMatrix[6][7] = true;
		 * adjMatrix[7][8] = true; adjMatrix[7][9] = true; adjMatrix[9][6] = true;
		 */

		adjMatrix[0][1] = true;
		adjMatrix[1][2] = true;
		adjMatrix[2][0] = true;
		adjMatrix[2][6] = true;
		adjMatrix[3][4] = true;
		adjMatrix[4][5] = true;
		adjMatrix[4][6] = true;
		adjMatrix[5][3] = true;
		adjMatrix[6][7] = true;
		adjMatrix[7][8] = true;
		adjMatrix[8][6] = true;

		adjMatrix[6][1] = true;

		int[][] adjList = AdjacencyList.getAdjacencyList(adjMatrix);
		StrongConnectedComponents scc = new StrongConnectedComponents(adjList);
		for (int i = 0; i < adjList.length; i++) {
			System.out.print("i: " + i + "\n");
			SCCResult r = scc.getAdjacencyList(i);
			if (r != null) {
				Vector<Integer>[] al = scc.getAdjacencyList(i).getAdjList();
				for (int j = i; j < al.length; j++) {
					if (al[j].size() > 0) {
						System.out.print("j: " + j);
						for (int k = 0; k < al[j].size(); k++) {
							System.out.print(" _" + al[j].get(k).toString());
						}
						System.out.print("\n");
					}
				}
				System.out.print("\n");
			}
		}
	}
}
