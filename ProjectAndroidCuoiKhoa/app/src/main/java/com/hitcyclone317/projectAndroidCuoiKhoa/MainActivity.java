package com.hitcyclone317.projectAndroidCuoiKhoa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView RCSubject;
    List<String> subjects;
    SubjectAdapter subjectAdapter;
    ImageButton ImgBtnMenu, ImgBtnUser;

    public void GetMappingItem()
    {
        RCSubject = findViewById(R.id.RCSubject);
        ImgBtnMenu = findViewById(R.id.ImgBtnMenu);
        ImgBtnUser = findViewById(R.id.ImgBtnUser);
    }

    public void AddAndPushItemToRecycleView()
    {
        subjects = new ArrayList<>();

        subjects.add("Tiếng Anh Công Nghệ Thông Tin 1");
        subjects.add("Tiếng Anh Công Nghệ Thông Tin 2");
        subjects.add("Tiếng Anh Công Nghệ Thông Tin 3");
        subjects.add("Tiếng Anh Công Nghệ Thông Tin 4");
        subjects.add("Tiếng Anh Công Nghệ Thông Tin 5");
        subjects.add("Tiếng Anh Công Nghệ Thông Tin 6");

        subjectAdapter = new SubjectAdapter(MainActivity.this, subjects);
        RCSubject.setAdapter(subjectAdapter);
        RCSubject.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    public void getFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentShow, fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        GetMappingItem();
        AddAndPushItemToRecycleView();

        ImgBtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(MenuFragement.newInstance());
            }
        });

        ImgBtnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(UserFragment.newInstance());
            }
        });
    }


}