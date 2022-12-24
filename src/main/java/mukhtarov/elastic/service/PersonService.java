package mukhtarov.elastic.service;

import lombok.RequiredArgsConstructor;
import mukhtarov.elastic.document.Person;
import mukhtarov.elastic.repository.PersonRepository;
import org.springframework.stereotype.Service;

/**
 * @author 'Mukhtarov Sarvarbek' on 17.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    public void save(final Person person) {
        this.personRepository.save(person);
    }

    public Person findById(final String id) {
        return personRepository.findById(id).orElse(null);
    }
}
