CREATE TABLE IF NOT EXISTS public.providers
(
    id uuid NOT NULL,
    name character varying(255),
    CONSTRAINT providers_pkey PRIMARY KEY (id)
)