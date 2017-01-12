package com.example.sbjasperangular;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableAutoConfiguration
@ComponentScan("com.example.sbjasperangular")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SbJasperAngularApplication2 extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SbJasperAngularApplication2.class, args);
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
//		Properties prop = System.getProperties();
//		Stream<Object> st = prop.keySet().stream();
//		st.forEach(System.out::println);
//		st.forEach(key -> System.out.println("" + key + " : " + System.getProperty((String)key)));
		System.getProperties().keySet().stream()
		.forEach(key -> System.out.println("" + key + " : " + System.getProperty((String)key)));
		System.out.println("--------------------------------------------------------------------------");
	}

	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		// 以前は指定していたが、指定するとむしろKEY→VALUE変換できなくなる。
//		slr.setDefaultLocale(Locale.JAPANESE);//Locale.ENGLISH
		System.out.println("Locale:" + Locale.getDefault().toString());
		return slr;
	}

	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Configuration
	protected static class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter {

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("demo").password("demo").roles("demo");
		}
	}

	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().authorizeRequests()
			.antMatchers("/report").permitAll()
			.antMatchers("/jasper/**").permitAll()
			.antMatchers("/webjars/**").permitAll()
			.antMatchers("/ng-templates/**").permitAll()
			.antMatchers("/rest/**").permitAll()
			.antMatchers("/js/**").permitAll()

			.anyRequest().fullyAuthenticated().and().formLogin()
			.loginPage("/login").failureUrl("/login?error").permitAll()

			.and().logout().logoutRequestMatcher(
					new AntPathRequestMatcher("/logout")).permitAll()
					.logoutSuccessUrl("/login?logout");

		}
	}

    @Autowired
    private MessageSource messageSource;

    @Bean
    public LocalValidatorFactoryBean validator()
    {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }

    @Override
    public Validator getValidator()
    {
        return validator();
    }
}
