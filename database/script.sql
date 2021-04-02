--
-- Name: tb_cars; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_cars (
    id bigint NOT NULL,
    brand character varying(255),
    created timestamp without time zone,
    description character varying(250),
    sold boolean,
    update timestamp without time zone,
    vehicle character varying(255),
    year integer
);


--
-- Name: tb_cars_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.tb_cars ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_cars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: tb_cars tb_cars_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_cars
    ADD CONSTRAINT tb_cars_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

