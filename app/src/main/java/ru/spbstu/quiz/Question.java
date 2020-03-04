package ru.spbstu.quiz;

public class Question {

    public String question;
    public Answer ans1;
    public Answer ans2;
    public Answer ans3;
    public Answer chosenAns;

    public Question(String aQuestion, Answer aAns1, Answer aAns2, Answer aAns3) {
        question = aQuestion;
        ans1 = aAns1;
        ans2 = aAns2;
        ans3 = aAns3;
    }

    public void chooseAns (int aAnsNum) {
        switch (aAnsNum) {
            case 1:
                chosenAns = ans1;
                break;
            case 2:
                chosenAns = ans2;
                break;
            case 3:
                chosenAns = ans3;
                break;
        }
    }

    public int getPrevAns () {
        if (ans1.equals(chosenAns)) {
            return 1;
        } else if (ans2.equals(chosenAns)) {
            return 2;
        } else if (ans3.equals(chosenAns)) {
            return 3;
        }

        return 0;
    }
}
