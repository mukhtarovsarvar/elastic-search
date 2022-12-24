package mukhtarov.elastic.controller;

import lombok.RequiredArgsConstructor;
import mukhtarov.elastic.service.IndexService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 'Mukhtarov Sarvarbek' on 19.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
@RestController
@RequestMapping("/api/index")
@RequiredArgsConstructor
public class IndexController {

    private final IndexService indexService;

    @PostMapping("/recreate")
    public void recreateAllIndices() {
        indexService.recreateIndices(true);
    }
}
