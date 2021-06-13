package tr.edu.yildiz.erentutus.entities;

import java.util.ArrayList;

public class Activity {
    private String name;
    private String type;
    private String date;
    private String location;
    public static ArrayList<Activity> activities = new ArrayList<>();

    public Activity(String name, String type, String date, String location) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static ArrayList<Activity> getActivities() {
        return activities;
    }

    public static void setActivities(ArrayList<Activity> activities) {
        Activity.activities = activities;
    }
}
