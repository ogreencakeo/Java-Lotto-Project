package project;

import java.util.Scanner;

public class LottoUI {
    public void menu(){
        String[] menus = {
            "1) 수동으로 입력",
            "2) 자동으로 입력",
            "3) 종료하기",
        };

        // 스캐너
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        // LottoAction
        LottoAction action = new LottoAction();

        while(run){
            System.out.println("★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★");
            System.out.println("★  --  행운의 로또 뽑기 --  ★");
            System.out.println("★     메뉴를 선택하시오     ★");
            System.out.println("★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★");
            for(String menu : menus){
                System.out.println(menu);
            }

            // 선택 번호
            System.out.println("----------------------------");
            System.out.print(">> ");
            String command = sc.next();

            switch (command) {
                case "1":
                    System.out.println("> 수동으로 입력을 선택하였습니다.");
                    action.insertNumber(sc);
                    break;
                case "2":
                    System.out.println("> 자동으로 입력을 선택하였습니다.");
                    break;
                case "3":
                    System.out.println("> 로또 게임을 종료합니다.");
                    System.out.println("-----------------------------");
                    run = false;
                    break;
                default:
                    System.out.println("잘못 선택하셨습니다. 다시 선택해주세요!");
            }
        }
        sc.close();
    }
}
