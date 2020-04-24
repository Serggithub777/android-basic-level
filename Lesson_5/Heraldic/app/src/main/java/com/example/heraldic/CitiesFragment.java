package com.example.heraldic;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CitiesFragment extends Fragment {

    private static final String PARCEL = "PARCEL";
    private Parcel currentParcel; //текущая позиция (выбранный город)
    private boolean isExistCoatOfArms; //существует ли место для размещения герба (портрет или ландшафт)

    public CitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList((LinearLayout) view);
    }

    // activity создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super. onActivityCreated(savedInstanceState) ;
               // Определение, можно ли будет расположить рядом герб в другом  фрагменте
                isExistCoatOfArms = getResources() . getConfiguration() . orientation
                == Configuration. ORIENTATION_LANDSCAPE;
        // Если это не первое создание, то восстановим текущую позицию
        if (savedInstanceState != null) {
            // Восстановление текущей позиции.
            currentParcel = (Parcel) savedInstanceState. getSerializable("CurrentCity") ;
        }else
            currentParcel = new Parcel(0,getResources().getStringArray(R.array.cities)[0]);

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistCoatOfArms) {
            showCoatOfArms(currentParcel) ;
        }
    }
    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState. putSerializable("CurrentCity",currentParcel); ;
        super. onSaveInstanceState(outState) ;
    }
    private void initList(@NonNull LinearLayout view) {
        LinearLayout layoutView = view;
        String[] cities = getResources().getStringArray(R.array.cities);

        // В этом цикле создаем элемент TextView,
        // заполняем его значениями,
        // и добавляем на экран.
        // Кроме того, создаем обработку касания на элемент
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];

            TextView textView = new TextView(getContext());
            textView.setText(city);
            textView.setTextSize(30);
            layoutView.addView(textView);

            final int fi = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentParcel = new Parcel(fi, getResources().getStringArray(R.array.cities)[fi]);
                    showCoatOfArms(currentParcel);

                }
            });
        }
    }

    private void showCoatOfArms(Parcel parcel) {
        // Проверим, что фрагмент с гербом существует в activity
        if (isExistCoatOfArms) {
            CoatOfArmsFragment detail = (CoatOfArmsFragment)
                    getFragmentManager() . findFragmentById(R. id. coat_of_arms) ;
            if (detail == null || detail.getIndex() != parcel.getImageIndex()) {
// Создаем новый фрагмент с текущей позицией для вывода герба
                detail = CoatOfArmsFragment. create(parcel ) ;
// Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager() . beginTransaction() ;
                ft. replace(R. id. coat_of_arms, detail) ; // замена фрагмента
                ft. setTransition(FragmentTransaction. TRANSIT_FRAGMENT_FADE) ;
                ft. commit() ;
            }
        } else {
            // Если нельзя вывести герб рядом, откроем вторую activity
            Intent intent = new Intent() ;
            intent. setClass(getActivity() , CoatOfArmsActivity. class) ;
// и передадим туда параметры
            intent. putExtra(PARCEL, parcel) ;
            startActivity(intent) ;
            }
        }
    }


