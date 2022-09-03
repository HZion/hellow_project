package word;

public class Word {
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /*
    * 1.멤버 변수 설정/ 접근한정자 pubilc 같은거
    * 2.geter, setter
    * 3.생성자
    * 4. 멤버 매소드
    * */
    private int level;
    private String meaning;
    private String word;
    public Word(){};

    public Word(int level, String word, String meaning) {
        this.level = level;
        this.meaning = meaning;
        this.word = word;
    }

    @Override
    public String toString() {
        String printLevel = "";
        for(int i = 0; i< level ; i++)
            printLevel += "*";

        String str = String.format("%-3s",printLevel) + String.format("%10s",word) + "   " + meaning;
        return str;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


}
