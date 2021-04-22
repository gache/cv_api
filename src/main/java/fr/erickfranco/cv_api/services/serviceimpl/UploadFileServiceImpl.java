package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.services.serviceinter.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);
    private final static String DOSSIER_UPLOAD = "uploads";

    @Override
    public Resource chargerPhoto(String nomPhoto) throws MalformedURLException {
        Path routeDossier = getPath(nomPhoto);
        log.info(routeDossier.toString());

        Resource resource = new UrlResource(routeDossier.toUri());

        if (!resource.exists() && !resource.isReadable()) {
            routeDossier = Paths.get("src/main/resources/static/images").resolve("noImage.png").toAbsolutePath();

            resource = new UrlResource(routeDossier.toUri());
            log.error("Error no se pudo cargar la imagen: " + nomPhoto);
        }
        return resource;
    }

    @Override
    public String enregistrerPhoto(MultipartFile dossier) throws IOException {
        String nomDossier = UUID.randomUUID().toString() + "_" + dossier.getOriginalFilename().replace(" ", "");
        Path routeDossier = getPath(nomDossier);
        log.info(routeDossier.toString());

        Files.copy(dossier.getInputStream(), routeDossier);

        return nomDossier;
    }

    @Override
    public boolean effacerPhoto(String nomPhoto) {
        if (nomPhoto != null && nomPhoto.length() > 0) {
            Path routePhotoAnterieur = Paths.get("uploads").resolve(nomPhoto).toAbsolutePath();
            File dossierPhotoAnterieur = routePhotoAnterieur.toFile();
            if (dossierPhotoAnterieur.exists() && dossierPhotoAnterieur.canRead()) {
                dossierPhotoAnterieur.delete();
                return true;
            }
        }
        return false;
    }

    @Override
    public Path getPath(String nomPhoto) {
        return Paths.get(DOSSIER_UPLOAD).resolve(nomPhoto).toAbsolutePath();
    }
}
