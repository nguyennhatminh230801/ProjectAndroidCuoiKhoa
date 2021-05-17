package com.hitcyclone317.projectAndroidCuoiKhoa.FragmentMenu;


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

import com.hitcyclone317.projectAndroidCuoiKhoa.Lesson.LessonFragment;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.Subject;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RCAdapter.SubjectAdapter;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;
import com.hitcyclone317.projectAndroidCuoiKhoa.StateOfStudy;

import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {
    RecyclerView RCSubject;
    List<Subject> subjects;
    SubjectAdapter subjectAdapter;
    View root;

    public static LearningFragment newInstance() {
        Bundle args = new Bundle();

        LearningFragment fragment = new LearningFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public void GetMappingItem()
    {
        RCSubject = root.findViewById(R.id.RCSubject);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_learning, container, false);
        GetMappingItem();

        subjects = new ArrayList<>();

        //Xử thêm thông tin ở đây
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 1", StateOfStudy.PASSED));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 2", StateOfStudy.FAILED));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 3", StateOfStudy.PASSED));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 4", StateOfStudy.PASSED));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 5", StateOfStudy.NOT_IN_USE));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 6", StateOfStudy.NOT_IN_USE));

        subjectAdapter = new SubjectAdapter(container.getContext(), subjects, new RecyclerViewOnClickItem() {
            @Override
            public void OnClickItem(int position) {
                if(subjects.get(position).getStateOfStudy() != StateOfStudy.NOT_IN_USE)
                {
                    getParentFragmentManager().beginTransaction()
                            .replace(container.getId(), new LessonFragment())
                            .addToBackStack(null)
                            .commit();
                }
                else
                {
                    Toast.makeText(container.getContext(), "Học Phần Này Bạn Chưa Đăng Ký", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RCSubject.setAdapter(subjectAdapter);
        RCSubject.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return root;
    }


}
