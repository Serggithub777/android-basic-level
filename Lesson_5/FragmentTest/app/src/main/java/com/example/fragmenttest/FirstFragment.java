package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private EditText editTextEnterSms;
    private Button buttonGoSms;
    private View.OnClickListener buttonGoSmsListener;

    interface onSelectedButtonListener {
        void onButtonSelected(String bodySms);
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFirstFragment = inflater.inflate(R.layout.fragment_first, container, false);

        editTextEnterSms = viewFirstFragment.findViewById(R.id.editTextEnterSMS);
        buttonGoSms = viewFirstFragment.findViewById(R.id.buttonSend);

        createButtonGoSmsListener();
        buttonGoSms.setOnClickListener(buttonGoSmsListener);


        return viewFirstFragment;
    }

    private void createButtonGoSmsListener() {
        buttonGoSmsListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snsBody = editTextEnterSms.getText().toString();
                onSelectedButtonListener listener = (onSelectedButtonListener) getActivity();
                listener.onButtonSelected(snsBody);
            }
        };
    }
}
