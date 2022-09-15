package word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class CRUD implements ICRUDinterface {
    final String fname = "test.txt";
    Scanner s;
    ArrayList<Word>list;
    CRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }
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
        System.out.println("----------------------------------");
        for(int i = 0; i< list.size(); i++){
            System.out.print((i+1)+ "  ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("----------------------------------");
    }
    public int update(Object obj){
        return 0;
    };
    public int delete(Object obj){
        return 0;
    };
    public void selectOne(int id){

    };

    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count =0;
            while(true){
                line = br.readLine();
                if(line == null) break;
                // 다 읽어 오면 break;

                String data[]= line.split("\\|");
                //읽어온 한줄을 | 기준으로 구분 data[0] = 레벨, data[1] = 단어, data[2]= 의미가 들어갈것임
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[0];
                list.add(new Word(0,level, word, meaning));
                count++

             }
            System.out.println("=> " + count+ "개 단어 로딩 완료" );
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
