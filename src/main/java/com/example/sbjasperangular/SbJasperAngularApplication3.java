package com.example.sbjasperangular;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.sbjasperangular")
public class SbJasperAngularApplication3 implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbJasperAngularApplication3.class, args);
//		dispPreSystemInfo(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		dispPreSystemInfo(args);
	}

	private static void dispPreSystemInfo(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("os.name:" + System.getProperty("os.name"));
		dumpSysInfo();
		if(System.getProperty("os.name").startsWith("Windows")){
			System.out.println("environment:Development");
		}
	}

	private static void dumpSysInfo() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("--------------------------------------------------------------------------");
		System.getProperties().keySet().stream()
		.forEach(key -> System.out.println("" + key + " : " + System.getProperty((String)key)));
		System.out.println("--------------------------------------------------------------------------");
	}

}
