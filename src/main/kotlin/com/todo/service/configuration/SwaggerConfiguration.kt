package com.todo.service.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    fun serviceApi(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.todo.service"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(appMetaData())

    fun appMetaData(): ApiInfo = ApiInfoBuilder()
            .title("Todo Service REST API")
            .description("Rest Api for Todo App")
            .version("1.0.0")
            .license("Any Licence")
            .contact(Contact("Tugce Konuklar",
                    "https://www.linkedin.com/in/tugce-konuklar/",
                    "tkonuklar@gmail.com"))
            .build()
}