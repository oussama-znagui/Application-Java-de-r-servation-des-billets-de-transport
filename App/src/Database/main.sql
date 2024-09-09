-- DB SCRIPT FOR AppV1

CREATE TYPE PartnerStatus AS ENUM('ACTIVE','EXPIRED','SUSPENDED');
CREATE TYPE Transport AS ENUM('AIRPLANE','TRAIN','BUS');
CREATE TYPE ContractStatus AS ENUM('ONGOING','FINISHED','SUSPENDED');
CREATE TYPE Discount AS ENUM('PERCENTAGE','AMOUNT');
CREATE TYPE OfferStatus AS ENUM('ACTIVE','EXPIRED','SUSPENDED');
CREATE TYPE TicketStatus AS ENUM('SOLD','CANCELED','AWAITING');




CREATE TABLE Partners(
                         id SERIAL PRIMARY KEY,
                         companyName varchar,
                         contactCommercial varchar,
                         transportType Transport,
                         geographicalArea varchar,
                         conditionsSpeciales text,
                         status PartnerStatus,
                         creationDate date
);

CREATE TABLE Contracts(
                          id SERIAL PRIMARY KEY,
                          startDate date,
                          endDate date,
                          specialRate float,
                          termsOfAgreement text,
                          renewable boolean,
                          status ContractStatus,
                          partnerID int

);

CREATE TABLE Offers(
                       id SERIAL PRIMARY KEY,
                       offerName varchar,
                       description text,
                       startDate date,
                       endDate date,
                       discountType Discount,
                       discountValue float,
                       conditions text,
                       status OfferStatus,
                       contractID int
);

CREATE TABLE Tickets(
                        id SERIAL PRIMARY KEY,
                        transportType Transport,
                        purchasePrice float,
                        salePrice float,
                        saleDate date,
                        status TicketStatus,
                        contractID int
);

ALTER TABLE Contracts
    ADD FOREIGN KEY (PartnerID) REFERENCES Partners(id);


ALTER TABLE Offers
    ADD FOREIGN KEY (ContractID) REFERENCES Contracts(id);

ALTER TABLE Tickets
    ADD FOREIGN KEY (ContractID) REFERENCES Contracts(id);



-- DB SCRIPT FOR AppV2

CREATE TABLE Clients(
    userName varchar,
    email varchar PRIMARY KEY not null ,
    phone varchar
);


