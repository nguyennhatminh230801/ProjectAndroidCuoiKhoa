package com.hitcyclone317.projectAndroidCuoiKhoa.UnitAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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

import java.util.List;

public class LessonUnitActivity extends AppCompatActivity {
    TextView tvNameOfTask;
    RecyclerView RCAnswerForm;
    AppCompatButton btnSubmit, btnSeeAnswer;
    List<TypeVocabulary> typeVocabularyList;
    List<TypeFillInfo> typeFillInfoList;
    List<TypeMultipleChoice> multipleChoiceList;

    TypeVocabularyAdapter typeVocabularyAdapter;
    String URL = "https://raw.githubusercontent.com/vippes13/ProjectAndroidCuoiKhoa/main/fill_info.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_unit);

        getSupportActionBar().hide();
        getMappingItem();

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        TypeVocabulary typeVocabulary = new TypeVocabulary(
                                jsonObject.getString("voca_code"),
                                jsonObject.getString("audio_link"),
                                jsonObject.getString("image_link"),
                                jsonObject.getString("vocabulary"),
                                jsonObject.getString("description")
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

            }
        });

        queue.add(jsonArrayRequest);

        btnSubmit.setOnClickListener(v -> {

        });

        btnSeeAnswer.setOnClickListener(v -> {

        });
    }


    private void getMappingItem() {
        tvNameOfTask = findViewById(R.id.tvNameOfTask);
        RCAnswerForm = findViewById(R.id.RCAnswerForm);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSeeAnswer = findViewById(R.id.btnSeeAnswer);
    }
}