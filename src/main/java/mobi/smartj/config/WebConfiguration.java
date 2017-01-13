package mobi.smartj.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import mobi.smartj.common.WebLoggingInterceptor;

@Configuration
@EnableWebMvc
/**
 * Spring BootのWeb設定を行うクラス
 * @author motoy3d
 * @see http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config-message-converters
 */
public class WebConfiguration extends WebMvcConfigurerAdapter {
	/**
	 * Webログ出力インターセプタ
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebLoggingInterceptor())
			.addPathPatterns("/**") // 適用対象のパス(パターン)を指定する
			.excludePathPatterns("/static/**"); // 除外するパス(パターン)を指定する
	}

	/**
	 * 自前クラスをJSONで返す時に、スネークケースでJSON生成するための設定
	 */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    	Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
//                .indentOutput(true)	//確認用
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
//                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))	//日付フォーマットも設定可能
                ;
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }
}