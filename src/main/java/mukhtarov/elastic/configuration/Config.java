package mukhtarov.elastic.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author 'Mukhtarov Sarvarbek' on 17.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "mukhtarov.elastic.repository")
@ComponentScan(basePackages = {"mukhtarov.elastic"})
public class Config extends AbstractElasticsearchConfiguration {

    @Value("${elasricsearch.url}")
    public String elasticSearchUrl;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration config = ClientConfiguration
                .builder()
                .connectedTo(elasticSearchUrl)
                .build();

        return RestClients.create(config).rest();
    }
}
