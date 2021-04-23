package fr.erickfranco.cv_api.configurations.auth;

import fr.erickfranco.cv_api.models.Utilisateur;
import fr.erickfranco.cv_api.services.serviceinter.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoPlusToken implements TokenEnhancer {
    @Autowired
    private final IUtilisateurService iUtilisateurService;

    public InfoPlusToken(IUtilisateurService iUtilisateurService) {
        this.iUtilisateurService = iUtilisateurService;
    }


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Utilisateur utilisateur = iUtilisateurService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("info_plus", "Hello ça va!: ".concat(authentication.getName()));
        info.put("prenom", utilisateur.getPrenom());
        info.put("nom", utilisateur.getNom());
        info.put("email", utilisateur.getEmail());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
