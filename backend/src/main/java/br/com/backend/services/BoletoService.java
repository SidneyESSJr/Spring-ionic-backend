package br.com.backend.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import java.util.Calendar;

import br.com.backend.domains.PagamentoComBoleto;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instante) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instante);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDataVencimento(cal.getTime());
    }

}
