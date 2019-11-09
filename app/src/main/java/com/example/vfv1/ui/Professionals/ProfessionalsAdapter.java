package com.example.vfv1.ui.Professionals;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vfv1.R;
import com.example.vfv1.data.model.Course;
import com.example.vfv1.ui.training.TrainingAdapter;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ProfessionalsAdapter extends RecyclerView.Adapter<ProfessionalsAdapter.MyViewHolder> {
    private Context mContext;
    private List<Course> movieList;

    public ProfessionalsAdapter(Context mContext, List<Course> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public ProfessionalsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProfessionalsAdapter.MyViewHolder holder, int position) {
        Course movie = movieList.get(position);

    }

    @Override
    public int getItemCount() {
        return (movieList != null) ? movieList.size() : 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView movieTitle, movieGenre, movieRating;
        public ImageView moviePoster;

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
