package com.example.rockpaperscissors;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PlayFragment extends Fragment {

    final int PLAY_TIME = 60;
    TextView timerTextView;
    TextView handTextView;
    public PlayFragment() {
        // Required empty public constructor
    }

    public static PlayFragment newInstance() {
        return new PlayFragment();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        timerTextView = view.findViewById(R.id.timer_text);
        handTextView =  view.findViewById(R.id.hand_text);
        handTextView.setText("3");
        timerTextView.setText("60");
        new CountDownThree(3000,1000).start();
        return view;
    }

    private class CountDownThree extends CountDownTimer {

        public CountDownThree(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int currentTime = (int) Math.ceil((double) millisUntilFinished / 1000);
            handTextView.setText(Integer.toString(currentTime));
        }

        @Override
        public void onFinish() {
            // 画面遷移させる
            handTextView.setText("");
            MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
            MainActivity.fragmentTransaction.remove(getParentFragmentManager().findFragmentById(R.id.fragment_container));
            MainActivity.fragmentTransaction
                    .add(R.id.fragment_container, RockPaperScissorsFragment.newInstance());
            MainActivity.fragmentTransaction.commit();
        }
    }
}