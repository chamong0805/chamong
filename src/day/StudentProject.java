package day;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class StuInfo{//학생 이름, 출석여부 
	String name;
	String checkStu="결석";//기본 값을 결석으로 둔다
	public StuInfo(String name) {
		this.name=name;
	}
}

class Students{
	//시간을 출력하기 위해 Date,SimpleDateFormat
	private Date date;
	private SimpleDateFormat simple;
	//클래스 StuInfo 객체를 저장하는 ArrayList를 선언
	ArrayList<StuInfo> list=new ArrayList<StuInfo>();
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date=date;
	}
	public SimpleDateFormat getSimple() {
		return simple;
	}
	public void setSimple(SimpleDateFormat simple) {
		this.simple=simple;
	}
	//메뉴출력 메소드
	public int menu() {
		int n=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("===== 학생 출석 관리 프로그램 =====");
        System.out.println("1. 학생 등록");
        System.out.println("2. 출석체크하기");
        System.out.println("3. 출석현황 보기");
        System.out.println("4. 종료");
        System.out.print("번호 입력>>>");
        return n=scan.nextInt();
	}
	public void joinStudent(String name) {//학생 등록 메소드
		list.add(new StuInfo(name));//ArrayList에 추가
		System.out.println(name+"학생 [등록이 완료되었습니다.]");
	}
	public void studentCheck(int num) {//학생 출석체크 메소드
		if(num >= list.size() || num<0) {//리스트에 번호가 없으면
			System.out.println("<수강생 번호를 잘못 입력하였습니다.>");
			return;
		}
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("HH시mm분");//시간포멧형식설정
		String str=sf.format(date);
		int hour = Integer.parseInt(str.substring(0, 2));//지각여부를 확인하기 위해 int로 형변환
		int minute= Integer.parseInt(str.substring(3, 5));
	    // 출석, 지각, 결석 여부 : 기본값은 결석, 날짜 출력 포멧의 일부분을 가져와 int 자료형으로 형변환 한 뒤
        // 값을 비교하여 지각, 출석 여부를 판별한다.
		if(hour>=9) {
			System.out.println("[출석체크 완료]");
			System.out.println("현재 시각:"+str);
			System.out.println("지각입니다!");
			list.get(num).checkStu="지각";
		}else {
			System.out.println("[출석체크 완료]");
			System.out.println("현재시간:"+str);
			System.out.println("정상 출석 입니다.");
			list.get(num).checkStu="출석";
		}
	}
	public void studentList() {//출석 현황 리스트를 출력하는 메소드
		System.out.println("<< 출석 현황 >>");
		System.out.println("|번호| 이름 | 출석상태 |");
		for(int i=0;i<list.size();i++) {
			System.out.println("| "+(i+1)+" | "+list.get(i).name+" | "+list.get(i).checkStu+"  |");
		}
		return;
	}
}
public class StudentProject {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Students students=new Students();//객체생성
		String name=" ";//입력 받은 이름
		while(true) {
			int select=students.menu();//메뉴 번호 선택
			switch(select) {
			case 1:
				System.out.println("이름을 입력하세요 :");
				students.joinStudent(name=scan.next());
				break;
			case 2:
				students.setDate(new Date());
				students.setSimple(new SimpleDateFormat("yyyy년 MM월 dd일"));
				SimpleDateFormat sim=students.getSimple();
				System.out.println("<<<<"+sim.format(students.getDate())+"출석체크 >>>>");
				System.out.println("========= 수강생 목록 =========");
				System.out.println("수강생번호\t: 이름" );
				for( int i=0;i<students.list.size();i++) {
					System.out.println((i+1)+"\t:"+students.list.get(i).name);//리스트의 이름
				}
				System.out.println("수강생 번호를 입력하세요 : ");
				int num=scan.nextInt()-1;
				students.studentCheck(num);
				break;
			case 3:
				students.studentList();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:System.out.println("error:다시 입력해주세요!!");//일치되는 값이 없을 때 실행될 문장	
		}
	}
  }
}
