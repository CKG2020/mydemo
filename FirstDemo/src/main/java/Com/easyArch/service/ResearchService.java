package Com.easyArch.service;

public interface ResearchService {
    int count = 0;
    int finishcount=0;
    int scores = 0;
    int addscore(int score);

    String usedTime(String time);


    String submitScores();

}
