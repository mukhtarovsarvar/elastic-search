package mukhtarov.elastic.service;

import lombok.extern.slf4j.Slf4j;
import mukhtarov.elastic.helper.Indices;
import mukhtarov.elastic.helper.Util;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author 'Mukhtarov Sarvarbek' on 18.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
@Service
@Slf4j
public class IndexService {
    private final List<String> INDICES = List.of(Indices.VEHICLE_INDEX);
    private final RestHighLevelClient client;

    @Autowired
    public IndexService(RestHighLevelClient client) {
        this.client = client;
    }


    @PostConstruct
    public void tryToCreateIndices() {
        recreateIndices(false);
    }

    public void recreateIndices(final boolean deleteExisting) {
        final String settings = Util.loadAsString("static/es-settings.json");

        for (final String indexName : INDICES) {
            try {
                boolean indexExists = client
                        .indices()
                        .exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);

                if (indexExists) {
                    if (!deleteExisting) {
                        continue;
                    }

                    client
                            .indices()
                            .delete(new DeleteIndexRequest(indexName),
                                    RequestOptions.DEFAULT
                            );
                }
                final CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);

                createIndexRequest.settings(settings, XContentType.JSON);

                final String mappings = loadMappings(indexName);

                if ( mappings != null) {
                    createIndexRequest.mapping(mappings,XContentType.JSON);
                }

                client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            } catch (final Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public String loadMappings(String indexName) {

        final String mappings = Util.loadAsString("static/mappings/" + indexName + ".json");

        if (mappings == null) {
            log.error("Field to create index with name {}", indexName);
            return null;
        }
        return mappings;
    }
}
