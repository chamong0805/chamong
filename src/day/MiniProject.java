package day;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//�л� �⼮ ���α׷�
/*
 * �л��̸����� �⼮���θ� �� �� �ִ� 
 * 
 */
class StuInfo { // �л� �̸�, �⼮ ���ΰ� ��ϵǾ� �ִ� Ŭ����
    String name;
    String checkStatus = " ";
    public StuInfo(String name) {
        this.name = name;
    }
}
 
 
class Students {
    // �ð��� ����ϱ� ���� Date, SimpleDateForamt �ڷ��� ������ �ʵ�� ����.
    private Date date;
    private SimpleDateFormat simpl;
    // Ŭ���� StuInfo ��ü�� �����ϴ� ArrayList�� �����Ѵ�.
    public ArrayList<StuInfo> studentsInfo = new ArrayList<StuInfo>();
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public SimpleDateFormat getSimpl() {
        return simpl;
    }
    public void setSimpl(SimpleDateFormat simpl) {
        this.simpl = simpl;
    }
    
    public int display() { // �޴� ��� �޼ҵ�
    	int n=0;
        Scanner scan= new Scanner(System.in);
        System.out.println("===== �л� �⼮ ���� ���α׷� =====");
        System.out.println("1. �л� ���");
        System.out.println("2. �⼮üũ�ϱ�");
        System.out.println("3. �⼮��Ȳ ����");
        System.out.println("4. ����");
        System.out.print("��ȣ �Է�>>>");
        return n=scan.nextInt();//��ȣ
    }
        
    public void joinStudent(String name) { // �л� ��� �޼ҵ�
            studentsInfo.add(new StuInfo(name));//ArrayList�� �߰�
            System.out.println(name+"�л� [����� �Ϸ�Ǿ����ϴ�.]");
    }
    
    
    public void studentCheck(int num) { //�л� �⼮üũ �޼ҵ�
        if (num >= studentsInfo.size() || num < 0) {//����Ʈ�� ��ȣ�� ������
            System.out.println("<������ ��ȣ�� �߸� �Է��Ͽ����ϴ�.>");
            return;
        } 
        Date date = new Date();//�ð�
        SimpleDateFormat sim = new SimpleDateFormat("HH��mm��");//��¥�������ļ���
        String str = sim.format(date);
        int hour = Integer.parseInt(str.substring(0, 2));//�������θ� Ȯ���ϱ� ���� int�� ����ȯ
        int minute = Integer.parseInt(str.substring(3, 5));
        // �⼮, ����, �Ἦ ���� : �⺻���� �Ἦ, ��¥ ��� ������ �Ϻκ��� ������ int �ڷ������� ����ȯ �� ��
        // ���� ���Ͽ� ����, �⼮ ���θ� �Ǻ��Ѵ�.
        if (hour >= 9 ) { 
            System.out.println("[�⼮üũ �Ϸ�]");
            System.out.println("���� �ð� : "+str);
            System.out.println("�����Դϴ�!");
            studentsInfo.get(num).checkStatus = "����"; 
           
        } else {
            System.out.println("[�⼮üũ �Ϸ�]");
            System.out.println("���� �ð� : "+str);
            System.out.println("���� �⼮ �Դϴ�.");
            studentsInfo.get(num).checkStatus = "�⼮";
        }
        
    }
    
    public void studentList() { // �⼮ ��Ȳ ����Ʈ�� ����ϴ� �޼ҵ�
        System.out.println("<< �⼮ ��Ȳ >>");
        System.out.println("|��ȣ| �̸� | �⼮���� |");
        for (int i = 0 ; i < studentsInfo.size(); i++) {
            System.out.println("| "+(i+1)+" | "+studentsInfo.get(i).name+" |  "+studentsInfo.get(i).checkStatus+"   |");
        }
        return;
    }
}
 
public class MiniProject {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String name=" ";
        Students students = new Students();//��ü����
        while(true) {
            int select = students.display();//�޴� ��ȣ ����
            switch (select) {
            case 1:
                System.out.print("�̸��� �Է��ϼ��� :");
                students.joinStudent(name=scan.next());
                break;
            case 2:
                students.setDate(new Date());
                students.setSimpl(new SimpleDateFormat("yyyy�� MM�� dd��"));
                SimpleDateFormat sim = students.getSimpl();
                System.out.println("<<<<"+sim.format(students.getDate())+" �⼮üũ >>>>");
                System.out.println("========= ������ ��� =========");
                System.out.println("��������ȣ\t: �̸�");
                for (int i = 0 ; i < students.studentsInfo.size(); i++) {
                    System.out.println((i+1) +"\t:"+students.studentsInfo.get(i).name);
                }
                System.out.print("������ ��ȣ�� �Է��ϼ��� : ");
                int num =scan.nextInt()-1;
                students.studentCheck(num);
                break;
            case 3:
                students.studentList();
                break;
            case 4:
                System.out.println("���α׷��� �����մϴ�.");
                System.exit(0);
                break;
            default:System.out.println("error:�ٽ� �Է����ּ���!");//��ġ�Ǵ� ���� ������ ����� ����;
                break;
            }
        }
   }

}
