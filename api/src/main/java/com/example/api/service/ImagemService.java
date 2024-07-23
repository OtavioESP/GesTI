package com.example.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.example.api.domain.imagem.Imagem;
import com.example.api.domain.imagem.ImagemRequestDTO;
import com.example.api.domain.tarefa.Tarefa;
import com.example.api.repositories.ImagemRepository;
import com.example.api.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.bucket.name}")
    private String awsBucket;


    public Imagem createImagem(ImagemRequestDTO data) {
        String imgKey = null;

        if (data.imagem() != null) {
            imgKey = this.uploadImg(data.imagem());
        }

        Tarefa tarefa = tarefaRepository.findById(data.tarefaId()).orElse(null);

        Imagem newImagem = new Imagem();
        newImagem.setKey(imgKey);
        newImagem.setTarefa(tarefa);
        imagemRepository.save(newImagem);

        return newImagem;
    }

    private String uploadImg(MultipartFile imagem) {
//        String nomeImg = UUID.randomUUID() + "-" + imagem.getOriginalFilename();
//
//        try {
//            File file = this.convertMultipartToTile(imagem);
//        s3Client.putObject(awsBucket, nomeImg, file);
//        file.delete();
//        reutrn s3Client.getUrl().toString();
//        } catch (Exception exc) {
//          System.out.println("Erro no upload do arquivo");
//        return null
//        }
        return "teste";
    }

//    private File convertMultipartToTile(MultipartFile arquivo) {
//        File arquivoConv = new File(arquivo.getOriginalFilename());
//        FileOutputStream fos = new FileOutputStream(arquivoConv);
//        fos.write(arquivo.getBytes());
//        fos.close();
//        return arquivoConv
//    }
}
