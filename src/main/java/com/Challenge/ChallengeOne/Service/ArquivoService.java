package com.Challenge.ChallengeOne.Service;

import com.Challenge.ChallengeOne.Model.Arquivo;
import com.dropbox.core.DbxException;

import java.util.List;

public interface ArquivoService {

    Arquivo Define(Arquivo arquivo);

    Arquivo add(Arquivo arquivo);

    List<Arquivo> list(Arquivo arquivo) throws DbxException;
}
