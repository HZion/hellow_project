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
        return new Word(0,level, word, mean);
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
    public ArrayList<Integer> viewList(String input){
        ArrayList<Integer> idlist = new ArrayList<>();
        int index = 0;
        System.out.println("----------------------------------");
        for(int i = 0; i < list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(input)) continue;

            System.out.print(index+1 + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            index++;
        }
        return idlist;
    }
    public  void viewList(int inputLevel){
        int index = 0;
        System.out.println("----------------------------------");

        for(int i = 0; i < list.size(); i++){
            int templevel = list.get(i).getLevel();
            if(templevel != inputLevel) continue;

            System.out.print( (index+1) + " ");
            System.out.println(list.get(i).toString());
            index++;
        }
    }
    public int update(Object obj){
        return 0;
    };
    public int delete(Object obj){
        return 0;
    };
    public void selectOne(int id){

    };

    public void loadFile() {
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
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;

             }
            System.out.println("=> " + count+ "개 단어 로딩 완료" );
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for(Word one: list){

                pr.write(one.toFilewriteString() + "\n");
            }
            pr.close();
            System.out.println("저장완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void updateWord() {
        System.out.print("=> 수정할 단어검색:");
        String input = s.next();
        ArrayList<Integer> idlist = this.viewList(input); // 검색할 단어가 포함된 위치 저장 및 출력

        System.out.print("=> 수정할 번호 입력");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 뜻입력");
        String updateMeaning = s.nextLine();

        Word word = list.get(idlist.get(id-1));

         word.setMeaning(updateMeaning);// list.get을통해 해당 단어의 뜻을 바꿈
        System.out.println("단어가 변경 되었습니다.");



    }

    public void deleteWord() {
        System.out.print("=> 삭제할 단어 검색");
        String input = s.next();
        ArrayList<Integer>idlist= this.viewList(input);

        System.out.print("=> 수정할 단어 선택");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("=> 정말 삭제하시겠습니까?(Y/N)" );
        String answer = s.nextLine();

        if(answer.equalsIgnoreCase("y")){
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제 되었습니다.");
        }
        else
        {
            System.out.println("취소되었습니다.");
        }

    }

    public void levelWord() {
        System.out.print("=>레벨을 고르세요(1~3)");
        int inputlevel = s.nextInt();

    }

    public void serachWord() {
    }
}
