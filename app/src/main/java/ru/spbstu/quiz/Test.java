package ru.spbstu.quiz;

public class Test {
    Question quest1;
    Question quest2;
    Question quest3;
    Question currentQuest;

    public Test (Question aQuest1, Question aQuest2, Question aQuest3){
        quest1 = aQuest1;
        quest2 = aQuest2;
        quest3 = aQuest3;
        currentQuest = quest1;
    }

    public int nextQuest () {
        if (currentQuest == quest1) {
            currentQuest = quest2;
            return 2;
        }
        else if (currentQuest == quest2) {
            currentQuest = quest3;
            return 3;
        }
        else if (currentQuest == quest3){
            return 4;
            //TODO прописать логику при последнем вопросе
        }
        else {
            return 0;
        }
    }

    public int prevQuest () {
        if (currentQuest == quest3) {
            currentQuest = quest2;
            return 2;
        }
        else if (currentQuest == quest2) {
            currentQuest = quest1;
            return 1;
        }
        else {
            return 3;
            //TODO прописать логику при последнем вопросе
        }
    }
}
