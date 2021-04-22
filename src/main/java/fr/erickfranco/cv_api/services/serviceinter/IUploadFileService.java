package fr.erickfranco.cv_api.services.serviceinter;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

    public Resource chargerPhoto(String nomPhoto) throws MalformedURLException;

    public String enregistrerPhoto(MultipartFile dossier) throws IOException;

    public boolean effacerPhoto(String nomPhoto);

    public Path getPath(String nomPhoto);


}
