import java.util.Scanner;

public class LottoUI {
    public void menu(){

        // 메뉴
        String[] menus = {
            "1. 직접입력",
            "2. 자동뽑기",
            "3. 종료"
        };

        Scanner sc = new Scanner(System.in);
        
        LottoAction action = new LottoAction();

        boolean run = true;

        while (run) {
            System.out.println("★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★");
            System.out.println("       메뉴를 선택하시오     ");
            System.out.println("★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★");
            for(String menu : menus){
                System.out.println(menu);
            }
            System.out.println("--------------------------");
            System.out.print(">>");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    System.out.println("> 1번 - 직접입력을 선택하였습니다.");
                    action.inputNumber(sc);
                    break;
                case 2:
                    System.out.println("> 2번 - 자동입력을 선택하였습니다.");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("> 3번 - 게임을 종료합니다.");
                    System.out.println("---------------------------");
                    run = false;
                    break;
                default:
                    System.out.println("> 메뉴번호 확인 후 다시 입력해주세요!");
                    break;
            }
        }
        
        sc.close();
    }   
}
