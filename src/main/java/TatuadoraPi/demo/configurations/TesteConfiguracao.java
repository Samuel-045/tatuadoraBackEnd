package TatuadoraPi.demo.configurations;

import TatuadoraPi.demo.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.text.ParseException;

@Configuration
@Profile("homologacao")
public class TesteConfiguracao {
    @Autowired
    DBService dbService;

    private boolean instanciar() throws ParseException {
        this.dbService.instanciarDB();
        return true;
    }
}
