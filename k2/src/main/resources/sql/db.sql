CREATE DATABASE voiture;

\c voiture;

create user voiture_db_manager password '012345';


GRANT CONNECT ON DATABASE voiture TO "voiture_db_manager" ;
GRANT CREATE ON SCHEMA public TO "voiture_db_manager";
GRANT SELECT,INSERT,UPDATE,DELETE ON ALL TABLES IN SCHEMA public TO "voiture_db_manager";