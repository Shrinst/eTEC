/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages;

import java.awt.Graphics;
import Local.LocationList;
import graph.*;

/**
 *
 * @author Vinicio
 */
public class Package {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Package next;
    private int[] path;
    private LocationList data;

    public Package(int inicio, int fin, LocationList data, long[][] grafos) {
        this.x1 = data.getposX(inicio);
        this.y1 = data.getposY(inicio);
        this.x2 = data.getposX(fin);
        this.y2 = data.getposY(fin);
        this.data = data;
        Floyd pink = new Floyd();
        String[][] aux = new String[grafos.length][2];
        String[] pathS;
        String pathy = pink.floydAlgorithm(grafos);
        for (int i = 0; i < grafos.length; i++) {
            for (int j = 0; j < 2; j++) {
                aux[i][j] = pathy.split(";")[i].split(",")[j];
            }
        }
        System.out.println(aux[0][0]);
        String[] aux2 = aux[0][0].split(".");
        System.out.println(aux2[0]);
        for (int i = 0; i < grafos.length; i++) {
            int x = Integer.parseInt(aux[i][0].substring(0, 1));
            int y = Integer.parseInt(aux[i][0].substring(2, 3));
            if (x == inicio && y == fin) {
                pathS = aux[i][1].split(".");
                //System.out.println(pathS.length);
                for (int j = 0; j < pathS.length; j++) {
                    path[j] = Integer.parseInt(pathS[j]);
                }
            }
        }
    }

    public Package getNext() {
        return next;
    }

    public void setNext(Package next) {
        this.next = next;
    }

    public int getPosX1() {
        return x1;
    }

    public void setPosX1(int x) {
        this.x1 = x;
    }

    public int getPosY1() {
        return y1;
    }

    public void setPosY1(int y) {
        this.y1 = y;
    }

    public int getPosX2() {
        return x2;
    }

    public int getPosY2() {
        return y2;
    }

    public void setPosX2(int x2) {
        this.x2 = x2;
    }

    public void setPosY2(int y2) {
        this.y2 = y2;
    }

    public void render(Graphics g) {
        if (x1 == data.getposX(path[1])) {
            g.fillOval(x1 - 3, y1 - 3, 18, 18);
        } else {
            this.setPosX1(x1 + 1);
            g.fillOval(x1 - 3, y1 - 3, 18, 18);
        }
        if (y1 == data.getposX(path[1])) {
            g.fillOval(x1 - 3, y1 - 3, 18, 18);
        } else {
            this.setPosY1(y1 + 1);
            g.fillOval(x1 - 3, y1 - 3, 18, 18);
        }
    }

    public void setPath(int[] path) {
        this.path = path;
    }
}
