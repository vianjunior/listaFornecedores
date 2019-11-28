CREATE TABLE public."FORNECEDORES"
(
    "IDFORNECEDOR" serial NOT NULL,
    "RAZAOSOCIAL" character varying(100),
    "EMAIL" character varying(100),
    "CNPJ" character varying(100),
    "OBS" character varying(100),
    CONSTRAINT "PK_FORNECEDOR" PRIMARY KEY ("IDFORNECEDOR")
)
COMMIT;


WITH (
    OIDS = FALSE
);
COMMIT;


ALTER TABLE public."FORNECEDORES"
    OWNER to postgres;
COMMIT;