package com.shanny.demo;

import java.lang.instrument.Instrumentation;

import com.shanny.demo.agent.MyTransformer;

/**
* @author ���� whitexiaosheng
* @version ����ʱ�� 2019��8��20�� ����6:14:36
*/
public class MyAgent {
	public static void premain(String agentOps, Instrumentation inst) {
		System.out.println("========premain����ִ��=========");
		System.out.println(agentOps);
		// ���Transformer
		inst.addTransformer(new MyTransformer());
	}
}
