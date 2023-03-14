package com.sylim.practice;

public class Main0307_3 {
    public static void main(String[] args) {
        // 화면에 "[메뉴] 1:검색 2:등록 3:삭제 4:변경 >" 을 표시한다
        System.out.println("[메뉴] 1:검색 2:등록 3:삭제 4:변경 >");
        // 키보드로 숫자를 입력하고, 변수에 대입
        System.out.print("숫자를 입력해주세요 : ");
        int selected = new java.util.Scanner(System.in).nextInt();
        // switch문 (Ctrl+1 단축키로 if문으로 변경 가능)
        switch (selected) {
            case 1:
                System.out.println("검색합니다.");
                break;
            case 2:
                System.out.println("등록합니다.");
                break;
            case 3:
                System.out.println("삭제합니다.");
                break;
            case 4:
                System.out.println("변경합니다.");
                break;
            default:
        }
    }
}
