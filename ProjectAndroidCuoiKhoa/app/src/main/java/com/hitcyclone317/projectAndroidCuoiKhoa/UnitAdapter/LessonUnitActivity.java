package com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.TypeFillInfo;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.TypeMultipleChoice;
import com.hitcyclone317.projectAndroidCuoiKhoa.Model.TypeVocabulary;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.Random;

public class LessonUnitActivity extends AppCompatActivity {
    TextView tvNameOfTask;
    RecyclerView RCAnswerForm;
    AppCompatButton btnSubmit, btnSeeAnswer;
    List<TypeVocabulary> typeVocabularyList;
    List<TypeFillInfo> typeFillInfoList;
    List<TypeMultipleChoice> multipleChoiceList;
    RequestQueue queue;
    TypeVocabularyAdapter typeVocabularyAdapter;
    TypeMultipleChoiceAdapter typeMultipleChoiceAdapter;
    TypeFillInfoAdapter typeFillInfoAdapter;
    JsonArrayRequest jsonArrayRequest;
    static int test1 = 0;

    String URL = "https://raw.githubusercontent.com/vippes13/ProjectAndroidCuoiKhoa/main/vocabulary.json";
    String URL1 = "https://raw.githubusercontent.com/vippes13/ProjectAndroidCuoiKhoa/main/multichoice.json";
    String URL2 = "https://raw.githubusercontent.com/vippes13/ProjectAndroidCuoiKhoa/main/fill_info.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_unit);

        getSupportActionBar().hide();
        getMappingItem();

        typeVocabularyList = new ArrayList<>();
        typeFillInfoList = new ArrayList<>();
        multipleChoiceList = new ArrayList<>();

        queue = Volley.newRequestQueue(this);

        Vocabulary();

        //MultipleChoice();

        //FillInfo();
    }

    private void FillInfo() {
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        TypeFillInfo typeFillInfo = new TypeFillInfo(
                                jsonObject.getString("Question"),
                                jsonObject.getString("Answer")
                        );

                        typeFillInfoList.add(typeFillInfo);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                typeFillInfoAdapter = new TypeFillInfoAdapter(LessonUnitActivity.this, typeFillInfoList);
                RCAnswerForm.setAdapter(typeFillInfoAdapter);
                RCAnswerForm.setLayoutManager(new LinearLayoutManager(LessonUnitActivity.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        btnSubmit.setOnClickListener(v -> {
            typeFillInfoList.clear();
            OnSuccess();
        });

        queue.add(jsonArrayRequest);
    }

    private void getMappingItem() {
        tvNameOfTask = findViewById(R.id.tvNameOfTask);
        RCAnswerForm = findViewById(R.id.RCAnswerForm);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSeeAnswer = findViewById(R.id.btnSeeAnswer);
    }

    private void Vocabulary(){
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        TypeVocabulary typeVocabulary = new TypeVocabulary(
                                jsonObject.getString("Title"),
                                jsonObject.getString("AudioLink"),
                                jsonObject.getString("ImageLink"),
                                jsonObject.getString("VietnamTrans"),
                                jsonObject.getString("Description")
                        );

                        typeVocabularyList.add(typeVocabulary);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                typeVocabularyAdapter = new TypeVocabularyAdapter(LessonUnitActivity.this, typeVocabularyList);

                RCAnswerForm.setAdapter(typeVocabularyAdapter);
                RCAnswerForm.setLayoutManager(new LinearLayoutManager(LessonUnitActivity.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        btnSubmit.setOnClickListener(v -> {
            typeVocabularyList.clear();
            OnSuccess();
        });

        btnSeeAnswer.setOnClickListener(v -> Toast.makeText(getBaseContext(), "Tính năng này ko hỗ trợ cho bài từ vựng", Toast.LENGTH_SHORT).show());

        queue.add(jsonArrayRequest);
    }

    private void MultipleChoice() {
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        TypeMultipleChoice typeMultipleChoice = new TypeMultipleChoice(
                                jsonObject.getString("Question"),
                                jsonObject.getString("CauA"),
                                jsonObject.getString("CauB"),
                                jsonObject.getString("CauC"),
                                jsonObject.getString("CauD"),
                                jsonObject.getInt("Answer")
                        );

                        multipleChoiceList.add(typeMultipleChoice);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                typeMultipleChoiceAdapter = new TypeMultipleChoiceAdapter(LessonUnitActivity.this, multipleChoiceList);

                RCAnswerForm.setAdapter(typeMultipleChoiceAdapter);
                RCAnswerForm.setLayoutManager(new LinearLayoutManager(LessonUnitActivity.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(jsonArrayRequest);

        btnSubmit.setOnClickListener(view -> {
            multipleChoiceList.clear();
            OnSuccess();
        });
    }

    private void OnSuccess(){
        RCAnswerForm.setAdapter(null);

        int random = new Random().nextInt(2);
        MediaPlayer mediaPlayer;
        if(random % 2 == 0){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.success0);
        }
        else{
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.success1);
        }
        mediaPlayer.start();


        if(test1 % 3 == 0){
            test1++;
            test1 %= 3;
            MultipleChoice();
        }
        else if(test1 % 3 == 1){
            test1++;
            test1 %= 3;
            FillInfo();
        }
        else {
            test1++;
            test1 %= 3;
            Vocabulary();
        }
    }


}