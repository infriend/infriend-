package com.jsyunsi;

public class People
{
	//�޲ι���
	public People()
	{
		System.out.println("�޲ι���");
	}
	//�вι���
	public People(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
		//�����������
		private String name;
		private int age;
		private char sex;
	////���������Ϊ��������
		public void eat()
		{
			System.out.println("ǡ��");
		}
		public void sleep(String where)
		{
			System.out.println("����" + where + "˯����");
		}
		public int playGame(int n)
		{
			System.out.println("��һ���" + n + "����Ϸ");
			return n;
		}

}
