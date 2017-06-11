/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import Local.LocationList;

/**
 *
 * @author Vinicio
 */
public class Graph {

    private static long[][] grafos;
    private static LocationList data = new LocationList();

    public Graph() {
        //tiendas
        data.insertStore(100, 100, "Mall San Pedro");//0
        data.insertStore(100, 600, "Paseo Metropoli");//1
        data.insertStore(1200, 100, "Terra Mall");//2
        data.insertStore(1200, 600, "Los Yoses");//3
        data.insertStore(800, 300, "Multiplaza");//4
        data.insertStore(600, 400, "Lincon Plaza");//5
        //gasolineras
        data.insertGas(700, 100, "Gasolinera El Sol");//6
        data.insertGas(600, 600, "Gasolinera La Luna");//7
        data.insertGas(400, 200, "Gasolinera El Puente");//8
        data.insertGas(600, 500, "Gasolinera La Bomba");//9
        data.insertGas(100, 300, "Gasolinera Este");//10
        data.insertGas(1200, 400, "Gasolinera Oeste");//11
        //centros de distribucion
        data.insertCenter(200, 300, "CD #1");//12
        data.insertCenter(900, 500, "CD #2");//13
        data.insertCenter(500, 500, "CD #3");//14
        data.insertCenter(800, 200, "CD #4");//15
        data.insertCenter(1000, 200, "CD #5");//16
        data.insertCenter(300, 400, "CD #6");//17
        //pueblos
        data.insertTown(800, 400, "Cartago");//18
        data.insertTown(400, 100, "San Jose");//19
        data.insertTown(300, 600, "Alajuela");//20
        data.insertTown(500, 300, "Heredia");//21
        data.insertTown(900, 600, "Limon");//22
        data.insertTown(1000, 300, "Guanacaste");//23

        grafos = new long[data.getSize()][data.getSize()];
        for (int i = 0; i < data.getSize(); i++) {
            for (int j = 0; j < data.getSize(); j++) {
                grafos[i][j] = 10000;
            }
        }
        //definicio de rutas posibles
        grafos[0][10] = data.getDistance(0, 10);
        grafos[0][19] = data.getDistance(0, 19);
        grafos[19][6] = data.getDistance(19, 6);
        grafos[6][2] = data.getDistance(6, 2);
        grafos[10][12] = data.getDistance(10, 12);
        grafos[4][18] = data.getDistance(4, 18);
        grafos[18][5] = data.getDistance(18, 5);
        grafos[18][11] = data.getDistance(18, 11);
        grafos[11][2] = data.getDistance(11, 2);
        grafos[11][3] = data.getDistance(11, 3);
        grafos[19][8] = data.getDistance(19, 8);
        grafos[8][15] = data.getDistance(8, 15);
        grafos[1][10] = data.getDistance(1, 10);
        grafos[1][20] = data.getDistance(1, 20);
        grafos[20][17] = data.getDistance(20, 17);
        grafos[20][7] = data.getDistance(20, 7);
        grafos[21][14] = data.getDistance(21, 14);
        grafos[5][9] = data.getDistance(5, 9);
        grafos[14][9] = data.getDistance(14, 9);
        grafos[7][22] = data.getDistance(7, 22);
        grafos[22][13] = data.getDistance(22, 13);
        grafos[4][23] = data.getDistance(4, 23);
        grafos[23][16] = data.getDistance(23, 16);
        grafos[22][3] = data.getDistance(22, 3);
        grafos[12][21] = data.getDistance(12, 21);
        grafos[21][4] = data.getDistance(21, 4);
    }

    public long[][] getGraph() {
        return grafos;
    }

    public LocationList getData() {
        return data;
    }
}
