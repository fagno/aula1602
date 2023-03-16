package pweb.aula1602.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    Long id;

    LocalDateTime dataEHorario;

    List<ItemVenda> itemVenda;


    //método construtor
    Venda(){
        itemVenda = new ArrayList<>();
        dataEHorario = LocalDateTime.now();
    }

}
