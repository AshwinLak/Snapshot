package com.example.Snapshot;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.Snapshot")
public class SnapshotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapshotApplication.class, args);
	}

}
