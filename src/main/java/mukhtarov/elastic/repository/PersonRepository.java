package mukhtarov.elastic.repository;

import mukhtarov.elastic.document.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 'Mukhtarov Sarvarbek' on 17.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
public interface PersonRepository extends ElasticsearchRepository<Person,String> {
}
