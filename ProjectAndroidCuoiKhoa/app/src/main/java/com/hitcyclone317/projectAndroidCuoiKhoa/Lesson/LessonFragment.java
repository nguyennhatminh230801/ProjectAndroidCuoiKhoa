package com.hitcyclone317.projectAndroidCuoiKhoa.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.FragmentMenu.ContestFragment;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.Lesson;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RCAdapter.LessonAdapter;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;
import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

import java.util.ArrayList;
import java.util.List;

public class LessonFragment extends Fragment {
    RecyclerView RCLesson;
    List<Lesson> lessons;
    LessonAdapter lessonAdapter;
    View root;

    public static LessonFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LessonFragment fragment = new LessonFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_lesson, container, false);

        RCLesson = root.findViewById(R.id.RCLesson);

        lessons = new ArrayList<>();

        lessons.add(new Lesson(R.drawable.ic_lesson, "Unit 1: Approaching to IT", 37, false, StateOfStudy.PASSED));
        lessons.add(new Lesson(R.drawable.ic_test, "Unit Test 1", 0, true, StateOfStudy.FAILED));
        lessons.add(new Lesson(R.drawable.ic_lesson, "Unit 2: Inside the computer", 44, false, StateOfStudy.HAS_NOT_LEARNED));
        lessons.add(new Lesson(R.drawable.ic_test, "Unit Test 2", 0, true, StateOfStudy.NOT_IN_USE));
        lessons.add(new Lesson(R.drawable.ic_lesson, "Unit 3: Input and output devices", 39, false, StateOfStudy.HAS_NOT_LEARNED));
        lessons.add(new Lesson(R.drawable.ic_test, "Unit Test 3", 0, true, StateOfStudy.NOT_IN_USE));

        lessonAdapter = new LessonAdapter(container.getContext(), lessons, new RecyclerViewOnClickItem() {
            @Override
            public void OnClickItem(int position) {
                if(lessons.get(position).getStateOfStudy() == StateOfStudy.NOT_IN_USE){
                    if(lessons.get(position).isTestOfLesson()){
                        Toast.makeText(container.getContext(), "Bạn Phải Hoàn Thành Bài Học Hiện Tại Trước Làm Test", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(container.getContext(), "Bạn Phải Hoàn Thành Bài Học Trước Mới Mở Bài Sau ", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    if(!lessons.get(position).isTestOfLesson())
                    {
                        getParentFragmentManager().beginTransaction()
                                .replace(container.getId(), new EnglishSkillFragment())
                                .addToBackStack(null)
                                .commit();
                    }

                }
            }
        });

        RCLesson.setAdapter(lessonAdapter);
        RCLesson.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return root;
    }
}
