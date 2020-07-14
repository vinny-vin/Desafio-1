package com.Challenge.ChallengeOne;

import com.Challenge.ChallengeOne.Model.Arquivo;
import com.Challenge.ChallengeOne.Service.Impl.ArquivoServiceImpl;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Challenge.ChallengeOne.Service.ArquivoService;
import java.util.Scanner;


@SpringBootApplication
public class CharllengeOneApplication{

	public static ArquivoServiceImpl serviceimpl = new ArquivoServiceImpl();
	public static CharllengeOneApplication app = new CharllengeOneApplication();
	public static Arquivo arquivo = new Arquivo();
	public static void main(String args[]) throws DbxException {


	serviceimpl.Define(arquivo);
	serviceimpl.list(arquivo);
	serviceimpl.add(arquivo);









	}
}