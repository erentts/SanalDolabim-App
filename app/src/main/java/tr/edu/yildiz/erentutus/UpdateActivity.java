package tr.edu.yildiz.erentutus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tr.edu.yildiz.erentutus.entities.Activity;

public class UpdateActivity extends AppCompatActivity {
    EditText txtUpdateName,txtUpdateDate,txtUpdateLocation,txtUpdateType;
    Button btnUpdateAct,btnBackActt;
    Integer position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);
        getInputs();
        getInformation();

        btnUpdateAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity.activities.get(position).setName(txtUpdateName.getText().toString());
                Activity.activities.get(position).setName(txtUpdateType.getText().toString());
                Activity.activities.get(position).setName(txtUpdateDate.getText().toString());
                Activity.activities.get(position).setName(txtUpdateLocation.getText().toString());
            }
        });

        btnBackActt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, Activities.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getInputs(){
        txtUpdateName = findViewById(R.id.txtUpdateName);
        txtUpdateDate = findViewById(R.id.txtUpdateDate);
        txtUpdateLocation = findViewById(R.id.txtUpdateLocation);
        txtUpdateType = findViewById(R.id.txtUpdateType);
        btnUpdateAct = findViewById(R.id.btnUpdateAct);
        btnBackActt = findViewById(R.id.btnBackActt);
    }
    public void getInformation(){
        txtUpdateName.setText(Activity.activities.get(position).getName());
        txtUpdateDate.setText(Activity.activities.get(position).getDate());
        txtUpdateLocation.setText(Activity.activities.get(position).getLocation());
        txtUpdateType.setText(Activity.activities.get(position).getType());
    }
}