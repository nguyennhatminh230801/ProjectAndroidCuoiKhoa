package com.hitcyclone317.projectAndroidCuoiKhoa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.annotation.SuppressLint;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class DangNhap extends AppCompatActivity {
    TextInputLayout TaiKhoan, MatKhau;
    AppCompatButton btnLogin, btnForgetPass;
    AppCompatCheckBox LuuMatKhau;
    TextView tvTaiKhoan, tvMatKhau;
    String username, password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    AlertDialog.Builder SuccessLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        Objects.requireNonNull(getSupportActionBar()).hide();

        InitSharePreferences();
        getMappingItem();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "ResourceType"})
            @Override
            public void onClick(View v) {
                username = Objects.requireNonNull(TaiKhoan.getEditText()).getText().toString();
                password = Objects.requireNonNull(MatKhau.getEditText()).getText().toString();

                String tempUsername1 = "vippes13";
                String tempPassword1 = "123456";

                if(username.equals(tempUsername1) && password.equals(tempPassword1)){
                    if(LuuMatKhau.isChecked()){
                        editor.putString("Username", tempUsername1);
                        editor.putString("Password", tempPassword1);
                        editor.commit();
                    }

                    SuccessLogin = new AlertDialog.Builder(getBaseContext());
                    SuccessLogin.setTitle("Thông báo");
                    SuccessLogin.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent2 = new Intent(DangNhap.this, GiaoDienChinh.class);
                            startActivity(intent2);
                        }
                    });
                    SuccessLogin.create();
                    SuccessLogin.show();
                }
                else {
                    if(!username.equals(tempUsername1)){
                        tvTaiKhoan.setText(R.string.ten_dang_nhap_bi_sai);
                        tvTaiKhoan.setTextColor(R.color.red);
                    }

                    if(username.equals(tempUsername1)){
                        tvTaiKhoan.setText(R.string.nhap_vao_msv);
                        tvTaiKhoan.setTextColor(R.color.black);
                    }

                    if(!password.equals(tempPassword1)){
                        tvMatKhau.setText(R.string.mat_khau_bi_sai);
                        tvMatKhau.setTextColor(R.color.red);
                    }

                    if(password.equals(tempPassword1)){
                        tvMatKhau.setText(R.string.nhap_vao_mk);
                        tvMatKhau.setText(R.color.black);
                    }
                }
            }
        });

        btnForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getMappingItem() {
        TaiKhoan = findViewById(R.id.ten_tai_khoan);
        MatKhau = findViewById(R.id.mat_khau);
        btnLogin = findViewById(R.id.btnLogin);
        btnForgetPass = findViewById(R.id.btnForgetPassword);
        LuuMatKhau = findViewById(R.id.luu_mat_khau);
        tvTaiKhoan = findViewById(R.id.nhap_vao_tai_khoan);
        tvMatKhau = findViewById(R.id.nhap_vao_mat_khau);
    }

    @SuppressLint("CommitPrefEdits")
    private void InitSharePreferences() {
        sharedPreferences = getSharedPreferences("AccountFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

}
