package com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.Model.TypeMultipleChoice;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TypeMultipleChoiceAdapter extends RecyclerView.Adapter<TypeMultipleChoiceAdapter.TypeMultipleChoiceViewHolder> {
    Context context;
    List<TypeMultipleChoice> multipleChoiceList;

    public TypeMultipleChoiceAdapter() {
    }

    public TypeMultipleChoiceAdapter(Context context, List<TypeMultipleChoice> multipleChoiceList) {
        this.context = context;
        this.multipleChoiceList = multipleChoiceList;
    }

    @NonNull
    @NotNull
    @Override
    public TypeMultipleChoiceViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new TypeMultipleChoiceViewHolder(LayoutInflater.from(context).inflate(R.layout.type_multichoice_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TypeMultipleChoiceViewHolder holder, int position) {
        TypeMultipleChoice typeMultipleChoice = multipleChoiceList.get(position);

        holder.tvQuestionNum.setText(String.format("question %d", position + 1));
        holder.tvInfoQuestion.setText(typeMultipleChoice.getQuestion());
        holder.CauA.setText(typeMultipleChoice.getCauA());
        holder.CauB.setText(typeMultipleChoice.getCauB());
        holder.CauC.setText(typeMultipleChoice.getCauC());
        holder.CauD.setText(typeMultipleChoice.getCauD());

    }

    @Override
    public int getItemCount() {
        return multipleChoiceList.size();
    }

    public class TypeMultipleChoiceViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestionNum;
        TextView tvInfoQuestion;
        RadioGroup rdGroupChoose;
        RadioButton CauA, CauB, CauC, CauD;

        public TypeMultipleChoiceViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvQuestionNum = itemView.findViewById(R.id.tvQuestionNum);
            tvInfoQuestion = itemView.findViewById(R.id.tvInfoQuestion);
            rdGroupChoose = itemView.findViewById(R.id.rdGroupChoose);
            CauA = itemView.findViewById(R.id.rbCauA);
            CauB = itemView.findViewById(R.id.rbCauB);
            CauC = itemView.findViewById(R.id.rbCauC);
            CauD = itemView.findViewById(R.id.rbCauD);
        }
    }
}
