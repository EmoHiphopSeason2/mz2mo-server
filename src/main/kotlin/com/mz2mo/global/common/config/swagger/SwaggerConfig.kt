package com.mz2mo.global.common.config.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI {
        val info: Info = Info()
            .title("mz2mo API 명세서")
            .version("v0.0.1")
            .description("mz2mo API 명세서입니다.")
        return OpenAPI()
            .components(Components())
            .info(info)
    }
}
