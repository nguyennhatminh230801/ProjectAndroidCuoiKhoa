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


public class ContestFragment extends Fragment {
    public static ContestFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ContestFragment fragment = new ContestFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contest, container, false);
        TextView textView = root.findViewById(R.id.text_contest);
        textView.setText("This is contest fragment");
        return root;
    }
}
