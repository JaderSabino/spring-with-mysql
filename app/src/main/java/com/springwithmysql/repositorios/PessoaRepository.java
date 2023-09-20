package com.springwithmysql.repositorios;

import com.springwithmysql.entitys.PessoaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class PessoaRepository {

    List<PessoaEntity> pessoas = new ArrayList<>();
    AtomicInteger atomicInteger = new AtomicInteger();
    public PessoaEntity criarPessoa(PessoaEntity pessoa) {
        pessoa.setId(atomicInteger.incrementAndGet());
        pessoas.add(pessoa);
        return pessoa;
    }

    public PessoaEntity getPessoa(Integer id) {
        PessoaEntity pessoaEntity = null;

        for (PessoaEntity pessoa : pessoas) {
            if (Objects.isNull(pessoaEntity) && pessoa.getId().equals(id)) {
                pessoaEntity = pessoa;
            }
        }

        return pessoaEntity;
    }
}
