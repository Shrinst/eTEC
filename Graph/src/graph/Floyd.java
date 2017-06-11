/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Vinicio
 */
public class Floyd {
    public String floydAlgorithm(long[][] mAdy) {
		int vertex = mAdy.length;
		long[][] adjacencyMatrix = mAdy;
		String[][] shrotestPath = new String[vertex][vertex]; //caminos
		String[][] shortestPathAux = new String[vertex][vertex]; // caminosAux
		String road = "", result = "", path = ""; // caminoRecorrido, cadena, caminitos
		int i, j, k;
		float temp1, temp2, temp3, temp4, minimum;
		
		// Initialize the matrices
		for (i = 0; i < vertex; i++) {
			for (j = 0; j < vertex; j++) {
				shrotestPath[i][j] = "";
				shortestPathAux[i][j] = "";
			}
		}
		
		for (k = 0; k < vertex; k++) {
			for (i = 0; i < vertex; i++) {
				for (j = 0; j < vertex; j++) {
					temp1 = adjacencyMatrix[i][j];
					temp2 = adjacencyMatrix[i][k];
					temp3 = adjacencyMatrix[k][j];
					temp4 = temp2 + temp3;
					
					// Looking for the minimun
					minimum = Math.min(temp1, temp4);
					
					if (temp1 != temp4) {
						if (minimum == temp4) {
							road = "";
							shortestPathAux[i][j] = k + "";
							shrotestPath[i][j] = shortestPathR(i, k, shortestPathAux, road) + (k + 1);
						}
					}
					adjacencyMatrix[i][j] = (long) minimum;
				}
			}
		}
		// Add the road to the result
		for (i = 0; i < vertex; i++) {
			for (j = 0; j < vertex; j++) {
				result = result  + "[" + adjacencyMatrix[i][j] + "]";
			}
			result = result + "\n";
		}	
		
		/////////////////////////////////////////
		for (i = 0; i < vertex; i++) {
			for (j = 0; j < vertex; j++) {
				if (adjacencyMatrix[i][j] != 10000) {
					if (i != j) {
						if (shrotestPath[i][j].equals("")) {
							path +=(i) + "." + (j) + "," + (i) + "." + (j) + ";";
						} else {
							path +=(i) + "." + (j) + "," + (i) + "."
											+ shrotestPath[i][j] + "." + (j) + ";";
						}
					}
				}
			}
		}
		
		return path.substring(0, path.length()-1);
	}

	private String shortestPathR(int i, int k, String[][] shortestPathAux, String road) {
		if (shortestPathAux[i][k].equals("")) {
			return "";
		} else {
			road += shortestPathR(i, Integer.parseInt(shortestPathAux[i][k]), shortestPathAux, road) + 
					(Integer.parseInt(shortestPathAux[i][k]) + 1) + ".";
			return road;
		}
	}
}
