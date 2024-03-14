CREATE TABLE IF NOT EXISTS public.tb_done (
    id bigint NOT NULL,
    description character varying(255) NOT NULL,
    name_task character varying(255) NOT NULL,
    priority integer,
    status character varying(255) NOT NULL
);