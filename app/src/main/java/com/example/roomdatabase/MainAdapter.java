package com.example.roomdatabase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
   //intialise variable
    private List<MainData> dataList;
    private Activity context ;
    private RoomDb database;

    //create    constructer

    public MainAdapter(Activity context, List<MainData> dataList){
     this.context = context;
     this.dataList = dataList;
     notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //intialise view

        View view  = LayoutInflater.from(parent.getContext()) .inflate(R.layout.list_row_main,parent);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        //intialsie main data

     MainData data = dataList.get(position);
     //intialise databse
        database = RoomDb.getInstance(context);
        //set text on text view
        holder.textview.setText(data.getText());
        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intialise main data
                MainData d = dataList.get(holder.getAdapterPosition());
                //get did
                final int sId = d.getID();
                //get text
                String sText = d.getText();

                //create dialogue
                final Dialog dialog = new Dialog(context);
                //set content view
                dialog.setContentView(R.layout.dialog_update);
                //intialise width
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                //intialise height
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                //intialise LAYOUT
                dialog.getWindow().setLayout(width, height);
                //show dialog
                dialog.show();

                //intialise and assign variables
                final EditText editText = dialog.findViewById(R.id.edit_text);
                EditText btUpdate = dialog.findViewById(R.id.bt_update);

                //set text on edit data
                editText.setText(sText);
                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Dismm dialog
                        dialog.dismiss();
                        //get upadte text from edit text
                        String uText = editText.getText().toString().trim();
                        //UPDATE text in db




                    }
                });
            }

        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       //intialise varable
        TextView textview;
        ImageView btEdit, btDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //assign varable
            textview =  itemView.findViewById(R.id.text_view);
            btEdit = itemView.findViewById(R.id.btn_edit);
            btDelete = itemView.findViewById(R.id.btn_delete);
        }
    }


}
