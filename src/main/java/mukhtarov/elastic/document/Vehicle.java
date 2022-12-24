package mukhtarov.elastic.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author 'Mukhtarov Sarvarbek' on 18.12.2022
 * @project elastic
 * @contact @sarvargo
 */

@Getter
@Setter
public class Vehicle {

    private String id;

    private String number;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;


}
