package br.unitins.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class FileServicempl implements FileService{

    private static final Logger LOG = Logger.getLogger(FileServicempl.class);
    ///                                                                      isso e isso / ou \  : Users
    private final String PATH_USER = System.getProperty("user.home") +
     File.separator + "quarkus" +
      File.separator + "images" +
       File.separator + "usuaria" +
        File.separator ;

    @Override
    public String salvarImagemUsuario(byte[] imagem, String nomeImagem) throws IOException {

        //
        LOG.info("Verificar o tipo da imagem");
        String mineType = Files.probeContentType(new File(nomeImagem).toPath());

        List<String> listMineType = Arrays.asList("image/jpg","image/png","image/gif");

        //
        LOG.info("alerta de tipo de images");
        if (!listMineType.contains(mineType)) {
            LOG.info("ERRO imagen não suportada");
            throw new IOException("imagem na suportada");
        }

        //
        LOG.info("alerta de tamanho"); 
        if (imagem.length > (1024 * 1024 *10)) {
            LOG.info("ERRO de tamanho");
            throw new IOException("tamanha não suportado ");
        }

        // 
        LOG.info("verifica se tem a pasta");
        File diretorio = new File(PATH_USER);
        if (!diretorio.exists()) {
            LOG.info("ERRO criando diretorio");
            diretorio.mkdirs();
        }

        //  
        LOG.info("gerando o nome do arquivo");
        String nomeArquivo = UUID.randomUUID() +"." +mineType.substring(mineType.lastIndexOf("/")+1);

        String path = PATH_USER + nomeArquivo;

        //
        LOG.info("salvar");
        File file = new File(path);
        if (file.exists()) {
            LOG.info("ERRO na hora de salvar");
            throw new IOException("o nome gerado da imagem esta sendo usado");
        }

        //criando um arquivo no S.O.
        LOG.info("criando no sistema");
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagem);

        //garnatindo que mando o ultimo lote de byte
        fos.flush();
        fos.close();

        return nomeArquivo;
    }

    @Override
    public File download(String nomeArquivo) {
        File file = new File(PATH_USER + nomeArquivo);

        return file;
    }
    
}
