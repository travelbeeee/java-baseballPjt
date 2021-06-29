package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        while(true){
            if(initGame(scanner))
                break;
            doGame(scanner, makeThreeDistinctNumber());
        }
        return;
    }

    private static Boolean initGame(Scanner scanner){
        System.out.println("안녕하세요, 숫자 야구 게임입니다.");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String finishGame = scanner.next();
        if(finishGame.equals("2"))
            return true;
        if(finishGame.equals("1"))
            return false;
        throw new IllegalArgumentException("잘못된 입력입니다");
    }

    /**
     * 1) 게임을 진행하려면 먼저 서로 다른 3가지 숫자를 골라야된다.
     * 2) 사용자의 입력에 맞춰 게임을 진행한다.
     */
    private static void doGame(Scanner scanner, ArrayList<Integer> answerNumber) {
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scanner.next();
            if(!checkValidInput(userInput))
                throw new IllegalArgumentException("제대로 된 입력이 아닙니다.");
            if (makeHintByInput(answerNumber, userInput))
                break;
        }
    }

    /**
     * user가 입력한 3개의 숫자를 기반으로 힌트를 준다.
     */
    private static boolean makeHintByInput(ArrayList<Integer> answerNumber, String userInput) {
        int strike = 0, ball = 0;
        for (int ind = 0; ind < userInput.length(); ind++){
            Integer userInputNumber = userInput.charAt(ind) - '0';
            if(answerNumber.get(ind) == userInputNumber){
                strike++;
            }
            else if (answerNumber.contains(userInputNumber)){
                ball++;
            }
        }
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
        else if (ball == 0){
            System.out.println(strike + "스트라이크");
        }
        else{
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    /**
     * user가 입력한 3개의 숫자가 제대로 된 입력인지 확인한다.
     */
    private static boolean checkValidInput(String userInput){
        System.out.println("userInput = " + userInput);
        if(userInput.length() != 3) return false;
        for (int ind = 0; ind < userInput.length(); ind++){
            if(!('1' <= userInput.charAt(ind) && userInput.charAt(ind) <= '9'))
                return false;
        }
        return true;
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
            if(numberList.contains(newNumber))
                continue;
            numberList.add(newNumber);
        }
        return numberList;
    }
}
