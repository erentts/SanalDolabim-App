package tr.edu.yildiz.erentutus.entities;

import java.util.ArrayList;

public class Cabin {
    private String stage;
    public static ArrayList<ArrayList<String>> savedCombines = new ArrayList<ArrayList<String>>();

    public Cabin(String stage) {
        this.stage = stage;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public static ArrayList<ArrayList<String>> getSavedCombines() {
        return savedCombines;
    }

    public static void setSavedCombines(ArrayList<ArrayList<String>> savedCombines) {
        Cabin.savedCombines = savedCombines;
    }
}
