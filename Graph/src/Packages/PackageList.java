package Packages;

import java.awt.Graphics;
import Local.LocationList;
public class PackageList {

    private Package head;
    private Package last;
    private int size;

    public PackageList() {
        head = last = null;
        size = 0;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertPackage(int inicio, int fin, LocationList data, long[][]grafos) {
        Package newNode = new Package(inicio, fin, data, grafos);
        if (isEmpty()) {
            head = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }
    
    public int getposX1(int nodo) {
        if (nodo == 0) {
            return head.getPosX1();
        }else{
            Package temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getPosX1();
        }  
    }
    public int getposX2(int nodo) {
        if (nodo == 0) {
            return head.getPosX2();
        }else{
            Package temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getPosX2();
        }  
    }

    public int getposY1(int nodo) {
        if (nodo == 0) {
            return head.getPosY1();
        }else{
            Package temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getPosY1();
        }
    }public int getposY2(int nodo) {
        if (nodo == 0) {
            return head.getPosY2();
        }else{
            Package temp = head;
            for (int i = 0; i < nodo; i++) {
                temp = temp.getNext();
            }
            return temp.getPosY2();
        }
    }

    public int getSize() {
        return size;
    }

    public Package getHead() {
        return this.head;
    }
    public void render(Graphics g){
            for (Package temp = head; temp != null; temp=temp.getNext()) {
                temp.render(g);
            }
    }
}
