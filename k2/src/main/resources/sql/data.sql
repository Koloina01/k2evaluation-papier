INSERT INTO Modele_voiture (marque, modele) VALUES
('KIA', 'GETZ'),      
('KIA', 'PRIDE'),      
('HYUNDAI', 'GETZ'),   
('HYUNDAI', 'PRIDE'),  
('DAEWOO', 'LACETTI');

INSERT INTO Piece_auto (id_modele_voiture, numero_serie, prix) VALUES
(1, 'KIA-G-001', 100.00),
(1, 'KIA-G-002', 150.00),
(2, 'KIA-P-001', 120.00),
(3, 'HYU-G-001', 130.00),
(4, 'HYU-P-001', 110.00),
(5, 'DAE-L-001', 200.00);

INSERT INTO Vente (id_piece_auto, quantite) VALUES
(1, 4), 
(2, 3),  
(3, 3), 
(4, 2),  
(5, 3),
(6, 1);