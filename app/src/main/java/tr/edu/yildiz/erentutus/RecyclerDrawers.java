package tr.edu.yildiz.erentutus;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tr.edu.yildiz.erentutus.AddClothes;
import tr.edu.yildiz.erentutus.R;
import tr.edu.yildiz.erentutus.entities.Drawer;
import tr.edu.yildiz.erentutus.dataaccess.database;

public class RecyclerDrawers extends RecyclerView.Adapter<RecyclerDrawers.MyViewHolder>{


    Context context;
    private database data;
    public RecyclerDrawers(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawerlist,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDrawers.MyViewHolder holder, int position) {
        holder.btnDrawer.setText("Drawer : "+(position+1));
        data = new database(context);
        holder.btnAddClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddClothes.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete")
                        .setMessage("Are you sure for deleting?")
                        .setNegativeButton("No", null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                delete(position);
                                Drawer.drawers.remove(position);
                                RecyclerDrawers.super.notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Drawer.drawers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button btnDrawer,btnAddClothes,btnDelete;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            btnDrawer = itemView.findViewById(R.id.btnDrawer);
            btnAddClothes = itemView.findViewById(R.id.btnAddClothes);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
    private void delete(Integer pos)
    {
        SQLiteDatabase db=data.getReadableDatabase();
        db.delete("Clothes","drawerId"+"=?",new String[]{Integer.toString(pos+1)});
        db.delete("Drawer","drawerId"+"=?",new String[]{Integer.toString(pos+1)});
    }
}
