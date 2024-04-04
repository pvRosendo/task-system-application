CREATE TABLE IF NOT EXISTS public.tb_todo (
    id uuid NOT NULL,
    description character varying(255) NOT NULL,
    name_task character varying(255) NOT NULL,
    priority integer,
    status smallint NOT NULL
);