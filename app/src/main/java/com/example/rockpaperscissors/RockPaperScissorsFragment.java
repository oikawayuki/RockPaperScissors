package com.example.rockpaperscissors;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RockPaperScissorsFragment extends Fragment {

    int score = 0;
    String[] hand = {"グー","チョキ","パー"};
    Random rnd = new Random();
    TextView timerTextView;
    TextView handTextView;
    Bundle bundle;
    public RockPaperScissorsFragment() {
        // Required empty public constructor
    }
    public static RockPaperScissorsFragment newInstance() {
        return new RockPaperScissorsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rock_paper_scissors, container, false);
        timerTextView = view.findViewById(R.id.timer_text_rpc);
        handTextView = view.findViewById(R.id.hand_text_rpc);
        new CountDownSixty(60000,1000).start();
        Button rockButton = view.findViewById(R.id.button_rock);
        Button scissorsButton = view.findViewById(R.id.button_scissors);
        Button paperButton = view.findViewById(R.id.button_paper);
        // グーの処理
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handTextView.getText().equals("チョキ")) {
                    score++;
                }
                // 次の手を生成
                handTextView.setText(hand[rnd.nextInt(3)]);
            }
        });
        // チョキの処理
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handTextView.getText().equals("パー")) {
                    score++;
                }
                // 次の手を生成
                handTextView.setText(hand[rnd.nextInt(3)]);
            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handTextView.getText().equals("グー")) {
                    score++;
                }
                // 次の手を生成
                handTextView.setText(hand[rnd.nextInt(3)]);
            }
        });
        return view;
    }

    private class CountDownSixty extends CountDownTimer {

        public CountDownSixty(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int currentTime = (int) Math.ceil((double) millisUntilFinished / 1000);
            timerTextView.setText(Integer.toString(currentTime));
        }

        @Override
        public void onFinish() {
            MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
            MainActivity.fragmentTransaction
                    .replace(R.id.fragment_container, ResultFragment.newInstance(score));
            MainActivity.fragmentTransaction.commit();
        }
    }
}