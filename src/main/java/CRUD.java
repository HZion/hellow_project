import java.util.ArrayList;
import java.util.Scanner;
public class CRUD implements ICRUDinterface {

    Scanner s;
    ArrayList<Word>list;

    @Override
    public Object Creat() {
        System.out.println("=>난이도(1,2,3) & 새 단어 입력");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.println("뜻 입력: ");
        String mean = s.nextLine();
        return new Word(level, word, mean);
    };
    public void addWord(){
        Word New = (Word)Creat();
        list.add(New);
        System.out.println("새로운 단어가 추가 되었습니다.");

    }
    public void viewList(){

    }
    public int update(Object obj){
        return 0;
    };
    public int delete(Object obj){
        return 0;
    };
    public void selectOne(int id){

    };

}
