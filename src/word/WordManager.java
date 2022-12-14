package word;

import java.util.Scanner;

public class WordManager {

    Scanner s = new Scanner(System.in);
    CRUD crud;
    WordManager(){
        crud = new CRUD(s);
    }
    public void start(){
        crud.loadFile();

        while(true){
            int menu = printManu();


            if(menu == 0) {
                System.out.println("영단어 프로그램 종료");
                break;
            }

            if(menu == 1){
                //listprint
                crud.viewList();
            }else if(menu == 2){
                crud.levelWord();
            }
            else if(menu ==3 ){
                crud.serachWord();
            }
            else if (menu == 4){
                // addword
                crud.addWord();
            }
            else if(menu == 5){
                crud.updateWord();
            }
            else if(menu == 6){
                crud.deleteWord();
            }
            else if(menu == 7){
                crud.saveFile();
            }
        }

    }


    public int printManu(){
        System.out.println("***영단어 마스터***\n" +
                "************************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "**************\n" +
                "=> 원하는 메뉴는?");
        return s.nextInt();
    }

}
