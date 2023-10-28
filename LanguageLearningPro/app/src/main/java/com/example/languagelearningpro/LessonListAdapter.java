package com.example.languagelearningpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LessonListAdapter extends RecyclerView.Adapter<LessonListAdapter.LessonViewHolder> {

    private List<Lesson> lessons;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public LessonListAdapter(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_lesson, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        holder.lessonTitle.setText(lesson.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public static class LessonViewHolder extends RecyclerView.ViewHolder {
        public TextView lessonTitle;

        public LessonViewHolder(View itemView) {
            super(itemView);
            lessonTitle = itemView.findViewById(R.id.lessonTitle);
        }
    }
}
