package open.source.reporter;

import open.source.reporter.util.StartupHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class OpenSourceReporterApp {

	public static void main(String[] args) {
		Environment env = new SpringApplication(OpenSourceReporterApp.class)
				.run(args)
				.getEnvironment();
		StartupHelper.logApplicationStartup(env);
	}
}
