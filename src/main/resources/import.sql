/* On cree quelque utilisateur aves ses roles*/

INSERT INTO `utilisateurs` (username, password, enabled, prenom, nom, email) VALUES ('andres','$2a$10$H8WtIeG8BZ7mI54s1lVL8usfXFMmXjNsDs1q8gBQc3lXvGMSniFFC',1, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO `utilisateurs` (username, password, enabled, prenom, nom, email) VALUES ('admin','$2a$10$abHi8jtiD4deuHR52G6C5OzwxYZ/EelgefqNa.PLBcVMGTFogWMtG',1, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO `roles` (prenom) VALUES ('ROLE_USER');
INSERT INTO `roles` (prenom) VALUES ('ROLE_ADMIN');

INSERT INTO `utilisateurs_roles` (utilisateur_id, role_id) VALUES (1, 1);
INSERT INTO `utilisateurs_roles` (utilisateur_id, role_id) VALUES (2, 2);
INSERT INTO `utilisateurs_roles` (utilisateur_id, role_id) VALUES (2, 1);