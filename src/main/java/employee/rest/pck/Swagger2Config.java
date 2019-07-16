package employee.rest.pck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;


@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket api() {
		return new Docket(
				DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("employee.rest.pck"))
				//.paths(any)
				.paths(PathSelectors.regex("/employees.*"))
				//.paths(PathSelectors.ant("/employees.*"))
				.build()
				.apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder()
				.title("RESTful Web Service for Employee Data")
				.description("RESTful Web Service for Employee Data")
				.contact(new Contact("Ivayla Simova", null, "ivayla.simova@estafet.com"))
				.license("TestLicense")
				.licenseUrl("http://http://localhost:8081/test.html")
				.version("1.0.0")
				.build();
		
	}
}
