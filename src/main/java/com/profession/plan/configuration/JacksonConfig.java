/**
 * @Title: JacksonConfig.java
 * @Package com.profession.plan.configuration
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年5月18日
 * @version V1.0
 */
package com.profession.plan.configuration;

import java.io.IOException;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @ClassName: JacksonConfig
 * @Description: TODO
 * @author 熊正胜
 * @date 2019年5月18日
 *
 */
@Configuration
public class JacksonConfig {

	@Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
 
        // 字段保留，将null值转为""
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
	        @Override
	        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
	        		throws IOException, JsonProcessingException {
	        	jsonGenerator.writeString("");
	        }
        });
        return objectMapper;

    }
}
