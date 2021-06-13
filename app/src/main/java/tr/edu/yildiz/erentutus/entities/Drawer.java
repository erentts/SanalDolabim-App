package tr.edu.yildiz.erentutus.entities;

import java.util.ArrayList;

public class Drawer {
    private String name;
    private int clothesId;
    public static ArrayList<Drawer> drawers = new ArrayList<>();

    public Drawer(String name, int clothesId) {
        this.name = name;
        this.clothesId = clothesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClothesId() {
        return clothesId;
    }

    public void setClothesId(int clothesId) {
        this.clothesId = clothesId;
    }

    public static ArrayList<Drawer> getDrawers() {
        return drawers;
    }

    public static void setDrawers(ArrayList<Drawer> drawers) {
        Drawer.drawers = drawers;
    }
}
