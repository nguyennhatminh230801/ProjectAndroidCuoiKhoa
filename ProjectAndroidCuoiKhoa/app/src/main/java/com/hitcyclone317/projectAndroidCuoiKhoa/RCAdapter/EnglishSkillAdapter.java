package com.hitcyclone317.projectAndroidCuoiKhoa.RCAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.ChildClickInterface;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.EnglishSkill;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;
import com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter.LessonUnitActivity;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnglishSkillAdapter extends RecyclerView.Adapter<EnglishSkillAdapter.ESViewHolder> {
    Context context;
    List<EnglishSkill> englishSkillList;
    RecyclerViewOnClickItem recyclerViewOnClickItem;
    ChildClickInterface ChildOnClickItem;

    public EnglishSkillAdapter(Context context, List<EnglishSkill> englishSkillList, RecyclerViewOnClickItem recyclerViewOnClickItem, ChildClickInterface childOnClickItem) {
        this.context = context;
        this.englishSkillList = englishSkillList;
        this.recyclerViewOnClickItem = recyclerViewOnClickItem;
        ChildOnClickItem = childOnClickItem;
    }

    @NonNull
    @NotNull
    @Override
    public ESViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ESViewHolder(LayoutInflater.from(context).inflate(R.layout.english_skill_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ESViewHolder holder, int position) {
        EnglishSkill englishSkill = englishSkillList.get(position);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        holder.EngSkillName.setText(englishSkill.getEnglishSkillName());

        EnglishTaskAdapter englishTaskAdapter;

        englishTaskAdapter = new EnglishTaskAdapter(context, englishSkill.getTaskOfEngLishSkill(), new RecyclerViewOnClickItem() {
            @Override
            public void OnClickItem(int position1) {
                ChildOnClickItem.onChildClickInterface(position, position1);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setInitialPrefetchItemCount(englishSkill.getTaskOfEngLishSkill().size());

        holder.RCEnglishTask.setLayoutManager(linearLayoutManager);
        holder.RCEnglishTask.setAdapter(englishTaskAdapter);
        holder.RCEnglishTask.setRecycledViewPool(recycledViewPool);

        boolean isExpanded = englishSkill.isVisible();

        holder.ExpandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return englishSkillList.size();
    }

    public class ESViewHolder extends RecyclerView.ViewHolder {
        private TextView EngSkillName;
        private RecyclerView RCEnglishTask;
        private RelativeLayout ExpandableLayout;

        public ESViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            EngSkillName = itemView.findViewById(R.id.EngSkillName);
            RCEnglishTask = itemView.findViewById(R.id.RCEnglishTask);
            ExpandableLayout = itemView.findViewById(R.id.ExpandableLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewOnClickItem.OnClickItem(getAdapterPosition());
                }
            });

        }
    }
}
