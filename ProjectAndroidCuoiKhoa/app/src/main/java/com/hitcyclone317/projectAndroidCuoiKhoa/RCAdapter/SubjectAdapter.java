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

import com.hitcyclone317.projectAndroidCuoiKhoa.Model.Subject;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;
import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {
    Context context;
    List<Subject> subjects;
    RecyclerViewOnClickItem recyclerViewOnClickItem;

    public SubjectAdapter(Context context, List<Subject> subjects, RecyclerViewOnClickItem recyclerViewOnClickItem) {
        this.context = context;
        this.subjects = subjects;
        this.recyclerViewOnClickItem = recyclerViewOnClickItem;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSubject;
        private ImageView IVBooks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            IVBooks = itemView.findViewById(R.id.books);

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
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.subject_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Subject subject = subjects.get(position);
        holder.tvSubject.setText(subject.getSubjects());
        holder.IVBooks.setImageResource(subject.getResid());

        if(subject.getStateOfStudy() == StateOfStudy.PASSED){
            holder.IVBooks.setColorFilter(Color.parseColor("#008000"));
        }

        if(subject.getStateOfStudy() == StateOfStudy.FAILED){
            holder.IVBooks.setColorFilter(Color.parseColor("#FF0000"));
        }
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}
