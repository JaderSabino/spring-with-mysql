package com.springwithmysql.controllers;

import com.springwithmysql.dto.PessoaDTO;
import com.springwithmysql.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;
    @PostMapping("/criar")
    public ResponseEntity<PessoaDTO> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO pessoaDto = pessoaService.criarPessoa(pessoaDTO);
        return ResponseEntity.ok(pessoaDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PessoaDTO> getPessoa(@PathVariable Integer id) {
        PessoaDTO pessoaDTO = pessoaService.getPessoa(id);
        if (Objects.isNull(pessoaDTO)) {
            return new ResponseEntity<>(new PessoaDTO("", "", "", 0), HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(pessoaDTO);
        }
    }

}
