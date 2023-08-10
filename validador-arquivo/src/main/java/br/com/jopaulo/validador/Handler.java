package br.com.jopaulo.validador;

import java.util.Arrays;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Handler implements RequestHandler<S3Event, String> {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Override
	public String handleRequest(S3Event input, Context context) {
		LambdaLogger logger = context.getLogger();
		
		var record = input.getRecords().get(0);
		String nomeObjeto = record.getS3().getObject().getUrlDecodedKey();
		String bucket = record.getS3().getBucket().getName();
		
		logger.log("Objeto: " + nomeObjeto);
		logger.log("Bucket: " + bucket);
		
		String[] tipos = System.getenv().get("tipos").split(",");
		
		var tipoObjeto = nomeObjeto.split("\\.")[1].toLowerCase();
		boolean valido = Arrays.stream(tipos).anyMatch(tipoObjeto::equals);
		
		if (!valido) {
			try {
				AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
				DeleteObjectRequest deleteObject = new DeleteObjectRequest(bucket, nomeObjeto);
				s3Client.deleteObject(deleteObject);
				
				logger.log("============= OBJETO INVÁLIDO =========");
				logger.log("Objeto excluído com sucesso");
				
				return "Arquivo " + nomeObjeto + " excluído com sucesso";
			} catch (AmazonServiceException e) {
				logger.log(e.getMessage());
			} catch (SdkClientException e) {
				logger.log(e.getMessage());
				throw new RuntimeException();
			}
		}
		
		logger.log("============= OBJETO VÁLIDO =========");
		
		return "Arquivo " + nomeObjeto + "validado";
	}

}
