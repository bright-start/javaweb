package agent;

import java.lang.instrument.Instrumentation;

/**
 * 
 * @author whitexiaosheng
 * @version 2019/8/19
 */
public class pre_MyProgram {
	/**
	 * �÷�����main����֮ǰ���У���main����������ͬһ��jvm��
	 * ����ͬһ��System ClassLoaderװ��
	 * ��ͳһ�İ�ȫ���ԣ�secutiry policy�� ��������(context) ����
	 * 
	 * @param agentOps
	 * @param inst
	 * 
	 */
	public static void premain(String agentOps,Instrumentation inst) {
		System.out.println("========premain����ִ��");
		System.out.println(agentOps);
	}
	
	/**
	 * ���������premain(String agentOps, Instrumentation inst)
	 * ���ִ�� premain(String agentOps)
	 * 
	 * @param agentOps
	 */
	public static void premain(String agentOps) {
		System.out.println("=======premain����ִ��2");
		System.out.println(agentOps);
	}
	public static void main(String[] args) {
		
	}
}
