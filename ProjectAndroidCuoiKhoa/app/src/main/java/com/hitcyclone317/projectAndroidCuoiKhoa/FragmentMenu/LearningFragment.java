package com.hitcyclone317.projectAndroidCuoiKhoa.FragmentMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hitcyclone317.projectAndroidCuoiKhoa.Model.Subject;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;
import com.hitcyclone317.projectAndroidCuoiKhoa.RCAdapter.SubjectAdapter;
import com.hitcyclone317.projectAndroidCuoiKhoa.RecyclerViewOnClickItem;

import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {
    RecyclerView RCSubject;
    List<Subject> subjects;
    SubjectAdapter subjectAdapter;
    View root;
    
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

        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 1"));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 2"));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 3"));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 4"));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 5"));
        subjects.add(new Subject(R.drawable.ic_book,"Tiếng Anh Công Nghệ Thông Tin 6"));

        subjectAdapter = new SubjectAdapter(container.getContext(), subjects);
        RCSubject.setAdapter(subjectAdapter);
        RCSubject.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return root;
    }

}
