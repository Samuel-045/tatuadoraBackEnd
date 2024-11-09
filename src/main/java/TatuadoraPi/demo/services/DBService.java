package TatuadoraPi.demo.services;

import java.text.ParseException;

import TatuadoraPi.demo.entidades.Pessoa;
import TatuadoraPi.demo.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @Bean
    public void instanciarDB() throws ParseException {

        Pessoa pessoa1 = new Pessoa("Samuel","1234","53.285.479-2","547.059.258-82",
                "02.577.577/0001-00","123.456.789.963");

    }

}
