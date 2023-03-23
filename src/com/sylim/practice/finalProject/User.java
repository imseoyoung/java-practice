package com.sylim.practice.finalProject;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User implements Manage {
    // id, 이름, 주소, 전화번호, 생일, 가입일
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    private String id;
    private String name;
    private String address;
    private String phone;
    private String birthday;
    private String joindate;
    
    private String[] deletedUser = null;

    CsvToList csvToList = new CsvToList();
    List<String[]> users = csvToList.readCSV("users.csv");
    UserCsvWriter csvWriter = new UserCsvWriter(users);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone
                + ", birthday=" + birthday + ", joindate=" + joindate + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, birthday, id, joindate, name, phone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(address, other.address) && Objects.equals(birthday, other.birthday)
                && Objects.equals(id, other.id) && Objects.equals(joindate, other.joindate)
                && Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
    }

    public void userMain() {
        System.out.println("0.뒤로    1.회원 조회    2.회원 등록    3.회원 수정    4.회원 삭제    5.삭제취소");
        String userInput = sc.nextLine();
        while (true) {
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
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    return;
            }
        }
    }

    @Override
    public void view() {
        while (true) {
            System.out.println("회원 목록입니다.");
            for (String[] user : users) {
                for (String field : user) {
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
        userMain();
    }

    @Override
    public void add() {
        while (true) {
            User user = new User();
            // 회원 번호는 중복되면 안 됨
            while (true) {
                int cnt = 0;
                System.out.println("회원 번호 입력");
                String temp = sc.nextLine();
                for (String[] value : users) {
                    if (temp.equals(value[0])) {
                        cnt++;
                        System.out.println("회원 번호 중복입니다. 다시 입력하세요.");
                        break;
                    }
                }
                if (cnt == 0) {
                    user.setId(temp);
                    break;
                }
            }
            System.out.println("이름 입력 : ");
            user.setName(sc.nextLine());
            System.out.println("주소 입력 : ");
            user.setAddress(sc.nextLine());
            System.out.println("전화번호 입력 : (010-XXXX-XXXX) ");
            user.setPhone(sc.nextLine());
            System.out.println("생일 입력 : (yyyy/MM/dd) ");
            user.setBirthday(sc.nextLine());
            System.out.println("가입일 입력 :(yyyy/MM/dd) ");
            user.setJoindate(sc.nextLine());

            System.out.println("회원 번호 : " + user.getId());
            System.out.println("회원 이름 : " + user.getName());
            System.out.println("회원 주소  : " + user.getAddress());
            System.out.println("전화번호 : " + user.getPhone());
            System.out.println("회원 생일 : " + user.getBirthday());
            System.out.println("가입날짜 : " + user.getJoindate());

            System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                String[] newUser = new String[6];
                newUser[0] = user.getId();
                newUser[1] = user.getName();
                newUser[2] = user.getAddress();
                newUser[3] = user.getPhone();
                newUser[4] = user.getBirthday();
                newUser[5] = user.getJoindate();
                users.add(newUser);
                System.out.println("회원 등록이 완료되었습니다.");
                csvWriter.writeCsvFile("users.csv");
                break;
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("회원 정보를 새로 입력하세요.");
                continue;
            } else {
                System.out.println("잘못 누르셨습니다. 처음부터 다시 시작합니다");
                continue;
            }
        }
        userMain();
    }

    @Override
    public void update() {
        while (true) {
            System.out.println("수정 할 회원의 번호를 입력해주세요");
            int cnt = 0;
            String temp = sc.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (temp.equals(users.get(i)[0])) {
                    System.out.println("1.이름 수정    2.주소 수정    3.전화번호 수정    4.생일 수정    5.가입날짜 수정");
                    String choice = sc.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.println("새로운 이름을 입력하세요 : ");
                            users.get(i)[1] = sc.nextLine();
                            csvWriter.writeCsvFile("users.csv");
                            cnt++;
                            break;
                        case "2":
                            System.out.println("새로운 주소를 입력하세요 : ");
                            users.get(i)[2] = sc.nextLine();
                            csvWriter.writeCsvFile("users.csv");
                            cnt++;
                            break;
                        case "3":
                            System.out.println("새로운 전화번호를 입력하세요 : (010-XXXX-XXXX) ");
                            users.get(i)[3] = sc.nextLine();
                            csvWriter.writeCsvFile("users.csv");
                            cnt++;
                            break;
                        case "4":
                            System.out.println("새로운 생일을 입력하세요 : (yyyy/MM/dd) ");
                            users.get(i)[4] = sc.nextLine();
                            csvWriter.writeCsvFile("users.csv");
                            cnt++;
                            break;                       
                        case "5":
                            System.out.println("새로운 가입날짜를 입력하세요 : (yyyy/MM/dd) ");
                            users.get(i)[5] = sc.nextLine();
                            csvWriter.writeCsvFile("users.csv");
                            System.out.println("수정이 완료되었습니다.");
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
                System.out.println("해당 회원이 존재하지 않습니다. 회원 번호를 다시 입력하세요.");
                continue;
            } else {
                break;
            }
        }
        userMain();
    }

    @Override
    public void delete() {
        while (true) {
            System.out.println("삭제 할 회원의 번호를 입력해주세요");
            String temp = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < users.size(); i++) {
                if (temp.equals(users.get(i)[0])) {
                    deletedUser = users.get(i);
                    users.remove(i);
                    cnt++;
                    System.out.println("회원 삭제 완료");
                    csvWriter.writeCsvFile("users.csv");
                    break;
                }
                break;
            }
            if (cnt == 0) {
                System.out.println("해당 회원이 존재하지 않습니다. 회원 번호를 다시 입력하세요.");
            } else {
                break;
            }
        }
    }
    
    
    @Override
    public void deleteBack() {
        while (true) {
            System.out.println("1.복구하기    2.나가기");
            String select = sc.nextLine();

            switch (select) {
                case ("1"):
                    if (deletedUser != null) {
                        users.add(deletedUser);
                        deletedUser = null;
                        System.out.println("복구가 완료되었습니다.");
                        csvWriter.writeCsvFile("books.csv");
                        break;
                    } else {
                        System.out.println("복구할 책이 없습니다.");
                    }
                    break;
                case ("2"):
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
