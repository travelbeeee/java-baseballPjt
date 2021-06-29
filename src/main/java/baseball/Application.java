package baseball;

import utils.RandomUtils;

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

    private static void doGame(Scanner scanner) {

    }
}
