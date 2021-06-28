package com.hitcyclone317.projectAndroidCuoiKhoa.RCAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.Model.EnglishTask;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;
import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnglishTaskAdapter extends RecyclerView.Adapter<EnglishTaskAdapter.ETViewHolder> {
    Context context;
    List<EnglishTask> englishTaskList;
    RecyclerViewOnClickItem recyclerViewOnClickItem;

    public EnglishTaskAdapter(Context context, List<EnglishTask> englishTaskList, RecyclerViewOnClickItem recyclerViewOnClickItem) {
        this.context = context;
        this.englishTaskList = englishTaskList;
        this.recyclerViewOnClickItem = recyclerViewOnClickItem;
    }

    @NonNull
    @NotNull
    @Override
    public ETViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ETViewHolder(LayoutInflater.from(context).inflate(R.layout.english_task_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ETViewHolder holder, int position) {
        EnglishTask englishTask = englishTaskList.get(position);

        holder.ImgViewEngTask.setImageResource(englishTask.getResID());
        holder.tvEngTask.setText(englishTask.getNameOfTask());

        if(englishTask.getStateOfStudy() == StateOfStudy.PASSED){
            holder.ImgViewEngTask.setColorFilter(Color.parseColor("#008000"));
            holder.tvEngTask.setTextColor(Color.parseColor("#008000"));
        }

        if(englishTask.getStateOfStudy() == StateOfStudy.FAILED){
            holder.ImgViewEngTask.setColorFilter(Color.parseColor("#FF0000"));
            holder.tvEngTask.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    @Override
    public int getItemCount() {
        return englishTaskList.size();
    }

    public class ETViewHolder extends RecyclerView.ViewHolder{
        private ImageView ImgViewEngTask;
        private TextView tvEngTask;

        public ETViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ImgViewEngTask = itemView.findViewById(R.id.ImgViewEngTask);
            tvEngTask = itemView.findViewById(R.id.tvEngTask);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewOnClickItem.OnClickItem(getAdapterPosition());
                }
            });
        }

    }
}
