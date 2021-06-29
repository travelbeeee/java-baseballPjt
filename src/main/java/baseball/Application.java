package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        initGame(scanner);

        return;
    }

    private static void initGame(Scanner scanner){
        System.out.println("안녕하세요, 숫자 야구 게임입니다.");
        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int doGameOrNot = scanner.nextInt();
            if(doGameOrNot == 2)
                break;
            doGame(scanner);
        }
        return;
    }

    /**
     * 1) 게임을 진행하려면 먼저 서로 다른 3가지 숫자를 골라야된다.
     * 2) 사용자의 입력에 맞춰 게임을 진행한다.
     */
    private static void doGame(Scanner scanner) {
        ArrayList<Integer> answerNumber = makeThreeDistinctNumber();

        return;
    }

    /**
     * RandomUtils.nextInt() 를 이용해 1 ~ 9 중 서로 다른 숫자 3개를 랜덤하게 골라보자.
     */
    private static ArrayList<Integer> makeThreeDistinctNumber(){
        ArrayList<Integer> numberList = new ArrayList<>();
        int startInclusive = 1, endInclusive = 9;
        while(true){
            if(numberList.size() == 3)
                break;
            int newNumber = RandomUtils.nextInt(startInclusive, endInclusive);
            if(checkDuplicate(numberList, newNumber))
                numberList.add(newNumber);
        }
        return numberList;
    }

    /**
     * 입력받은 newNumber랑 기존에 뽑은 numberList의 숫자들이랑 겹치는게 있는지 체크
     */
    private static boolean checkDuplicate(ArrayList<Integer> numberList, int newNumber) {
        for(int num : numberList){
            if(num == newNumber)
                return false;
        }
        return true;
    }
}
