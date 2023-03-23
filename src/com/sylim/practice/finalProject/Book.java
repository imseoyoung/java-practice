package com.sylim.practice.finalProject;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Book implements Manage {
    // id, 제목, 저자, 출판사, 대출가능여부
    Scanner sc = new Scanner(System.in);

    private String id;
    private String title;
    private String writer;
    private String publisher;
    private boolean available;

    CsvToList csvToList = new CsvToList();
    List<String[]> books = csvToList.readCSV("books.csv");
    BookCsvWriter csvWriter = new BookCsvWriter(books);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", writer=" + writer + ", publisher="
                + publisher + ", available=" + available + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(available, id, publisher, title, writer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return available == other.available && Objects.equals(id, other.id)
                && Objects.equals(publisher, other.publisher) && Objects.equals(title, other.title)
                && Objects.equals(writer, other.writer);
    }

    public void bookMain() {
        String userInput = "";

        while (!userInput.equals("0")) {
            System.out.println("0.뒤로    1.책 조회    2.책 등록    3.책 수정    4.책 삭제    5.삭제취소");
            userInput = sc.nextLine();

            switch (userInput) {
                case ("0"):
                    return;
                case ("1"):
                    view();
                    break;
                case ("2"):
                    add();
                    break;
                case ("3"):
                    update();
                    break;
                case ("4"):
                    delete();
                    break;
                case ("5"):
                    deleteBack();
                    break;
                default:
                    System.out.println("잘못입력했지렁이 다시입력해지렁이");
                    break;
            }
        }
    }

    @Override
    public void view() {
        while (true) {
            System.out.println("보유 도서 목록입니다.");
            for (String[] book : books) {
                for (String field : book) {
                    System.out.print(field + "\t");
                }
                System.out.println();
            }
            System.out.println("뒤로 가기(B) 종료 하기(X)");
            String select = sc.nextLine();
            if (select.equalsIgnoreCase("b")) {
                break;
            } else if (select.equalsIgnoreCase("X")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("잘못 입력하셨습니다. 처음으로 돌아갑니다.");
                break;
            }
        }
        bookMain();
    }

    @Override
    public void add() {
        while (true) {
            Book book = new Book();
            // bookId는 중복되면 안 됨
            while (true) {
                int cnt = 0;
                System.out.println("책 번호 입력");
                String temp = sc.nextLine();
                for (String[] value : books) {
                    if (temp.equals(value[0])) {
                        cnt++;
                        System.out.println("책 번호 중복입니다. 다시 입력하세요.");
                        break;
                    }
                }
                if (cnt == 0) {
                    book.setId(temp);
                    break;
                }
            }
            System.out.println("책 제목 입력 : ");
            book.setTitle(sc.nextLine());
            System.out.println("책 저자 입력 : ");
            book.setWriter(sc.nextLine());
            System.out.println("출판사 입력 : ");
            book.setPublisher(sc.nextLine());
            book.setAvailable(true);

            System.out.println("책 번호 : " + book.getId());
            System.out.println("책 제목 : " + book.getTitle());
            System.out.println("책 저자  : " + book.getWriter());
            System.out.println("출판사  : " + book.getPublisher());
            System.out.println("대여가능 : " + book.isAvailable());

            System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                String[] newBook = new String[5];
                newBook[0] = book.getId();
                newBook[1] = book.getTitle();
                newBook[2] = book.getWriter();
                newBook[3] = book.getPublisher();
                newBook[4] = String.valueOf(book.isAvailable());
                books.add(newBook);
                System.out.println("완료");
                csvWriter.writeCsvFile("books.csv");
                break;
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("도서 정보를 새로 입력하세요.");
                continue;
            } else {
                System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.");
                continue;
            }
        }
        bookMain();
    }

    @Override
    public void update() {
        while (true) {
            System.out.println("수정 할 책의 번호를 입력해주세요");
            int cnt = 0;
            String temp = sc.nextLine();
            for (int i = 0; i < books.size(); i++) {
                if (temp.equals(books.get(i)[0])) {
                    System.out.println("1.제목 수정    2.저자 수정    3.출판사 수정");
                    String choice = sc.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.println("새로운 제목을 입력하세요: ");
                            books.get(i)[1] = sc.nextLine();
                            csvWriter.writeCsvFile("books.csv");
                            cnt++;
                            break;
                        case "2":
                            System.out.println("새로운 작가를 입력하세요: ");
                            books.get(i)[2] = sc.nextLine();
                            csvWriter.writeCsvFile("books.csv");
                            cnt++;
                            break;
                        case "3":
                            System.out.println("새로운 출판사를 입력하세요: ");
                            books.get(i)[3] = sc.nextLine();
                            csvWriter.writeCsvFile("books.csv");
                            cnt++;
                            break;
                        default:
                            System.out.println("잘못된 입력입니다.");
                            i--;
                            continue;
                    }
                    cnt++;
                    break;
                }
            }
            if (cnt == 0) {
                System.out.println("해당 책은 존재하지 않습니다. 책 번호를 다시 입력하세요.");
                continue;
            } else {
                break;
            }
        }
        bookMain();
    }


    @Override
    public void delete() {
        while (true) {
            System.out.println("삭제 할 책의 번호를 입력해주세요");
            String temp = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < books.size(); i++) {
                if (temp.equals(books.get(i)[0])) {
                    books.remove(i);
                    cnt++;
                    System.out.println("도서 삭제 완료");
                    csvWriter.writeCsvFile("books.csv");
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

    @Override
    public void deleteBack() {}
}


