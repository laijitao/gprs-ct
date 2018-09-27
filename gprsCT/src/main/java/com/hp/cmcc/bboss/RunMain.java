package com.hp.cmcc.bboss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import com.hp.cmcc.bboss.main.DoMain;

@SpringBootApplication
@PropertySource(value={"file:../config/application.properties"})
//@PropertySource(value={"file:C:/Users/Administrator/Desktop/conf/application.properties"})
public class RunMain {
	public static void main(String[] args) {
		SpringApplication.run(RunMain.class, args);
		DoMain doMain = new DoMain();
		doMain.doTask();
	}
}
