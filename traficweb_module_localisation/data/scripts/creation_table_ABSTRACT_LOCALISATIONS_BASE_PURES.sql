-- Table: public.abstract_localisations_base_pures

/* Détruit la TABLE public.abstract_localisations_base_pures ainsi que la TABLE FILLE */
DROP TABLE IF EXISTS public.abstract_localisations_base_pures CASCADE;

/* Crée la SEQUENCE public.abstract_localisations_base_p_id_abstractlocalisationbasepu_seq. */
CREATE SEQUENCE public.abstract_localisations_base_p_id_abstractlocalisationbasepu_seq;

CREATE TABLE public.abstract_localisations_base_pures
(
    id_abstractlocalisationbasepur bigint NOT NULL DEFAULT nextval('abstract_localisations_base_p_id_abstractlocalisationbasepu_seq'::regclass),
    route character varying(255) COLLATE pg_catalog."default",
    cumul real,
    cote character varying(255) COLLATE pg_catalog."default",   
    voie integer,
    CONSTRAINT abstract_localisations_base_pures_pkey PRIMARY KEY (id_abstractlocalisationbasepur),
    CONSTRAINT unicite_route_cumul_lateralisation UNIQUE (route, cumul, cote, voie)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.abstract_localisations_base_pures
    OWNER to postgres;

-- Index: index_route

DROP INDEX IF EXISTS public.index_route;

CREATE INDEX index_route
    ON public.abstract_localisations_base_pures USING btree
    (route COLLATE pg_catalog."default")
    TABLESPACE pg_default;