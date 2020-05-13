package com.example.createfragmentcat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray;
    //имя для аргумента
    public static final String BUTTON_INDEX = "button_index";
    //значение по умолчанию
    private static  final int BUTTON_INDEX_DEFAULT = -1;


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment2, container, false);
        mInfoTextView = rootView.findViewById(R.id.textViewDesc);
        mCatImageView = rootView.findViewById(R.id.imageView);
        //загружаем массив из ресурсоов
        mCatDescriptionArray = getResources().getStringArray(R.array.cats);

        Bundle args = getArguments();
        int buttonIndex = args != null ? args.getInt(BUTTON_INDEX, BUTTON_INDEX_DEFAULT) : BUTTON_INDEX_DEFAULT;
        if (buttonIndex != BUTTON_INDEX_DEFAULT) {
            setDescription(buttonIndex);
        }
        return rootView;
        }

    public void setDescription(int buttonIndex) {
        String catDescription = mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescription);
        switch (buttonIndex) {
            case 1:
                mCatImageView.setImageResource(R.drawable.red_cat);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.grey_cat);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.white_cat);

        }
    }

    }

