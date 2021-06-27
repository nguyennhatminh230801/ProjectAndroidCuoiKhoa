package com.hitcyclone317.projectAndroidCuoiKhoa.Lesson;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.ChildClickInterface;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.EnglishSkill;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.EnglishTask;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RCAdapter.EnglishSkillAdapter;

import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;
import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;
import com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter.LessonUnitActivity;

import java.util.ArrayList;
import java.util.List;

public class EnglishSkillFragment<englishSkillAdapter> extends Fragment {
    View root;
    List<EnglishSkill> englishSkillList;
    EnglishSkillAdapter englishSkillAdapter;
    RecyclerView RCEnglishSkill;

    public static EnglishSkillFragment newInstance() {

        Bundle args = new Bundle();

        EnglishSkillFragment fragment = new EnglishSkillFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void AddData()
    {
        englishSkillList = new ArrayList<>();

        List<EnglishTask> Vocabulary, Grammar, Listening, Reading, Writing;
        Vocabulary = new ArrayList<>();

        Vocabulary.add(new EnglishTask(R.drawable.ic_english_task,"Presentation 1", StateOfStudy.PASSED));
        Vocabulary.add(new EnglishTask(R.drawable.ic_english_task,"Presentation 2", StateOfStudy.PASSED));
        Vocabulary.add(new EnglishTask(R.drawable.ic_english_task,"Task 1", StateOfStudy.HAS_NOT_LEARNED));
        Vocabulary.add( new EnglishTask(R.drawable.ic_english_task,"Task 2", StateOfStudy.HAS_NOT_LEARNED));
        Vocabulary.add(new EnglishTask(R.drawable.ic_english_task,"Task 3", StateOfStudy.HAS_NOT_LEARNED));
        Vocabulary.add(new EnglishTask(R.drawable.ic_english_task,"Task 4", StateOfStudy.HAS_NOT_LEARNED));

        englishSkillList.add(new EnglishSkill("Vocabulary", Vocabulary, false));

        Grammar = new ArrayList<>();

        Grammar.add(new EnglishTask(R.drawable.ic_english_task, "Task 1", StateOfStudy.PASSED));
        Grammar.add(new EnglishTask(R.drawable.ic_english_task, "Task 2", StateOfStudy.PASSED));
        Grammar.add(new EnglishTask(R.drawable.ic_english_task, "Task 3", StateOfStudy.PASSED));
        Grammar.add(new EnglishTask(R.drawable.ic_english_task, "Task 4", StateOfStudy.HAS_NOT_LEARNED));
        Grammar.add(new EnglishTask(R.drawable.ic_english_task, "Task 5", StateOfStudy.HAS_NOT_LEARNED));
        Grammar.add(new EnglishTask(R.drawable.ic_english_task, "Task 6", StateOfStudy.HAS_NOT_LEARNED));


        englishSkillList.add(new EnglishSkill("Grammar", Grammar, false));

        Listening = new ArrayList<>();

        Listening.add(new EnglishTask(R.drawable.ic_english_task, "Task 1", StateOfStudy.PASSED));
        Listening.add(new EnglishTask(R.drawable.ic_english_task, "Task 2", StateOfStudy.PASSED));
        Listening.add(new EnglishTask(R.drawable.ic_english_task, "Task 3", StateOfStudy.PASSED));
        Listening.add(new EnglishTask(R.drawable.ic_english_task, "Task 4", StateOfStudy.HAS_NOT_LEARNED));
        Listening.add(new EnglishTask(R.drawable.ic_english_task, "Task 5", StateOfStudy.HAS_NOT_LEARNED));
        Listening.add(new EnglishTask(R.drawable.ic_english_task, "Task 6", StateOfStudy.HAS_NOT_LEARNED));

        englishSkillList.add(new EnglishSkill("Listening", Listening, false));

        Reading = new ArrayList<>();

        Reading.add(new EnglishTask(R.drawable.ic_english_task, "Task 1", StateOfStudy.PASSED));
        Reading.add(new EnglishTask(R.drawable.ic_english_task, "Task 2", StateOfStudy.PASSED));
        Reading.add(new EnglishTask(R.drawable.ic_english_task, "Task 3", StateOfStudy.PASSED));
        Reading.add(new EnglishTask(R.drawable.ic_english_task, "Task 4", StateOfStudy.HAS_NOT_LEARNED));
        Reading.add(new EnglishTask(R.drawable.ic_english_task, "Task 5", StateOfStudy.HAS_NOT_LEARNED));
        Reading.add(new EnglishTask(R.drawable.ic_english_task, "Task 6", StateOfStudy.HAS_NOT_LEARNED));

        englishSkillList.add(new EnglishSkill("Reading", Reading, false));

        Writing = new ArrayList<>();

        Writing.add(new EnglishTask(R.drawable.ic_english_task, "Task 1", StateOfStudy.PASSED));
        Writing.add(new EnglishTask(R.drawable.ic_english_task, "Task 2", StateOfStudy.PASSED));
        Writing.add(new EnglishTask(R.drawable.ic_english_task, "Task 3", StateOfStudy.PASSED));
        Writing.add(new EnglishTask(R.drawable.ic_english_task, "Task 4", StateOfStudy.HAS_NOT_LEARNED));
        Writing.add(new EnglishTask(R.drawable.ic_english_task, "Task 5", StateOfStudy.HAS_NOT_LEARNED));
        Writing.add(new EnglishTask(R.drawable.ic_english_task, "Task 6", StateOfStudy.HAS_NOT_LEARNED));

        englishSkillList.add(new EnglishSkill("Writing", Writing, false));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_english_skill, container, false);

        RCEnglishSkill = root.findViewById(R.id.RCEnglishSkill);

        AddData();

        assert container != null;
        englishSkillAdapter = new EnglishSkillAdapter(container.getContext(), englishSkillList, position -> {
            EnglishSkill englishSkill = englishSkillList.get(position);
            englishSkill.setVisible(!englishSkill.isVisible());
            englishSkillAdapter.notifyItemChanged(position);

        }, (ParentAdapterPosition, ChildAdapterPosition) -> {
            Intent intent = new Intent(container.getContext(), LessonUnitActivity.class);

            String res1 = englishSkillList.get(ParentAdapterPosition).getEnglishSkillName();
            String res2 = englishSkillList.get(ParentAdapterPosition).getTaskOfEngLishSkill().get(ChildAdapterPosition).getNameOfTask();

            intent.putExtra("EngSkill", res1);
            intent.putExtra("Engtask", res2);

            startActivity(intent);

//            Toast.makeText(container.getContext(), String.valueOf(ParentAdapterPosition)
//                    + " " + String.valueOf(ChildAdapterPosition), Toast.LENGTH_SHORT).show();
        }
        );

        RCEnglishSkill.setAdapter(englishSkillAdapter);
        RCEnglishSkill.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return root;
    }
}
