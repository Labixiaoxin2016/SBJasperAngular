package com.example.sbjasperangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.sbjasperangular.cassandra.model.MemoBox;
import com.example.sbjasperangular.cassandra.model.Person;

@EnableAutoConfiguration
@ComponentScan("com.example.sbjasperangular")
public class SbJasperAngularApplication3 implements CommandLineRunner {

	@Autowired
	private com.example.sbjasperangular.cassandra.repository.MemoBoxRepository memoBoxRepository;

	@Autowired
	private com.example.sbjasperangular.cassandra.repository.PersonRepositoryStream personRepository;

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
//		initDataMemoBox();
//		initDataPerson();
	}

    /**
     * 初期データ投入処理：MemoBox
     */
	private void initDataMemoBox() {
		// error:unconfigured columnfamily memobox
		this.memoBoxRepository.deleteAll();
    	this.memoBoxRepository.save((MemoBox) new MemoBox("a","b","tanaka1","memo1",new java.util.Date()));
    	this.memoBoxRepository.save((MemoBox) new MemoBox("a","b","tanaka2","memo2",new java.util.Date()));
	}

    /**
     * 初期データ投入処理：Person
     */
	private void initDataPerson() {
		// error:unconfigured columnfamily person
		this.personRepository.deleteAll();
    	this.personRepository.save((Person) new Person("1","tanaka1","tarou"));
    	this.personRepository.save((Person) new Person("2","tanaka1","takeshi"));
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
