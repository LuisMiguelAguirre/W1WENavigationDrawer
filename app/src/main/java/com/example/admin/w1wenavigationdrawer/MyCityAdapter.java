package com.example.admin.w1wenavigationdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 9/4/2017.
 */

public class MyCityAdapter extends RecyclerView.Adapter<MyCityAdapter.MyViewHolder> {

    private List<CityModel> objectList;
    private LayoutInflater inflater;

    public MyCityAdapter(Context context, List<CityModel> objectList) {
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_card_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CityModel current = objectList.get(position);
        holder.setData(current, position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgThumb;
        private int position;
        private CityModel currentObject;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgThumb    = (ImageView) itemView.findViewById(R.id.img_thumb);
        }

        public void setData(CityModel currentObject, int position) {
            this.imgThumb.setImageResource(currentObject.getImageID());
            this.position = position;
            this.currentObject = currentObject;
        }
    }



}
