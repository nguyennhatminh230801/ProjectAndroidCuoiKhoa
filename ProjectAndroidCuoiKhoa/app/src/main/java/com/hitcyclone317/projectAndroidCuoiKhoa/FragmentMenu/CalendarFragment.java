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

public class CalendarFragment extends Fragment {
    public static CalendarFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CalendarFragment fragment = new CalendarFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);
        TextView textView = root.findViewById(R.id.text_calendar);
        textView.setText("This is calendar fragment");
        return root;
    }
}
