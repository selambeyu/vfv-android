package com.example.vfv1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vfv1.R;
import com.example.vfv1.data.model.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private Context context;
    private List<Article> list;

    public ArticleAdapter(Context context, List<Article> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_article, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = list.get(position);

        holder.textTitle.setText(article.getTitle());
        holder.author.setText(String.valueOf(article.getAuthor()));
        holder.content.setText(String.valueOf(article.getContent()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, author, content;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.article_title);
            author = itemView.findViewById(R.id.article_author);
            content = itemView.findViewById(R.id.artitle_content);
        }


    }



}
