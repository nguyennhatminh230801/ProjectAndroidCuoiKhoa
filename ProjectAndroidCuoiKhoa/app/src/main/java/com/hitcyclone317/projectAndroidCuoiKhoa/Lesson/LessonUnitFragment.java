package com.hitcyclone317.projectAndroidCuoiKhoa.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hitcyclone317.projectAndroidCuoiKhoa.R;

import org.jetbrains.annotations.NotNull;

public class LessonUnitFragment extends Fragment {
    View root;

    public static LessonUnitFragment newInstance() {

        Bundle args = new Bundle();

        LessonUnitFragment fragment = new LessonUnitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_lesson_unit, container, false);


        return root;
    }
}
