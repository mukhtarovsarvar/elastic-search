package mukhtarov.elastic.search;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 'Mukhtarov Sarvarbek' on 24.12.2022
 * @project elastic
 * @contact @sarvargo
 */
@Setter
@ToString
public class PageRequestDTO {
    private static final int DEFAULT_SIZE = 100;
    private int page;
    private int size;

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size != 0 ? size : DEFAULT_SIZE;
    }
}
