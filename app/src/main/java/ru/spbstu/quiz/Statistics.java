package ru.spbstu.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    TextView q1,a11,a12,a13,q2,a21,a22,a23,q3,a31,a32,a33;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        btnRestart = findViewById(R.id.restart);
        btnRestart.setOnClickListener(oclRestart);

        Test MyTest = Test.INSTANCE;

        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);

        q1.setText("[?] " + MyTest.quest1.question);
        q2.setText("[?] " + MyTest.quest2.question);
        q3.setText("[?] " + MyTest.quest3.question);

        a11 = findViewById(R.id.a11);
        a12 = findViewById(R.id.a12);
        a13 = findViewById(R.id.a13);
        a21 = findViewById(R.id.a21);
        a22 = findViewById(R.id.a22);
        a23 = findViewById(R.id.a23);
        a31 = findViewById(R.id.a31);
        a32 = findViewById(R.id.a32);
        a33 = findViewById(R.id.a33);

        a11.setText("[!] " + "[" + MyTest.quest1.ans1.counter + "] " + MyTest.quest1.ans1.answer);
        a12.setText("[!] " + "[" + MyTest.quest1.ans2.counter + "] " + MyTest.quest1.ans2.answer);
        a13.setText("[!] " + "[" + MyTest.quest1.ans3.counter + "] " + MyTest.quest1.ans3.answer);
        a21.setText("[!] " + "[" + MyTest.quest2.ans1.counter + "] " + MyTest.quest2.ans1.answer);
        a22.setText("[!] " + "[" + MyTest.quest2.ans2.counter + "] " + MyTest.quest2.ans2.answer);
        a23.setText("[!] " + "[" + MyTest.quest2.ans3.counter + "] " + MyTest.quest2.ans3.answer);
        a31.setText("[!] " + "[" + MyTest.quest3.ans1.counter + "] " + MyTest.quest3.ans1.answer);
        a32.setText("[!] " + "[" + MyTest.quest3.ans2.counter + "] " + MyTest.quest3.ans2.answer);
        a33.setText("[!] " + "[" + MyTest.quest3.ans3.counter + "] " + MyTest.quest3.ans3.answer);
    }

    View.OnClickListener oclRestart = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Statistics.this, MainActivity.class); // запиливаем новое активити
            startActivity(intent);
            finish();// убиваем старое активити
        }
    };
}
