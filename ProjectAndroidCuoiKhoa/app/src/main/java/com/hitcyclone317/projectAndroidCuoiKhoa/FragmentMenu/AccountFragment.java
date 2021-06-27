package com.hitcyclone317.projectAndroidCuoiKhoa.FragmentMenu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hitcyclone317.projectAndroidCuoiKhoa.ImageConvert;
import com.hitcyclone317.projectAndroidCuoiKhoa.R;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountFragment extends Fragment {
    private TextView tvMsv, tvName, tvGender, tvSdt,
            tvAddr, tvDate, tvMail;
    CircleImageView circleImageView;
    public static AccountFragment newInstance() {
        Bundle args = new Bundle();
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account, container, false);

        circleImageView = root.findViewById(R.id.imageView);
        tvMsv = root.findViewById(R.id.tv_msv);
        tvName = root.findViewById(R.id.tv_name);
        tvGender = root.findViewById(R.id.tv_gender);
        tvSdt = root.findViewById(R.id.tv_sdt);
        tvAddr = root.findViewById(R.id.tv_addr);
        tvDate = root.findViewById(R.id.tv_date);
        tvMail = root.findViewById(R.id.tv_mail);

        tvMsv.setText("123");
        tvName.setText("123");
        tvGender.setText("123");
        tvSdt.setText("123");
        tvAddr.setText("123");
        tvDate.setText("123");
        tvMail.setText("123");

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img);
        Bitmap circularBitmap = ImageConvert.getRoundedCornerBitmap(bitmap, 100);

        circleImageView.setImageBitmap(circularBitmap);
        return root;
    }

}
