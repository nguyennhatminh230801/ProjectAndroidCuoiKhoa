package com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.TypeVocabulary;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class TypeVocabularyAdapter extends RecyclerView.Adapter<TypeVocabularyAdapter.TypeVocabViewHolder> {
    Context context;
    List<TypeVocabulary> typeVocabularyList;

    public TypeVocabularyAdapter()
    {

    }
    public TypeVocabularyAdapter(Context context, List<TypeVocabulary> typeVocabularyList) {
        this.context = context;
        this.typeVocabularyList = typeVocabularyList;
    }

    @NonNull
    @NotNull
    @Override
    public TypeVocabViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new TypeVocabViewHolder(LayoutInflater.from(context).inflate(R.layout.type_vocabulary_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TypeVocabViewHolder holder, int position) {
        TypeVocabulary typeVocabulary = typeVocabularyList.get(position);

        holder.btnPlayAudio.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
        holder.tvVocabularyTitle.setText(typeVocabulary.getTitle());
        Glide.with(holder.itemView).load(typeVocabulary.getImageLink()).into(holder.IVVocabItem);
        holder.tvVietnameseTrans.setText(typeVocabulary.getVietnameseTrans());
        holder.tvVocab.setText(typeVocabulary.getDescription());

        holder.btnPlayAudio.setOnClickListener(v -> {
            MediaPlayer mediaPlayer = new MediaPlayer();

            try {
                mediaPlayer.setDataSource(typeVocabulary.getAudioLink());
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mediaPlayer.start();
        });
    }

    @Override
    public int getItemCount() {
        return typeVocabularyList.size();
    }

    public class TypeVocabViewHolder extends RecyclerView.ViewHolder{
        ImageButton btnPlayAudio;
        TextView tvVocabularyTitle;
        ImageView IVVocabItem;
        TextView tvVietnameseTrans;
        TextView tvVocab;

        public TypeVocabViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            btnPlayAudio = itemView.findViewById(R.id.btnPlayAudio);
            tvVocabularyTitle = itemView.findViewById(R.id.tvVocabularyTitle);
            IVVocabItem = itemView.findViewById(R.id.IVVocabItem);
            tvVietnameseTrans = itemView.findViewById(R.id.tvVietnameseTrans);
            tvVocab = itemView.findViewById(R.id.tvVocab);
        }
    }
}
