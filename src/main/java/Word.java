public class Word {
    /*
    * 1.멤버 변수 설정/ 접근한정자 pubilc 같은거
    * 2.geter, setter
    * 3.생성자
    * 4. 멤버 매소드
    * */

    private String meaning;
    private String word;
    public Word(){};

    public Word(String meaning, String word) {
        this.meaning = meaning;
        this.word = word;
    }

    @Override
    public String toString() {
        return super.toString();
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
