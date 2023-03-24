package com.sylim.practice.finalProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Borrow {
    // 책 이름, 회원 이름, 빌린 날짜, 반납 날짜
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Book book = new Book();
    User user = new User();

    private String bookId;
    private String userId;
    private String borrowdate;
    private String due;
    private String extend;

    CsvToList csvToList = new CsvToList();
    List<String[]> history = csvToList.readCSV("history.csv");
    BookCsvWriter bcsvWriter = new BookCsvWriter(book.books);
    HistoryCsvWriter hcsvWriter = new HistoryCsvWriter(history);

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public void borrowMain() throws ParseException {
        String userinput = "";

        while (!userinput.equals("0")) {
            System.out.println("0.뒤로    1.대출하기    2.반납하기    3.연장하기    4.대출목록");
            userinput = sc.nextLine();

            switch (userinput) {
                case ("0"):
                    return;
                case ("1"):
                    borrow();
                    break;
                case ("2"):
                    returnBook();
                    break;
                case ("3"):
                    extendBook();
                    break;
                case ("4"):
                    viewAvailable();
                    break;
                default:
                    System.out.println("잘못입력했습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void borrow() {
        while (true) {
            Borrow borrow = new Borrow();
            System.out.println("회원님의 회원번호를 입력해주세요.");
            borrow.setUserId(sc.nextLine());

            System.out.println("대출 가능한 책 목록입니다.");
            for (String[] book : book.books) {
                if (book[4].equalsIgnoreCase("true")) {
                    for (String field : book) {
                        System.out.print(field + "\t");
                    }
                    System.out.println();
                }
            }

            System.out.println("빌릴 책 번호를 입력해주세요.");
            String bookid = sc.nextLine();
            int cnt = 0;
            for (int i = 1; i < book.books.size(); i++) {
                if (bookid.equals(book.books.get(i)[0])) {
                    cnt++;
                    book.books.get(i)[4] = "false";
                    bcsvWriter.writeCsvFile("books.csv");

                    String[] newHistory = new String[5];
                    borrow.setBookId(bookid);
                    newHistory[0] = borrow.getBookId();
                    newHistory[1] = borrow.getUserId();
                    
                    borrow.setExtend("0");
                    newHistory[2] = borrow.getExtend();

                    Date now = new Date();
                    Calendar calendar = Calendar.getInstance();
                    borrow.setBorrowdate(sdf.format(now));
                    newHistory[3] = borrow.getBorrowdate();                   
                                      
                    calendar.add(Calendar.DATE, 14);
                    Date date = calendar.getTime();
                    borrow.setDue(sdf.format(date));
                    newHistory[4] = borrow.getDue();
                    
                    history.add(newHistory);
                    hcsvWriter.writeCsvFile("history.csv");

                    System.out.println("대여가 완료되었습니다.");
                    break;
                }
            }
            if (cnt == 0) {
                System.out.println("해당 책은 존재하지 않습니다. 책 번호를 다시 입력하세요.");
            } else {
                break;
            }
        }
    }

    public void returnBook() {
        while (true) {
            System.out.println("반납 할 책의 번호를 입력해주세요");
            String bookid = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < book.books.size(); i++) {
                if (bookid.equals(book.books.get(i)[0])) {
                    for (int j = 0; j < history.size(); j++) {
                        if (bookid.equals(history.get(j)[0])) {
                            history.remove(j);
                            cnt++;
                            hcsvWriter.writeCsvFile("history.csv");
                            break;
                        }
                    }
                    book.books.get(i)[4] = "true";
                    bcsvWriter.writeCsvFile("books.csv");
                    System.out.println("반납이 완료되었습니다. ");
                    cnt++;
                    break;
                }
            }
            if (cnt == 0) {
                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
            } else {
                break;
            }
        }
    }

    public void extendBook() throws ParseException {
        while (true) {
            Borrow borrow = new Borrow();
            System.out.println("연장 할 책의 번호를 입력해주세요");
            int cnt = 0;
            String bookid = sc.nextLine();
            for (int i = 0; i < history.size(); i++) {
                if (history.get(i)[0].equals(bookid) && history.get(i)[2].equals("0")) {
                    Date date = sdf.parse(history.get(i)[4]);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.DATE, 7);

                    Date newDate = calendar.getTime();
                    borrow.setDue(sdf.format(newDate));
                    history.get(i)[4] = borrow.getDue();
                    hcsvWriter.writeCsvFile("history.csv");
                    System.out.println("연장되었습니다. ");
                    cnt++;
                }
            }
            if (cnt == 0) {
                System.out.println("해당 책이 존재하지 않습니다. 책 번호를 다시 입력하세요.");
                continue;
            } else {
                break;
            }
        }
    }


    public void viewAvailable() throws ParseException {
        while (true) { 
            List<String[]> validHistory = new ArrayList<>();            
            for (String[] data : history) {
                try {
                    if (data[4].equals("due")) {
                        continue; // "due" 문자열이 포함된 데이터는 제외
                    }
                    sdf.parse(data[4]); // 유효한 날짜 형식인지 검사
                    validHistory.add(data);
                } catch (ParseException e) {
                    continue; // 유효한 날짜 형식이 아닌 데이터는 제외
                }
            }
            Collections.sort(validHistory, (o1, o2) -> {
                try {
                    Date date1 = sdf.parse(o1[4]);
                    Date date2 = sdf.parse(o2[4]);
                    return date1.compareTo(date2); // 반납날짜를 기준으로 정렬
                } catch (ParseException e) {
                    return 0; // 유효한 날짜 형식이 아닌 경우 정렬하지 않음
                }
            });
            Collections.sort(validHistory, new Comparator<String[]>() {              
                @Override
                public int compare(String[] o1, String[] o2) {
                    try {
                        Date d1 = sdf.parse(o1[4]);
                        Date d2 = sdf.parse(o2[4]);
                        return d1.compareTo(d2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            });

            System.out.println("대출 목록입니다.");
            for (String[] data : validHistory) {
                for (String field : data) {
                    System.out.print(field + "\t");
                }
                System.out.println();
            }
            System.out.println("뒤로 가기(B) 종료 하기(X)");
            String userinput = sc.nextLine();
            if (userinput.equalsIgnoreCase("b")) {
                break;
            } else if (userinput.equalsIgnoreCase("X")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("잘못 입력하셨습니다. 처음으로 돌아갑니다.");
                break;
            }
        }
        borrowMain();
    }

}
