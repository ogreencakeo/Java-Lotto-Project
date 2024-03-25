import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
public class LottoAction {

     // 로또 당첨금 조회
    public void checkPrice(int[] userNumbers) {
        HashSet<Integer> winningNumbers = new HashSet<>();
        Random random = new Random();

        // 중복되지 않는 6개의 당첨번호 선택
        while (winningNumbers.size() < 6) {
            winningNumbers.add(random.nextInt(45) + 1); // 1부터 45까지의 난수 생성하여 HashSet에 추가
        }

        // 당첨번호 출력
        
        System.out.println("당첨 번호: " + winningNumbers);

        // 맞춘 숫자 개수 계산
        int matchedNumbers = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
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

    // 1번. 로또 번호 직접 입력
    public void inputNumber(Scanner sc){
        int numbers[] = new int[6];
        // 중복된 숫자 거름
        HashSet<Integer> chosenNumbers = new HashSet<>();

        for(int i=0; i<6; i++){
            while(true){
                System.out.print((i+1) + " 번째 번호 입력 (1 ~ 45) >> ");
                int input = sc.nextInt();
                if(input < 1 || input >45 ){
                    System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
                }else if(chosenNumbers.contains(input)){
                    System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
                }else{
                    numbers[i] = input;
                    chosenNumbers.add(input);
                    break;
                }
            }

        }

        LottoDTO select = new LottoDTO(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]);
        System.out.println("---------------------------------------");
        System.out.println("이번주 로또 번호 당첨 결과 !!");

        System.out.println(select);

        // 당첨금 확인
        checkPrice(numbers);

    }
}
