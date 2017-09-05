package com.example.admin.w1wenavigationdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Admin on 9/4/2017.
 */

public class MyObjectAdapter extends RecyclerView.Adapter<MyObjectAdapter.MyViewHolder> {

    private List<ObjectModel> objectList;
    private LayoutInflater inflater;

    public MyObjectAdapter(Context context, List<ObjectModel> objectList) {
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_card_view_2, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ObjectModel current = objectList.get(position);
        holder.setData(current, position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgThumb;
        private int position;
        private ObjectModel currentObject;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgThumb    = (ImageView) itemView.findViewById(R.id.img_thumb);
        }

        public void setData(ObjectModel currentObject, int position) {
            this.imgThumb.setImageResource(currentObject.getImageID());
            this.position = position;
            this.currentObject = currentObject;
        }
    }



}
