package com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.Model.TypeFillInfo;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TypeFillInfoAdapter extends RecyclerView.Adapter<TypeFillInfoAdapter.TypeFillInfoViewHolder> {
    Context context;
    List<TypeFillInfo> typeFillInfoList;

    public TypeFillInfoAdapter() {
    }

    public TypeFillInfoAdapter(Context context, List<TypeFillInfo> typeFillInfoList) {
        this.context = context;
        this.typeFillInfoList = typeFillInfoList;
    }

    @NonNull
    @NotNull
    @Override
    public TypeFillInfoViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new TypeFillInfoViewHolder(LayoutInflater.from(context).inflate(R.layout.type_fill_info_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TypeFillInfoViewHolder holder, int position) {
        TypeFillInfo typeFillInfo = typeFillInfoList.get(position);

        holder.tvQuestionNum1.setText(String.format("question %d", position + 1));
        holder.tvInfoQuestion1.setText(typeFillInfo.getQuestion());
    }

    @Override
    public int getItemCount() {
        return typeFillInfoList.size();
    }

    public class TypeFillInfoViewHolder extends RecyclerView.ViewHolder{
        TextView tvQuestionNum1, tvInfoQuestion1;
        EditText edtTypeAnswer;

        public TypeFillInfoViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvQuestionNum1 = itemView.findViewById(R.id.tvQuestionNum1);
            tvInfoQuestion1 = itemView.findViewById(R.id.tvInfoQuestion1);
            edtTypeAnswer = itemView.findViewById(R.id.edtTypeAnswer);
        }
    }
}
