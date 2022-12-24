package mukhtarov.elastic.controller;

import lombok.RequiredArgsConstructor;
import mukhtarov.elastic.document.Person;
import mukhtarov.elastic.service.PersonService;
import org.springframework.web.bind.annotation.*;

/**
 * @author 'Mukhtarov Sarvarbek' on 17.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("")
    public void save(@RequestBody final Person person) {
        personService.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") final String id) {
        return personService.findById(id);
    }
}
