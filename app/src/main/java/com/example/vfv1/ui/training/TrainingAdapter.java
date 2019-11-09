package com.example.vfv1.ui.training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vfv1.R;
import com.example.vfv1.data.model.Course;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.MyViewHolder> {

    private Context mContext;
    private List<Course> departement;

    public TrainingAdapter(Context mContext, List<Course> departementList) {
        this.mContext = mContext;
        this.departement = departementList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Course department = departement.get(position);

    }

    @Override
    public int getItemCount() {
        return (departement != null) ? departement.size() : 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView Backend, Frontend, Mobile;
        public ImageView MyCompany;

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
