package com.hitcyclone317.projectAndroidCuoiKhoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {
    Context context;
    List<String> subjects;

    public SubjectAdapter(Context context, List<String> subjects) {
        this.context = context;
        this.subjects = subjects;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSubject;
        private ImageView IVBooks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            IVBooks = itemView.findViewById(R.id.books);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.subject_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String subject = subjects.get(position);
        holder.tvSubject.setText(subject);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}
