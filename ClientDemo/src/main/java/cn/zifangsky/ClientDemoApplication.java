package cn.zifangsky;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ServletComponentScan
@PropertySource({"license-config.properties"}) //加载额外的配置
public class ClientDemoApplication {

	public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ClientDemoApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
	}
}
