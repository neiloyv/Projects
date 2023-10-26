package neilo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class ApplicationConfiguration {

//    private final Logger log = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @PostConstruct
    public void logStartServer() {
        log.info("===================================");
        log.info("!!!Application is loaded!!!");
        log.info("===================================");
    }

}
