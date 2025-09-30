package io.member;

import io.member.impl.DataMemberRepository;
import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;
import io.member.impl.ObjectMemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {
    //private static final MemberRepository repository = new MemoryMemberRepository();

   // private static final MemberRepository repository = new FileMemberRepository();
   // private static final MemberRepository repository = new DataMemberRepository();
   private static final MemberRepository repository = new ObjectMemberRepository();

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        while(true){
            System.out.println("1.회원등록 | 2.회원 목록 조회 | 3.종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //엔터값 날림

            switch (choice){
                case 1:
                    registerMember(scanner);
                    break;
                case 2:
                    displayMembers();
                    break;
                case 3:
                    System.out.println("시스템을 종료합니다");
                    return;
                default:
                    System.out.println("잘못된 선택임 ");

            }
        }
    }

    private static void registerMember(Scanner scanner) {

        System.out.println("아이디 입력");
        String id= scanner.nextLine();

        System.out.println("이름 입력");
        String name = scanner.nextLine();

        System.out.println("나이 입력");
        int age = scanner.nextInt();
        scanner.nextLine();

        Member member = new Member(id,name,age);
        repository.add(member);
        System.out.println("회원 저장 끝");
    }

    private static void displayMembers() {
        List<Member> all = repository.findAll();
        System.out.println("회원 목록");
        for (Member member : all) {
            System.out.printf("%s - %s님 %d세 \n",member.getId(), member.getName(), member.getAge());
        }

    }
}
