INSERT INTO Customer VALUES (1, 'madhu','lal','mlal@gmail.com');
INSERT INTO Customer VALUES (2, 'james', 'bond','alex@yahoo.com');
INSERT INTO Customer VALUES (3, 'jason','bourne', 'joel@gmail.com');

INSERT INTO CONTACT_INFO (id,address, city, state, country, pin, contact_number, mobile, email, web)
VALUES (1, 'First Floor, Kesavam, BNRA-1, Bhagavathy Nagar, Vellanad P O', 'Trivandrum','Kerala','India','695543','0472-2882415','9567062473','contactus@mare.com','www.mare.com');

INSERT INTO ORGANIZATION (id, name, notes, contact_info_id)
VALUES (1,'Mozanta Technologies', 'The Default Organization', 1);

INSERT INTO USER (email, password_hash, role, organization_id, contact_info_id)
VALUES ('demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'SUPER_ADMIN', 1, 1);

INSERT INTO ORGANIZATION (name, notes, contact_info_id)
VALUES ('Test', 'Test', 1);

INSERT INTO USER (email, password_hash, role, organization_id, contact_info_id)
VALUES ('test@test', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ORGANIZATION_ADMIN', 2, 1);

INSERT INTO STORE (name, notes, organization_id)
VALUES ('TestStore', 'Test', 2);

INSERT INTO USER (email, password_hash, role, organization_id)
VALUES ('manager@test', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'STORE_ADMIN', 2);


INSERT INTO USER (email, password_hash, role, organization_id)
VALUES ('user@test', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'USER', 2);

