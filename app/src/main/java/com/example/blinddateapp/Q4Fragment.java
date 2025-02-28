package com.example.blinddateapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Q4Fragment extends Fragment {

    private Button next_button;
    private RadioGroup radioGroup;
    int x;
    FragmentListener fragmentListener;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;


    public Q4Fragment() {
        // Required empty public constructor
    }
    public static Q4Fragment newInstance(String param1, String param2) {
        Q4Fragment fragment = new Q4Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewgroup = (ViewGroup) inflater.inflate(R.layout.q4, container, false);
        next_button = (Button) viewgroup.findViewById(R.id.next_button);
        radioGroup = (RadioGroup) viewgroup.findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) viewgroup.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) viewgroup.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) viewgroup.findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) viewgroup.findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) viewgroup.findViewById(R.id.radioButton5);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton5:
                        x = 2;
                        break;
                    case R.id.radioButton4:
                        x = 1;
                        break;
                    case R.id.radioButton3:
                        x = 0;
                        break;
                    case R.id.radioButton2:
                        x = -1;
                        break;
                    case R.id.radioButton1:
                        x = -2;
                        break;
                }
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!radioButton1.isChecked() && !radioButton2.isChecked() && !radioButton3.isChecked()
                        && !radioButton4.isChecked() && !radioButton5.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
                    builder.setTitle("알림창").setMessage("버튼을 체크해주세요.");
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    fragmentListener.setQ4(x);
                    fragmentListener.nextQ4();
                }
            }
        });

        return viewgroup;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            fragmentListener = (FragmentListener) context; }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        if (fragmentListener != null) {
            fragmentListener = null; }
    }

}