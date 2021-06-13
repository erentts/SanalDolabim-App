package tr.edu.yildiz.erentutus;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tr.edu.yildiz.erentutus.dataaccess.database;
import tr.edu.yildiz.erentutus.entities.Clothes;

public class RecyclerCombines extends RecyclerView.Adapter<RecyclerCombines.MyViewHolder>{
    Context context;
    Integer choice;
    private database data;
    public RecyclerCombines(Context context,Integer choice) {
        this.context = context;
        this.choice = choice;
    }
    @NonNull
    @Override
    public RecyclerCombines.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.combinelist,parent,false);
        return new RecyclerCombines.MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerCombines.MyViewHolder holder, int position) {
        data = new database(context);
        holder.txtCombine.setText(position+1+". Combine");
        holder.thumbnails1.setImageBitmap(Clothes.combines.get(position).get(0));
        holder.thumbnails2.setImageBitmap(Clothes.combines.get(position).get(1));
        holder.thumbnails3.setImageBitmap(Clothes.combines.get(position).get(2));
        holder.thumbnails4.setImageBitmap(Clothes.combines.get(position).get(3));
        holder.thumbnails5.setImageBitmap(Clothes.combines.get(position).get(4));

        holder.btnDeletee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete")
                        .setMessage("Are you sure for deleting?")
                        .setNegativeButton("No", null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Clothes.combines.remove(position);
                                delete(position);
                                RecyclerCombines.super.notifyDataSetChanged();
                            }
                        })
                        .show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return Clothes.combines.size();
    }
    private void delete(Integer pos)
    {
        SQLiteDatabase db=data.getReadableDatabase();
        if(choice == 1){
            db.delete("Activity","combineId"+"=?",new String[]{Integer.toString(pos+1)});
        }
        db.delete("Combine","combineId"+"=?",new String[]{Integer.toString(pos+1)});
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtCombine;
        Button btnDeletee;
        ImageView thumbnails1,thumbnails2,thumbnails3,thumbnails4,thumbnails5;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            thumbnails1 = itemView.findViewById(R.id.thumbnails1);
            thumbnails2 = itemView.findViewById(R.id.thumbnails2);
            thumbnails3 = itemView.findViewById(R.id.thumbnails3);
            thumbnails4 = itemView.findViewById(R.id.thumbnails4);
            thumbnails5 = itemView.findViewById(R.id.thumbnails5);
            txtCombine = itemView.findViewById(R.id.txtCombine);
            btnDeletee = itemView.findViewById(R.id.btnDeletee);
        }
    }
}

