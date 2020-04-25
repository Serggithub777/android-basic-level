package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private TextView textViewSmsBody;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewSecondFragment =inflater.inflate(R.layout.fragment_second, container, false);
        textViewSmsBody = viewSecondFragment.findViewById(R.id.textViewSmsBody);

        return viewSecondFragment;
    }

    public void setTextSmsBody(String bodySms) {
        textViewSmsBody.setText(bodySms);
    }
}
