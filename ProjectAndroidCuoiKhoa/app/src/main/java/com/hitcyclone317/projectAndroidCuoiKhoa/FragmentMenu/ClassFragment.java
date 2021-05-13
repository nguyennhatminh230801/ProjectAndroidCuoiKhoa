package com.hitcyclone317.projectAndroidCuoiKhoa.FragmentMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hitcyclone317.projectAndroidCuoiKhoa.R;

public class ClassFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_class, container, false);
        TextView textView = root.findViewById(R.id.text_fragment_class);
        textView.setText("This is class fragment");
        return root;
    }
}
