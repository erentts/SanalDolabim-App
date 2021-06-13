package tr.edu.yildiz.erentutus.dataaccess;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    private static final String android = "connection";
    private static final int SURUM = 1;
    public database(Context c){
        super(c, android,null,SURUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Drawer (drawerId INTEGER PRIMARY KEY AUTOINCREMENT, name Text);");
        db.execSQL("CREATE TABLE Clothes (clothesId INTEGER PRIMARY KEY AUTOINCREMENT,type Text, color Text, pattern Text, boughtDate Text, price Text, thumbnail Blob, drawerId Integer," +
                "FOREIGN KEY(drawerId) REFERENCES Drawer(drawerId));");
        db.execSQL("CREATE TABLE Combine (combineId INTEGER PRIMARY KEY AUTOINCREMENT,thumbnail1 Blob,thumbnail2 Blob,thumbnail3 Blob,thumbnail4 Blob,thumbnail5 Blob);");
        db.execSQL("CREATE TABLE Activity (activityId INTEGER PRIMARY KEY AUTOINCREMENT,name Text,type Text,date Text,location Text,combineId Integer," +
                "FOREIGN KEY(combineId) REFERENCES Combine(combineId));");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Drawer");
        db.execSQL("DROP TABLE IF EXISTS Clothes");
        db.execSQL("DROP TABLE IF EXISTS Combine");
        db.execSQL("DROP TABLE IF EXISTS Activity");
        onCreate(db);
    }
}
