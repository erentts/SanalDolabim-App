package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tr.edu.yildiz.erentutus.dataaccess.database;
import tr.edu.yildiz.erentutus.entities.Activity;

public class AddActivity extends AppCompatActivity {
    EditText txtActivityName,txtActivityDate,txtActivityLocation,txtActivityType;
    String name,date,location,type,price;
    Button btnSaveActivity,btnBackAct;
    private RecyclerView Recycler;
    private RecyclerCombines adapter;
    private database data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

        getInputs();
        adapter.notifyDataSetChanged();
        data = new database(this);

        btnSaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformation();
                SQLiteDatabase db = data.getWritableDatabase();
                ContentValues data = new ContentValues();
                Activity activities = new Activity(name,type,date,location);
                data.put("name",name);
                data.put("type",type);
                data.put("date",date);
                data.put("location",location);
                db.insertOrThrow("Activity",null,data);
                Activity.activities.add(activities);
                Toast.makeText(getApplicationContext(),"Activity has been created !", Toast.LENGTH_SHORT).show();
            }
        });
        btnBackAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getInputs(){
        txtActivityName = findViewById(R.id.txtActivityName);
        txtActivityDate = findViewById(R.id.txtActivityDate);
        txtActivityLocation = findViewById(R.id.txtActivityLocation);
        txtActivityType = findViewById(R.id.txtActivityType);
        btnSaveActivity = findViewById(R.id.btnSaveActivity);
        btnBackAct = findViewById(R.id.btnBackAct);
        Recycler = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerCombines(AddActivity.this,1);
        Recycler.setAdapter(adapter);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
    }
    public void getInformation(){
        name = txtActivityName.getText().toString();
        date = txtActivityDate.getText().toString();
        location = txtActivityLocation.getText().toString();
        type = txtActivityType.getText().toString();
    }
}