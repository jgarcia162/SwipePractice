package com.example.jose.swipepractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CardView cardView;
    private ViewGroup parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = (CardView) findViewById(R.id.card);
        parent = (ViewGroup) findViewById(R.id.card_parent_layout);
        SwipeCallback callback = createSwipeCallback();
        SwipeListener listener = new SwipeListener(cardView, callback, parent, parent.getPaddingLeft(), parent.getPaddingTop(), 15f, 0f);
        cardView.setOnTouchListener(listener);
    }

    public SwipeCallback createSwipeCallback() {
        return new SwipeCallback() {
            @Override
            public void cardSwipedLeft(View card) {
                Toast.makeText(MainActivity.this, "LEFT!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardSwipedRight(View card) {
                Toast.makeText(MainActivity.this, "RIGHT!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardOffScreen(View card) {

            }

            @Override
            public boolean isDragEnabled() {
                return true;
            }
        };
    }
}
