package com.hitcyclone317.projectAndroidCuoiKhoa.RCAdapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.Model.Lesson;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;
import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {
    Context context;
    List<Lesson> lessons;
    RecyclerViewOnClickItem recyclerViewOnClickItem;

    public LessonAdapter(Context context, List<Lesson> lessons, RecyclerViewOnClickItem recyclerViewOnClickItem) {
        this.context = context;
        this.lessons = lessons;
        this.recyclerViewOnClickItem = recyclerViewOnClickItem;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView IVLesson;
        private TextView tvLesson, tvCountTask;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IVLesson = itemView.findViewById(R.id.IVlesson);
            tvLesson = itemView.findViewById(R.id.tvLesson);
            tvCountTask = itemView.findViewById(R.id.tvCountTask);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewOnClickItem.OnClickItem(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.lesson_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);

        holder.IVLesson.setImageResource(lesson.getResID());
        holder.tvLesson.setText(lesson.getLessonName());

        if(!lesson.isTestOfLesson())
        {
            holder.tvCountTask.setText(String.format("%d Tasks", lesson.getNumOfTask()));
        }
        else
        {
            holder.tvCountTask.setText(null);
        }

        if(lesson.getStateOfStudy() == StateOfStudy.PASSED){
            holder.IVLesson.setColorFilter(Color.parseColor("#008000"));
        }

        if(lesson.getStateOfStudy() == StateOfStudy.FAILED){
            holder.IVLesson.setColorFilter(Color.parseColor("#FF0000"));
        }
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

}
