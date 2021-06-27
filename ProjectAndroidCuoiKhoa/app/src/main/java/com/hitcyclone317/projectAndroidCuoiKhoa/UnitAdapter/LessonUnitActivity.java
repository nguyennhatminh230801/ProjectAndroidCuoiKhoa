package com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hitcyclone317.projectAndroidCuoiKhoa.R;

public class LessonUnitActivity extends AppCompatActivity {
    TextView tvNameOfTask;
    RecyclerView RCAnswerForm;
    AppCompatButton btnSubmit, btnSeeAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_unit);

        getSupportActionBar().hide();

        getMappingItem();
        AddData();
    }

    private void AddData() {

    }

    private void getMappingItem() {
        tvNameOfTask = findViewById(R.id.tvNameOfTask);
        RCAnswerForm = findViewById(R.id.RCAnswerForm);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSeeAnswer = findViewById(R.id.btnSeeAnswer);
    }
}