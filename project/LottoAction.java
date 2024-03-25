package project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoAction {

    // 로또 당첨금 조회
    public void checkPrice(int[] userNumbers){
        HashSet<Integer> winningNumbers = new HashSet<>();
        Random random = new Random();

        // 중복되지 않게 6개 번호 선택
        while (winningNumbers.size() < 6) {
            winningNumbers.add(random.nextInt(45) + 1);
        }

        System.out.println("당첨 번호 : " + winningNumbers);

        // 맞춘 숫자
        int matchedNumbers = 0;
        for(int num : userNumbers){
            if(winningNumbers.contains(num)){
                matchedNumbers++;
            }
        }

        // 당첨금 계산 및 출력
        switch (matchedNumbers) {
            case 6:
                System.out.println("축하합니다! 1등 당첨! 상금: 10억원");
                break;
            case 5:
                System.out.println("5개 숫자가 맞았습니다! 상금: 1,000만원");
                break;
            case 4:
                System.out.println("4개 숫자가 맞았습니다! 상금: 100만원");
                break;
            case 3:
                System.out.println("3개 숫자가 맞았습니다! 상금: 200,000원");
                break;
            case 2:
                System.out.println("2개 숫자가 맞았습니다! 상금: 50,000원");
                break;
            case 1:
                System.out.println("1개 숫자가 맞았습니다! 상금: 5,000원");
                break;
            default:
                System.out.println("아쉽지만 하나도 맞추지 못했습니다. 다음 기회에!");
        }

        System.out.println("---------------------------------------");
        System.out.println();
    }
    
    // 1번 메뉴 ) 로또 수동 입력
    public void insertNumber(Scanner sc){
        int numbers[] = new int[6];
        // 중복 숫자 거름
        HashSet<Integer> chosenNumbers = new HashSet<>();

        for(int i=0; i<numbers.length; i++){

            while (true) {
                try {
                    System.out.println((i+1) + "번째 번호 입력 (1~45까지의 숫자를 선택하시오.)");
                    int input = sc.nextInt();
                    if(input < 1 || input > 45){
                        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 ! ");
                        System.out.println("(1~45까지의 숫자를 선택하시오.");
                    }else if(chosenNumbers.contains(input)){
                        System.out.println("이미 선택한 숫자입니다. 다시 입력해주세요.");
                    }else{
                        numbers[i] = input;
                        chosenNumbers.add(input);
                        break;
                    }
                } catch (Exception e) {
                    // 문자 입력시 예외처리 시킴
                    System.out.println("문자는 입력할 수 없습니다");
                    System.out.println("(1~45까지의 숫자를 선택하시오.");
                    sc.nextLine();
                }
            }
        }

        LottoDTO select = new LottoDTO(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]);
        System.out.println("---------------------------------------");
        System.out.print("이번주 선택한 번호 > ");
        System.out.println(select);

        checkPrice(numbers);
    }

    // 2번 메뉴 ) 자동으로 뽑기
    public void actoNumber(){
        int[] autoNumbers = new int[6];
        HashSet<Integer> tempNumbers = new HashSet<>();
        Random random = new Random();
    
        while (tempNumbers.size() < 6) {
            tempNumbers.add(random.nextInt(45) + 1);
        }
    
        // HashSet의 내용을 배열로 복사
        Integer[] autoNumberArray = tempNumbers.toArray(new Integer[tempNumbers.size()]);
    
        // 배열을 int 배열로 변환
        for (int i = 0; i < autoNumbers.length; i++) {
            autoNumbers[i] = autoNumberArray[i];
        }

        System.out.println("입력 번호 : " + Arrays.toString(autoNumbers));
        checkPrice(autoNumbers);

    }
}
