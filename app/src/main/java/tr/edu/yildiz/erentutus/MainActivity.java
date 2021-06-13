package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import tr.edu.yildiz.erentutus.dataaccess.database;
import tr.edu.yildiz.erentutus.entities.Cabin;
import tr.edu.yildiz.erentutus.entities.Drawer;

public class MainActivity extends AppCompatActivity {
    Button btnAddDrawer,btnDrawers,btnClothes,btnAddActivity,btnCombineRoom,btnActivities;
    private database data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInputs();
        data = new database(this);

        btnAddDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = data.getWritableDatabase();
                ContentValues data = new ContentValues();
                Drawer drawer = new Drawer((Drawer.drawers.size()+1)+"",0);
                data.put("name",(Drawer.drawers.size()+1)+"");
                db.insertOrThrow("Drawer",null,data);
                Drawer.drawers.add(drawer);
                Toast.makeText(getApplicationContext(),"Drawer has been created !", Toast.LENGTH_SHORT).show();
            }
        });
        btnDrawers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawersScreen.class);
                startActivity(intent);
                finish();
            }
        });
        btnClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClothesScreen.class);
                startActivity(intent);
                finish();
            }
        });
        btnCombineRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CombineRoomScreen.class);
                startActivity(intent);
                finish();
            }
        });
        btnAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activities.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void getInputs(){
        btnDrawers = (Button) findViewById(R.id.btnDrawers);
        btnAddDrawer = (Button) findViewById(R.id.btnAddDrawer);
        btnClothes = (Button) findViewById(R.id.btnClothes);
        btnAddActivity = (Button) findViewById(R.id.btnAddActivity);
        btnCombineRoom = (Button) findViewById(R.id.btnCombineRoom);
        btnActivities = (Button) findViewById(R.id.btnActivities);
    }
}