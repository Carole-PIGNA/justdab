-- Création des utilisateurs conseillers
INSERT INTO user (id, nom, email) VALUES (1, 'Alice Dupont', 'alice.dupont@example.com');
INSERT INTO user (id, nom, email) VALUES (2, 'Bob Martin', 'bob.martin@example.com');

-- Création des clients
INSERT INTO user (id, nom, email) VALUES (3, 'Charles Dupuis', 'charles.dupuis@example.com');
INSERT INTO user (id, nom, email) VALUES (4, 'Diane Lefevre', 'diane.lefevre@example.com');

-- Création des conseillers
INSERT INTO conseiller (id, nom, email) VALUES (1, 'Alice Dupont', 'alice.dupont@example.com');
INSERT INTO conseiller (id, nom, email) VALUES (2, 'Bob Martin', 'bob.martin@example.com');

-- Création des comptes bancaires
INSERT INTO compteBancaire (id, solde, client_id) VALUES (1, 1000.00, 3);
INSERT INTO compteBancaire (id, solde, client_id) VALUES (2, 1500.00, 4);

-- Création des opérations
INSERT INTO operation (id, type, montant, dateOperation, compteBancaire_id) VALUES (1, 'Dépôt', 200.00, '2024-07-23T10:15:30', 1);
INSERT INTO operation (id, type, montant, dateOperation, compteBancaire_id) VALUES (2, 'Retrait', 50.00, '2024-07-23T11:00:00', 2);
INSERT INTO operation (id, type, montant, dateOperation, compteBancaire_id) VALUES (3, 'Transfert', 100.00, '2024-07-23T12:00:00', 1);
