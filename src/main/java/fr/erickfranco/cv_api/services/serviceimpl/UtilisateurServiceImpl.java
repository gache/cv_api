package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.models.Utilisateur;
import fr.erickfranco.cv_api.repositories.UtilisateurRepository;
import fr.erickfranco.cv_api.services.serviceinter.IUtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Erick Franco
 */
@Service
public class UtilisateurServiceImpl implements IUtilisateurService, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur == null) {
            logger.error("Erreur dans le login: n'existe pas un utilisateur'" + username + "' dasn le système!");
            throw new UsernameNotFoundException(
                    "Erreur dans le login: n'existe pas un utilisateur'" + username + "' dasn le système!");
        }

        List<GrantedAuthority> authorities = utilisateur.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getPrenom()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

        return new User(utilisateur.getUsername(), utilisateur.getPassword(), utilisateur.getEnabled(), true, true, true, authorities);
    }

    @Override
    public Utilisateur findByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }
}
