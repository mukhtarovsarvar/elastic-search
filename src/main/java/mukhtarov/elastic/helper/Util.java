package mukhtarov.elastic.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.classfile.ClassParser;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author 'Mukhtarov Sarvarbek' on 18.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */
@Slf4j
public class Util {

    public static String loadAsString(final String path) {

        try {
            final File resource = new ClassPathResource(path).getFile();
            return new String(Files.readAllBytes(resource.toPath()));
        } catch (IOException e) {
            log.error(e.getMessage(),e);
            return null;
        }
    }

}
