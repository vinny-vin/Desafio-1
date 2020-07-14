package com.Challenge.ChallengeOne.Service.Impl;

import com.Challenge.ChallengeOne.Model.Arquivo;
import com.Challenge.ChallengeOne.Service.ArquivoService;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ArquivoServiceImpl implements ArquivoService {

    private static final String ACCESS_TOKEN = "AppNH1QWVwAAAAAAAAAAFy12rci_vHiJvJ8kmBrYh1VdNs9MbQAIgntV-rWQW1MR";
    DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/desafio").build();
    DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    Scanner ler = new Scanner(System.in);



    public ArquivoServiceImpl() {

    }


    @Override
    public Arquivo Define(Arquivo arquivo) {

        System.out.println("Digite o nome da pasta a ser monitorada");
        arquivo.setPasta(ler.next());

        return arquivo;

    }

    @Override
    public Arquivo add(Arquivo arquivo) {

        System.out.println("Digite o nome do arquivo que deseja adicionar");
        arquivo.setNome(ler.next());

        try (
                InputStream in = new FileInputStream(arquivo.getNome())) {
            FileMetadata metadata = client.files().uploadBuilder(arquivo.getPasta())
                    .uploadAndFinish(in);
        }
        catch (Exception e){
//            System.out.println("Digite um arquivo existente");
        }

        return arquivo;
    }

    @Override
    public List<Arquivo> list(Arquivo arquivo) throws DbxException {
        ListFolderResult result = client.files().listFolder(arquivo.getPasta());
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }
        return list(arquivo);
    }


}
