package com.example.createfragmentcat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    private View.OnClickListener buttonsListener;

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment1, container, false);

        Button button1 = rootView.findViewById(R.id.button1);
        Button button2 = rootView.findViewById(R.id.button2);
        Button button3 = rootView.findViewById(R.id.button3);

        createButtonListener();

        button1.setOnClickListener(buttonsListener);
        button2.setOnClickListener(buttonsListener);
        button3.setOnClickListener(buttonsListener);
        return rootView;
    }

     private void createButtonListener() {
        buttonsListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int buttonIndex = translateIdToIndex(v.getId());
                Toast.makeText(getActivity(),String.valueOf(buttonIndex) , Toast.LENGTH_SHORT).show();
                OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                listener.onButtonSelected(buttonIndex);
            }
        };
    }

    int translateIdToIndex(int id) {
        int index=-1;
        switch (id) {
            case R.id.button1:
                index=1;
                break;
            case R.id.button2:
                index = 2;
                break;
            case R.id.button3:
                index = 3;
                break;
        }
        return index;
    }

}