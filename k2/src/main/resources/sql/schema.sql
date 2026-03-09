CREATE TYPE marque_type AS ENUM ('KIA', 'HYUNDAI', 'DAEWOO');
CREATE TYPE modele_type AS ENUM ('GETZ', 'PRIDE', 'LACETTI');
CREATE TABLE Modele_voiture (
    id SERIAL PRIMARY KEY,
    marque marque_type NOT NULL,
    modele modele_type NOT NULL
);

CREATE TABLE Piece_auto (
    id SERIAL PRIMARY KEY,
    id_modele_voiture INT NOT NULL,
    numero_serie VARCHAR(50) NOT NULL,
    prix DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_modele_voiture) REFERENCES Modele_voiture(id)
);

CREATE TABLE Vente (
    id SERIAL PRIMARY KEY,
    id_piece_auto INT NOT NULL,
    quantite INT NOT NULL,
    FOREIGN KEY (id_piece_auto) REFERENCES Piece_auto(id)
);

SELECT mv.marque, SUM(v.quantite) AS nbrePiece
FROM Modele_voiture mv
JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
JOIN Vente v ON pa.id = v.id_piece_auto
GROUP BY mv.marque;

SELECT
  SUM(CASE WHEN mv.modele = 'GETZ' THEN v.quantite ELSE 0 END) AS nb_GETZ,
  SUM(CASE WHEN mv.modele = 'PRIDE' THEN v.quantite ELSE 0 END) AS nb_PRIDE,
  SUM(CASE WHEN mv.modele = 'LACETTI' THEN v.quantite ELSE 0 END) AS nb_LACETTI
FROM Modele_voiture mv
JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
JOIN Vente v ON pa.id = v.id_piece_auto;

SELECT SUM(pa.prix * v.quantite) AS totalPrixKIA
FROM Modele_voiture mv
JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
JOIN Vente v ON pa.id = v.id_piece_auto
WHERE mv.marque = 'KIA';