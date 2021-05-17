package com.hitcyclone317.projectAndroidCuoiKhoa.FragmentMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hitcyclone317.projectAndroidCuoiKhoa.R;

public class HomeFragment extends Fragment {
    public static HomeFragment newInstance() {
        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //TextView textView = root.findViewById(R.id.text_home);
        //textView.setText("This is home fragment");
        return root;
    }
}