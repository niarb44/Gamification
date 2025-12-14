--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2025-01-11 16:55:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 24673)
-- Name: levels; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.levels (
    id bigint NOT NULL,
    theme character varying(255),
    level_number integer,
    name character varying(255)
);


ALTER TABLE public.levels OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24678)
-- Name: levels_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.levels_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.levels_id_seq OWNER TO postgres;

--
-- TOC entry 4868 (class 0 OID 0)
-- Dependencies: 218
-- Name: levels_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.levels_id_seq OWNED BY public.levels.id;


--
-- TOC entry 219 (class 1259 OID 24689)
-- Name: tasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tasks (
    id bigint NOT NULL,
    name character varying(255),
    points integer,
    completed boolean,
    user_id integer NOT NULL
);


ALTER TABLE public.tasks OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24692)
-- Name: tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tasks ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tasks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 24699)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(255),
    password character varying(255),
    points integer,
    level integer,
    theme character varying(255) DEFAULT 'default'::character varying
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24705)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1
);


--
-- TOC entry 4705 (class 2604 OID 24706)
-- Name: levels id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.levels ALTER COLUMN id SET DEFAULT nextval('public.levels_id_seq'::regclass);


--
-- TOC entry 4857 (class 0 OID 24673)
-- Dependencies: 217
-- Data for Name: levels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.levels (id, theme, level_number, name) FROM stdin;
1	fantasy	1	Apprentice Mage
2	fantasy	2	Knight
3	fantasy	3	Dragon Slayer
4	sci-fi	1	Cadet
5	sci-fi	2	Space Explorer
6	sci-fi	3	Galaxy Conqueror
7	action	1	Rookie Agent
8	action	2	Specialist
9	action	3	Elite Operative
10	default	1	Level 1
11	default	2	Level 2
12	default	3	Level 3
\.


--
-- TOC entry 4859 (class 0 OID 24689)
-- Dependencies: 219
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tasks (id, name, points, completed, user_id) FROM stdin;
6	Example Task	50	t	2
7	Example Task 1	50	t	1
\.


--
-- TOC entry 4861 (class 0 OID 24699)
-- Dependencies: 221
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, username, password, points, level, theme) FROM stdin;
3	dawidgolebowski	1234	44	4	default
2	user2	h@123	20	2	default
1	user1	n@789	40	3	sci-fi
0	User66	$2a$10$Mw3SRMN7tL4iVTpC93HdEe.xh346R3BhweHy58ppKBAIWVh.tjsDK	0	0	\N
4	Ka	$2a$10$tPiDzbXu6korlLOGn972QeOf5dZK4FLuTvTZoKPxZrT2K/4y0XRZO	0	0	\N
5	Bebe	$2a$10$gRkjC.Svlw9OHzFgJFKoAuVbMNd7CLrhNCv1mcsqkFktOgk6qP45u	0	0	\N
6	PePe	$2a$10$zIEsVmewC6gIfYlD4oPQNORWI6s1zw3eqxBR4Shp3W5C.EH4I3OpG	0	0	\N
7	1234	$2a$10$MzCctbizC8VnJIz9Cl0xVu7lU9y5NEnp0nR.VkWWaFOkNhv4D741S	0	0	\N
8	12345	$2a$10$4d1qvhk8bg6JqBReVH2n5uL0leS2FLI73Oyf2ry2tElmfPYpKDLH.	0	0	\N
9	KuKu	KuKu	0	0	\N
10	PoPo	PoPo	0	0	\N
11	user4	user4	0	0	\N
12	Ty	Ty	0	0	\N
13	UU	UU	0	0	\N
14	Qwe	$2a$12$tI0kyCrzQhUs0lcJkXlwLuR.Brpzlr0x.bVdLAKUOLTO0CjtVqt3e	0	0	\N
15	TG	$2a$12$QOS8JJ7MGlL/8YjfZv9RheK/gLPU.AFlluPUjRbfiSdBisAiQT8g.	0	0	\N
16	Pau	$2a$12$arULLnQtww4MkLNI2q6TNuHHFj3cvT.VxuFnSPSqW7JCmargANEMy	33	3	sci-fi
17	testuser	$2a$12$qNJRQ6Z.Z6QtgxT2NCKsBeBFHhngtV2DvhAVZsUC6zTvMHWHjD8eu\n	22	3	sci-fi
\.


--
-- TOC entry 4869 (class 0 OID 0)
-- Dependencies: 218
-- Name: levels_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.levels_id_seq', 12, true);


--
-- TOC entry 4870 (class 0 OID 0)
-- Dependencies: 220
-- Name: tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tasks_id_seq', 7, true);


--
-- TOC entry 4871 (class 0 OID 0)
-- Dependencies: 222
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 17, true);


--
-- TOC entry 4708 (class 2606 OID 24710)
-- Name: levels levels_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.levels
    ADD CONSTRAINT levels_pkey PRIMARY KEY (id);


--
-- TOC entry 4710 (class 2606 OID 24718)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4711 (class 2606 OID 24734)
-- Name: tasks user_locale_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT user_locale_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2025-01-11 16:55:06

--
-- PostgreSQL database dump complete
--

