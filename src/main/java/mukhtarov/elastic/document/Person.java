package mukhtarov.elastic.document;

import lombok.Getter;
import lombok.Setter;
import mukhtarov.elastic.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * @author 'Mukhtarov Sarvarbek' on 17.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
@Document(indexName = Indices.PERSON_INDEX)
@Setting(settingPath = "static/es-settings.json")
@Getter
@Setter
public class Person {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Text)
    private String surname;

    @Field(type = FieldType.Text)
    private String phone;

}
