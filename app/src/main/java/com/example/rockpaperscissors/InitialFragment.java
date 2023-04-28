package com.example.rockpaperscissors;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InitialFragment extends Fragment {

    View view;
    public InitialFragment() {
        // Required empty public constructor
    }


    public static InitialFragment newInstance() {
        return new InitialFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_initial, container, false);
        Button button = (Button) view.findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
                MainActivity.fragmentTransaction
                        .replace(R.id.fragment_container, PlayFragment.newInstance());
                MainActivity.fragmentTransaction.commit();
            }
        });
        return view;
    }
}