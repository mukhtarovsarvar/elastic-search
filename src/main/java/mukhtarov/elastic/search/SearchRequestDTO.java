package mukhtarov.elastic.search;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.search.sort.SortOrder;

import java.util.List;

/**
 * @author 'Mukhtarov Sarvarbek' on 19.12.2022
 * @project elastic
 * @contact @sarvargo
 */
@Getter
@Setter
public class SearchRequestDTO extends PageRequestDTO {

    private List<String> fields;

    private String searchTerm;

    private String sortBy;

    private SortOrder order;
}
