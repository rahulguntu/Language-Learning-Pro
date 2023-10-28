package com.example.languagelearningpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder> {

    private List<Exercise> exercises;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public ExerciseListAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_exercise, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.exerciseTitle.setText(exercise.getTitle());

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
        return exercises.size();
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        public TextView exerciseTitle;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
            exerciseTitle = itemView.findViewById(R.id.exerciseTitle);
        }
    }
}
