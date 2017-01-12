package com.example.sbjasperangular;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.sbjasperangular")
public class SbJasperAngularApplication3 implements CommandLineRunner {

	/**
	 * Spring Boot APP : SbJasperAngularApplication3
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SbJasperAngularApplication3.class, args);
		System.out.println("start Spring Boot APP : SbJasperAngularApplication3 !");
//		dispPreSystemInfo(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		dispPreSystemInfo(args);
	}

	/**
	 * 開発環境診断表示
	 * @param args
	 */
	private static void dispPreSystemInfo(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("os.name:" + System.getProperty("os.name"));
		dumpSysInfo();
		if(System.getProperty("os.name").startsWith("Windows")){
			System.out.println("environment:Development");
		}
	}

	/**
	 * システム情報のダンプアウト
	 */
	private static void dumpSysInfo() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("--------------------------------------------------------------------------");
		System.getProperties().keySet().stream()
		.forEach(key -> System.out.println("" + key + " : " + System.getProperty((String)key)));
		System.out.println("--------------------------------------------------------------------------");
	}

}
