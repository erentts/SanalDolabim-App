package tr.edu.yildiz.erentutus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tr.edu.yildiz.erentutus.entities.Activity;
import tr.edu.yildiz.erentutus.entities.Clothes;

public class RecyclerActivity extends RecyclerView.Adapter<RecyclerActivity.MyViewHolder>{
    Context context;

    public RecyclerActivity(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerActivity.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activitylist,parent,false);
        return new RecyclerActivity.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerActivity.MyViewHolder holder, int position) {
        holder.btnActivityInformation.setText("Activity : "+(position+1));
        holder.btnActivityInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Activity information")
                        .setMessage("Type: "+ Activity.activities.get(position).getType()+"\nName: "+
                                Activity.activities.get(position).getName()+"\nDate: "+
                                Activity.activities.get(position).getDate()+"\nLocation: "+
                                Activity.activities.get(position).getLocation())
                        .setNegativeButton("Back", null)
                        .show();
            }
        });

        holder.btnActivityUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

        holder.btnActivityDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity.activities.remove(position);
                RecyclerActivity.super.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Activity.activities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button btnActivityInformation,btnActivityUpdate,btnActivityDelete;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            btnActivityInformation = itemView.findViewById(R.id.btnActivityInformation);
            btnActivityUpdate = itemView.findViewById(R.id.btnActivityUpdate);
            btnActivityDelete = itemView.findViewById(R.id.btnActivityDelete);
        }
    }
}

