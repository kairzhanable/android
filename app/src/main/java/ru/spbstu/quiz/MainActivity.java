package ru.spbstu.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton btnAns1;
    ToggleButton btnAns2;
    ToggleButton btnAns3;
    Button btnNext;
    Button btnPrev;
    private Test myTest;
    TextView questText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAns1 = findViewById(R.id.btnAns1);
        btnAns1.setOnClickListener(oclAns1);

        btnAns2 = findViewById(R.id.btnAns2);
        btnAns2.setOnClickListener(oclAns2);

        btnAns3 = findViewById(R.id.btnAns3);
        btnAns3.setOnClickListener(oclAns3);

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(oclNext);

        btnPrev = findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(oclPrev);
        btnPrev.setEnabled(false);

        Question quest1 = new Question("Вы сдадите экзамен у Орлова С.Г.?",
                new Answer("Нет"),
                new Answer("Конечно же нет"),
                new Answer("Куда уж мне..."));

        Question quest2 = new Question("Аска или Рей?",
                new Answer("Аска"),
                new Answer("Рей"),
                new Answer("Кто?"));

        Question quest3 = new Question("Рита выпустит БКРР в этом году?",
                new Answer("Нет конечно!"),
                new Answer("Это же Рита"),
                new Answer("Мне хватает Бесконечного Лета"));

        myTest = new Test(quest1, quest2, quest3);
        questText = findViewById(R.id.question);
        refreshTexts ();
    }

    private void refreshTexts () {
        switch (myTest.currentQuest.getPrevAns()) {
            case 1:
                btnAns1.setChecked(true);
                btnAns2.setChecked(false);
                btnAns3.setChecked(false);
                break;
            case 2:
                btnAns1.setChecked(false);
                btnAns2.setChecked(true);
                btnAns3.setChecked(false);
                break;
            case 3:
                btnAns1.setChecked(false);
                btnAns2.setChecked(false);
                btnAns3.setChecked(true);
                break;
            default:
                btnAns1.setChecked(false);
                btnAns2.setChecked(false);
                btnAns3.setChecked(false);
        }
        questText.setText(myTest.currentQuest.question);
        btnAns1.setText(myTest.currentQuest.ans1.answer);
        btnAns2.setText(myTest.currentQuest.ans2.answer);
        btnAns3.setText(myTest.currentQuest.ans3.answer);
    }

    /*
    private void disableAnsButtons(int btnNum) {
        switch (btnNum) {
            case 1:
                btnAns2.setChecked(false);
                btnAns3.setChecked(false);
                break;
            case 2:
                btnAns1.setChecked(false);
                btnAns3.setChecked(false);
                break;
            case 3:
                btnAns1.setChecked(false);
                btnAns2.setChecked(false);
                break;
        }
    }
    */

    OnClickListener oclAns1 = new OnClickListener() {
        @Override
        public void onClick(View v) {
            myTest.currentQuest.chooseAns(1);
            refreshTexts ();
        }
    };

    OnClickListener oclAns2 = new OnClickListener() {
        @Override
        public void onClick(View v) {
            myTest.currentQuest.chooseAns(2);
            refreshTexts ();
        }
    };

    OnClickListener oclAns3 = new OnClickListener() {
        @Override
        public void onClick(View v) {
            myTest.currentQuest.chooseAns(3);
            refreshTexts ();
        }
    };

    OnClickListener oclNext = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int qNum = myTest.nextQuest();
            refreshTexts ();
            switch (qNum) {
                case 1:
                    btnPrev.setEnabled(false);
                    btnNext.setText("Дальше");
                    break;
                case 2:
                    btnPrev.setEnabled(true);
                    btnNext.setText("Дальше");
                    break;
                case 3:
                    btnPrev.setEnabled(true);
                    btnNext.setText("Финиш");
                    break;
                case 4:
                    // TODO вывести статистику
                    Intent intent = new Intent(MainActivity.this, Statistics.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };

    OnClickListener oclPrev = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int qNum = myTest.prevQuest();
            refreshTexts ();
            switch (qNum) {
                case 3:
                    btnNext.setText("Финиш");
                    break;
                case 2:
                    btnNext.setText("Дальше");
                    break;
                case 1:
                    btnPrev.setEnabled(false);
                    btnNext.setText("Дальше");
                    break;
            }
        }
    };
}