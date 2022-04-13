package day;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class StuInfo{//�л� �̸�, �⼮���� 
	String name;
	String checkStu="�Ἦ";//�⺻ ���� �Ἦ���� �д�
	public StuInfo(String name) {
		this.name=name;
	}
}

class Students{
	//�ð��� ����ϱ� ���� Date,SimpleDateFormat
	private Date date;
	private SimpleDateFormat simple;
	//Ŭ���� StuInfo ��ü�� �����ϴ� ArrayList�� ����
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
	//�޴���� �޼ҵ�
	public int menu() {
		int n=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("===== �л� �⼮ ���� ���α׷� =====");
        System.out.println("1. �л� ���");
        System.out.println("2. �⼮üũ�ϱ�");
        System.out.println("3. �⼮��Ȳ ����");
        System.out.println("4. ����");
        System.out.print("��ȣ �Է�>>>");
        return n=scan.nextInt();
	}
	public void joinStudent(String name) {//�л� ��� �޼ҵ�
		list.add(new StuInfo(name));//ArrayList�� �߰�
		System.out.println(name+"�л� [����� �Ϸ�Ǿ����ϴ�.]");
	}
	public void studentCheck(int num) {//�л� �⼮üũ �޼ҵ�
		if(num >= list.size() || num<0) {//����Ʈ�� ��ȣ�� ������
			System.out.println("<������ ��ȣ�� �߸� �Է��Ͽ����ϴ�.>");
			return;
		}
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("HH��mm��");//�ð��������ļ���
		String str=sf.format(date);
		int hour = Integer.parseInt(str.substring(0, 2));//�������θ� Ȯ���ϱ� ���� int�� ����ȯ
		int minute= Integer.parseInt(str.substring(3, 5));
	    // �⼮, ����, �Ἦ ���� : �⺻���� �Ἦ, ��¥ ��� ������ �Ϻκ��� ������ int �ڷ������� ����ȯ �� ��
        // ���� ���Ͽ� ����, �⼮ ���θ� �Ǻ��Ѵ�.
		if(hour>=9) {
			System.out.println("[�⼮üũ �Ϸ�]");
			System.out.println("���� �ð�:"+str);
			System.out.println("�����Դϴ�!");
			list.get(num).checkStu="����";
		}else {
			System.out.println("[�⼮üũ �Ϸ�]");
			System.out.println("����ð�:"+str);
			System.out.println("���� �⼮ �Դϴ�.");
			list.get(num).checkStu="�⼮";
		}
	}
	public void studentList() {//�⼮ ��Ȳ ����Ʈ�� ����ϴ� �޼ҵ�
		System.out.println("<< �⼮ ��Ȳ >>");
		System.out.println("|��ȣ| �̸� | �⼮���� |");
		for(int i=0;i<list.size();i++) {
			System.out.println("| "+(i+1)+" | "+list.get(i).name+" | "+list.get(i).checkStu+"  |");
		}
		return;
	}
}
public class StudentProject {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Students students=new Students();//��ü����
		String name=" ";//�Է� ���� �̸�
		while(true) {
			int select=students.menu();//�޴� ��ȣ ����
			switch(select) {
			case 1:
				System.out.println("�̸��� �Է��ϼ��� :");
				students.joinStudent(name=scan.next());
				break;
			case 2:
				students.setDate(new Date());
				students.setSimple(new SimpleDateFormat("yyyy�� MM�� dd��"));
				SimpleDateFormat sim=students.getSimple();
				System.out.println("<<<<"+sim.format(students.getDate())+"�⼮üũ >>>>");
				System.out.println("========= ������ ��� =========");
				System.out.println("��������ȣ\t: �̸�" );
				for( int i=0;i<students.list.size();i++) {
					System.out.println((i+1)+"\t:"+students.list.get(i).name);//����Ʈ�� �̸�
				}
				System.out.println("������ ��ȣ�� �Է��ϼ��� : ");
				int num=scan.nextInt()-1;
				students.studentCheck(num);
				break;
			case 3:
				students.studentList();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default:System.out.println("error:�ٽ� �Է����ּ���!!");//��ġ�Ǵ� ���� ���� �� ����� ����	
		}
	}
  }
}
