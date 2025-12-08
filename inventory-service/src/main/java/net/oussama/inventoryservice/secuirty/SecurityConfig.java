package net.oussama.inventoryservice.secuirty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    /* la securite dans spring est organisse sous forme de cocuhe successivers
    * chaque requete http travers plusieurs niveaux de protetion
    * */
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http
                /*
                * CSRF est une attaque qui force un utilisateur authentifié à exécuter une action non désirée sur un site web.
                 Elle exploite le fait que le navigateur envoie automatiquement les cookies liés au site.
                 *Le serveur génère un token unique pour chaque formulaire.
                 * SameSite Cookie
                  Configure les cookies avec SameSite=Lax ou Strict.
                   Les cookies ne sont pas envoyés pour les requêtes venant d’un autre site.
                 * */
                /* attaque de type Clickjacking alors framesecurity si
                 une aoption qui permet interdit de des personne a afifche notre
                 site sur des frame pour ne maniplue pas notre site
                * */
                .headers(h->h.frameOptions(fo->fo.disable()))
                .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(ar->ar.requestMatchers("/api/*","/h2-console/**").permitAll())
                .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                .build();
    }
}
