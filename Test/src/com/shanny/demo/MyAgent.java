package com.shanny.demo;

import java.lang.instrument.Instrumentation;

import com.shanny.demo.agent.MyTransformer;

/**
* @author 作者 whitexiaosheng
* @version 创建时间 2019年8月20日 下午6:14:36
*/
public class MyAgent {
	public static void premain(String agentOps, Instrumentation inst) {
		System.out.println("========premain方法执行=========");
		System.out.println(agentOps);
		// 添加Transformer
		inst.addTransformer(new MyTransformer());
	}
}
