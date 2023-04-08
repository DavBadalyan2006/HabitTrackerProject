package com.example.habittracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.ViewHolder> {

    private List<Habit> mHabits;
    private Context mContext;

    public HabitAdapter(Context context, List<Habit> habits) {
        mContext = context;
        mHabits = habits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_habit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Habit habit = mHabits.get(position);
        holder.mTitleTextView.setText(habit.getTitle());
        holder.mDescriptionTextView.setText(habit.getDescription());
        holder.mFrequencyTextView.setText(mContext.getString(R.string.frequency_label, habit.getFrequency()));
        holder.mStreakTextView.setText(mContext.getString(R.string.streak_label, habit.getStreak()));
    }

    @Override
    public int getItemCount() {
        return mHabits.size();
    }

    public void setHabits(List<Habit> habits) {
        mHabits = habits;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        private TextView mFrequencyTextView;
        private TextView mStreakTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.habit_title);
            mDescriptionTextView = itemView.findViewById(R.id.habit_description);
            mFrequencyTextView = itemView.findViewById(R.id.habit_frequency);
            mStreakTextView = itemView.findViewById(R.id.habit_streak);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Habit habit = mHabits.get(position);
                        Intent intent = new Intent(mContext, HabitProgressActivity.class);
                        intent.putExtra(HabitProgressActivity.EXTRA_HABIT_ID, habit.getId());
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }
}
