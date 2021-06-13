package tr.edu.yildiz.erentutus.entities;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;

public class Clothes {
    private String type;
    private String color;
    private String pattern;
    private String boughtDate;
    private String price;
    private Bitmap thumbnail;

    public static ArrayList<Clothes> clothes = new ArrayList<>();
    public static HashMap<String,Clothes> combin = new HashMap<>();
    public static ArrayList<ArrayList<Bitmap>> combines = new ArrayList<>();

    public Clothes(String type, String color, String pattern, String boughtDate, String price, Bitmap thumbnail) {
        this.type = type;
        this.color = color;
        this.pattern = pattern;
        this.boughtDate = boughtDate;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(String boughtDate) {
        this.boughtDate = boughtDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }

    public static ArrayList<Clothes> getClothes() {
        return clothes;
    }

    public static void setClothes(ArrayList<Clothes> clothes) {
        Clothes.clothes = clothes;
    }

    public static HashMap<String, Clothes> getCombin() {
        return combin;
    }

    public static void setCombin(HashMap<String, Clothes> combin) {
        Clothes.combin = combin;
    }

    public static ArrayList<ArrayList<Bitmap>> getCombines() {
        return combines;
    }

    public static void setCombines(ArrayList<ArrayList<Bitmap>> combines) {
        Clothes.combines = combines;
    }
}
