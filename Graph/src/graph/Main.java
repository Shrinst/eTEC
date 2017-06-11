package graph;

/**
 *
 * @author Vinicio
 */
import Local.LocationList;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import Packages.*;

public class Main extends Canvas implements Runnable {

    private Thread thread;
    private JFrame jframe;
    public final String NAME = "Dristribution Map";
    public int fps = 0;
    public int aps = 0;
    private final int width = 1300;
    private final int height = 700;
    private volatile boolean isAlive = false;
    //private static Graph grafo = new Graph(data.getSize());
    private static Random rnd = new Random();
    private static long[][] grafos;
    private static LocationList data;
    private static PackageList data1 = new PackageList();

    public static void main(String[] args) {
        Main miAplicacion = new Main();
    }

    public Main() {
        this.setUpGame();
        this.start();
        jframe.setVisible(true);
        Graph grafo = new Graph();
        grafos = grafo.getGraph();
        data = grafo.getData();
        //data1.insertPackage(0,10,data,grafos);
    }

    private void setUpGame() {
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));

        jframe = new JFrame();
        jframe.add(this);

        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
    }

    private synchronized void start() {
        if (isAlive) {
            return;
        }
        isAlive = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!isAlive) {
            return;
        }
        isAlive = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    private void tick() {
        aps++;
    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bufferStrategy.getDrawGraphics();
        for (int i = 0; i < data.getSize(); i++) {
            for (int j = 0; j < data.getSize(); j++) {
                int x1 = data.getposX(i) + 5;
                int y1 = data.getposY(i) + 5;
                int x2 = data.getposX(j) + 5;
                int y2 = data.getposY(j) + 5;
                if (grafos[i][j] == 10000) {

                } else {
                    g.setColor(Color.orange);
                    g.drawLine(x1, y1, x2, y2);
                    int x = ((x1 + 5) / 2) + ((x2 + 5) / 2);
                    int y = ((y1 + 15) / 2) + ((y2 + 15) / 2);
                    String distance = "" + data.getDistance(i, j);
                    g.setColor(Color.black);
                    g.drawString(distance, x, y);
                }
            }
        }
        for (int i = 0; i < data.getSize(); i++) {
            int x = data.getposX(i);
            int y = data.getposY(i);
            String name = data.getName(i);
            g.setColor(Color.red);
            g.fillOval(x, y, 12, 12);
            g.setColor(Color.black);
            g.drawString(name, x, y - 5);
        }
        g.setColor(Color.blue);
        //data1.render(g);
        g.setColor(Color.black);
        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void run() {
        isAlive = true;
        requestFocus();
        // Initialize the variable to limit the loop�s max speed
        final int NS_PER_SECOND = 1000000000; // How many nanoseconds are there
        // in a second
        final byte APS = 60; // Actualization Per Second
        final double NS_PER_ACTUALIZATION = NS_PER_SECOND / APS;

        long updateReference = System.nanoTime(); // Reference before the loop
        // starts
        long counterReference = System.nanoTime();

        double timeElapsed;
        double delta = 0; // Amount of time until an update is made

        requestFocus();

        while (isAlive) {
            final long startLoop = System.nanoTime(); // Starts counting the
            // time

            timeElapsed = startLoop - updateReference; // How much time has
            // passed since the loop
            // starts
            updateReference = startLoop;
            delta += timeElapsed / NS_PER_ACTUALIZATION;

            while (delta >= 1) {
                tick();
                render();
                delta--;
            }

            // See the information about the FPS and APS
            if ((System.nanoTime() - counterReference) > NS_PER_SECOND) {

                jframe.setTitle(NAME + " || APS: " + aps + " || FPS: " + fps);
                aps = 0;
                fps = 0;
                counterReference = System.nanoTime();
            }
        }
    }

}
