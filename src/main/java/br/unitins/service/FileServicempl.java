package br.unitins.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class FileServicempl implements FileService{
    ///                                                                      isso e isso / ou \
    private final String PATH_USER = System.getProperty("user.home") + File.separator + "quarkus" + File.separator + "images" + File.separator + "usuaria" + File.separator ;

    @Override
    public String salvarImagemUsuario(byte[] imagem, String nomeImagem) throws IOException {

        //verificar o tipo da imagem
        String mineType = Files.probeContentType(new File(nomeImagem).toPath());

        List<String> listMineType = Arrays.asList("image/jpg","image/png","image/gif");

        //alerta de tipo de images
        if (!listMineType.contains(mineType)) {
            throw new IOException("imagem na suportada");
        }

        //alerta de tamanho 
        if (imagem.length > (1024 * 1024 *10)) {
            throw new IOException("tamanha não suportado ");
        }

        //verifica se tem a pasta 
        File diretorio = new File(PATH_USER);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        // gerando o nome do arquivo 
        String nomeArquivo = UUID.randomUUID() +"." +mineType.substring(mineType.lastIndexOf("/")+1);

        String path = PATH_USER + nomeArquivo;

        //salvar
        File file = new File(path);
        if (file.exists()) {
            throw new IOException("o nome gerado da imagem esta sendo usado");
        }

        //criando um arquivo no S.O.
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
        File file = new File(nomeArquivo);

        return file;
    }
    
}
