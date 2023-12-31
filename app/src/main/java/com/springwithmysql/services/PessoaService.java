package com.springwithmysql.services;

import com.springwithmysql.dto.PessoaDTO;
import com.springwithmysql.entitys.PessoaEntity;
import com.springwithmysql.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO criarPessoa(PessoaDTO pessoa) {
        PessoaEntity pessoaEntity = new PessoaEntity(
                pessoa.getNome(),
                pessoa.getSobrenome(),
                pessoa.getEmail(),
                pessoa.getIdade()
        );

        pessoaEntity = pessoaRepository.save(pessoaEntity);
        pessoa.setId(pessoaEntity.getId());

        return pessoa;
    }

    public PessoaDTO getPessoa(Integer id) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(id).orElse(null);

        if (Objects.isNull(pessoaEntity))
            return null;

        PessoaDTO pessoaDTO = new PessoaDTO(
                pessoaEntity.getNome(),
                pessoaEntity.getSobrenome(),
                pessoaEntity.getEmail(),
                pessoaEntity.getIdade()
        );

        pessoaDTO.setId(pessoaEntity.getId());

        return pessoaDTO;
    }

    public List<PessoaDTO> getPessoas() {
        List<PessoaEntity> pessoasEntity = pessoaRepository.findAll();

        List<PessoaDTO> pessoas = new ArrayList<>();

        pessoasEntity.forEach(pessoa -> {
            PessoaDTO pessoaDTO = new PessoaDTO(
                    pessoa.getNome(),
                    pessoa.getSobrenome(),
                    pessoa.getEmail(),
                    pessoa.getIdade()
            );

            pessoaDTO.setId(pessoa.getId());

            pessoas.add(pessoaDTO);
        });

        return pessoas;
    }
}
