
CREATE SEQUENCE public.abstract_localisations_base_pures_id_sequence;

CREATE TABLE public.abstract_localisations_base_pures (
                id_abstractlocalisationbasepur BIGINT NOT NULL DEFAULT nextval('public.abstract_localisations_base_pures_id_sequence'),
                route VARCHAR,
                cumul REAL,
                cote VARCHAR,
                voie INTEGER,
                CONSTRAINT abstract_localisations_base_pures_pk PRIMARY KEY (id_abstractlocalisationbasepur)
);
COMMENT ON COLUMN public.abstract_localisations_base_pures.id_abstractlocalisationbasepur IS 'SEQUENCE';


ALTER SEQUENCE public.abstract_localisations_base_pures_id_sequence OWNED BY public.abstract_localisations_base_pures.id_abstractlocalisationbasepur;

CREATE INDEX public_index_route
 ON public.abstract_localisations_base_pures
 ( route );

CREATE UNIQUE INDEX public_unicite_route_cumul_lateralisation
 ON public.abstract_localisations_base_pures
 ( route, cumul, cote, voie );

CREATE TABLE public.localisations_base_pures (
                id_abstractlocalisationbasepur BIGINT NOT NULL,
                CONSTRAINT localisations_base_pures_pk PRIMARY KEY (id_abstractlocalisationbasepur)
);


ALTER TABLE public.localisations_base_pures ADD CONSTRAINT public_abstract_localisations_base_pures_public_localisation940
FOREIGN KEY (id_abstractlocalisationbasepur)
REFERENCES public.abstract_localisations_base_pures (id_abstractlocalisationbasepur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
