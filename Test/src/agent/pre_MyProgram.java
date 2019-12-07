package agent;

import java.lang.instrument.Instrumentation;

/**
 * 
 * @author whitexiaosheng
 * @version 2019/8/19
 */
public class pre_MyProgram {
	/**
	 * 该方法在main方法之前运行，与main方法运行在同一个jvm中
	 * 并被同一个System ClassLoader装载
	 * 被统一的安全策略（secutiry policy） 和上下文(context) 管理
	 * 
	 * @param agentOps
	 * @param inst
	 * 
	 */
	public static void premain(String agentOps,Instrumentation inst) {
		System.out.println("========premain方法执行");
		System.out.println(agentOps);
	}
	
	/**
	 * 如果不存在premain(String agentOps, Instrumentation inst)
	 * 则会执行 premain(String agentOps)
	 * 
	 * @param agentOps
	 */
	public static void premain(String agentOps) {
		System.out.println("=======premain方法执行2");
		System.out.println(agentOps);
	}
	public static void main(String[] args) {
		
	}
}
