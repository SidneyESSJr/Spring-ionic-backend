
CREATE TABLE public.produto_categoria (
    produto_id integer NOT NULL,
    categoria_id integer NOT NULL
);


--
-- Name: tb_categoria; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_categoria (
    id integer NOT NULL,
    nome character varying(255)
);


--
-- Name: tb_categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_categoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_categoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_categoria_id_seq OWNED BY public.tb_categoria.id;


--
-- Name: tb_cidade; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_cidade (
    id integer NOT NULL,
    nome character varying(255),
    estado_id integer
);


--
-- Name: tb_cidade_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_cidade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_cidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_cidade_id_seq OWNED BY public.tb_cidade.id;


--
-- Name: tb_cliente; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_cliente (
    id integer NOT NULL,
    cpf_ou_cnpj character varying(255),
    email character varying(255),
    nome character varying(255),
    tipo integer
);


--
-- Name: tb_cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_cliente_id_seq OWNED BY public.tb_cliente.id;


--
-- Name: tb_endereco; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_endereco (
    id integer NOT NULL,
    bairro character varying(255),
    cep character varying(255),
    complemento character varying(255),
    logradouro character varying(255),
    numero character varying(255),
    id_cidade integer,
    id_cliente integer
);


--
-- Name: tb_endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_endereco_id_seq OWNED BY public.tb_endereco.id;


--
-- Name: tb_estado; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_estado (
    id integer NOT NULL,
    nome character varying(255)
);


--
-- Name: tb_estado_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_estado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_estado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_estado_id_seq OWNED BY public.tb_estado.id;


--
-- Name: tb_item_pedido; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_item_pedido (
    desconto double precision,
    preco double precision,
    quantidade integer,
    produto_id integer NOT NULL,
    pedido_id integer NOT NULL
);


--
-- Name: tb_pagamento; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_pagamento (
    pedido_id integer NOT NULL,
    estado_pagamento integer
);


--
-- Name: tb_pagamento_boleto; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_pagamento_boleto (
    data_pagamento timestamp without time zone,
    data_vencimento timestamp without time zone,
    pedido_id integer NOT NULL
);


--
-- Name: tb_pagamento_cartao; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_pagamento_cartao (
    numero_de_parcelas integer,
    pedido_id integer NOT NULL
);


--
-- Name: tb_pedido; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_pedido (
    id integer NOT NULL,
    instante timestamp without time zone,
    id_cliente integer,
    endereco_de_entrega_id integer
);


--
-- Name: tb_pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_pedido_id_seq OWNED BY public.tb_pedido.id;


--
-- Name: tb_produto; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_produto (
    id integer NOT NULL,
    nome character varying(255),
    preco double precision
);


--
-- Name: tb_produto_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_produto_id_seq OWNED BY public.tb_produto.id;


--
-- Name: tb_telefone; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_telefone (
    cliente_id integer NOT NULL,
    telefones character varying(255)
);


--
-- Name: tb_categoria id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_categoria ALTER COLUMN id SET DEFAULT nextval('public.tb_categoria_id_seq'::regclass);


--
-- Name: tb_cidade id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_cidade ALTER COLUMN id SET DEFAULT nextval('public.tb_cidade_id_seq'::regclass);


--
-- Name: tb_cliente id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_cliente ALTER COLUMN id SET DEFAULT nextval('public.tb_cliente_id_seq'::regclass);


--
-- Name: tb_endereco id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_endereco ALTER COLUMN id SET DEFAULT nextval('public.tb_endereco_id_seq'::regclass);


--
-- Name: tb_estado id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_estado ALTER COLUMN id SET DEFAULT nextval('public.tb_estado_id_seq'::regclass);


--
-- Name: tb_pedido id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pedido ALTER COLUMN id SET DEFAULT nextval('public.tb_pedido_id_seq'::regclass);


--
-- Name: tb_produto id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_produto ALTER COLUMN id SET DEFAULT nextval('public.tb_produto_id_seq'::regclass);


--
-- Name: tb_categoria tb_categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_categoria
    ADD CONSTRAINT tb_categoria_pkey PRIMARY KEY (id);


--
-- Name: tb_cidade tb_cidade_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_cidade
    ADD CONSTRAINT tb_cidade_pkey PRIMARY KEY (id);


--
-- Name: tb_cliente tb_cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_cliente
    ADD CONSTRAINT tb_cliente_pkey PRIMARY KEY (id);


--
-- Name: tb_endereco tb_endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT tb_endereco_pkey PRIMARY KEY (id);


--
-- Name: tb_estado tb_estado_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_estado
    ADD CONSTRAINT tb_estado_pkey PRIMARY KEY (id);


--
-- Name: tb_item_pedido tb_item_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_item_pedido
    ADD CONSTRAINT tb_item_pedido_pkey PRIMARY KEY (pedido_id, produto_id);


--
-- Name: tb_pagamento_boleto tb_pagamento_boleto_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pagamento_boleto
    ADD CONSTRAINT tb_pagamento_boleto_pkey PRIMARY KEY (pedido_id);


--
-- Name: tb_pagamento_cartao tb_pagamento_cartao_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pagamento_cartao
    ADD CONSTRAINT tb_pagamento_cartao_pkey PRIMARY KEY (pedido_id);


--
-- Name: tb_pagamento tb_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pagamento
    ADD CONSTRAINT tb_pagamento_pkey PRIMARY KEY (pedido_id);


--
-- Name: tb_pedido tb_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pedido
    ADD CONSTRAINT tb_pedido_pkey PRIMARY KEY (id);


--
-- Name: tb_produto tb_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_produto
    ADD CONSTRAINT tb_produto_pkey PRIMARY KEY (id);


--
-- Name: tb_cliente uk_ir2m70agseiyyajtaxq7wsw20; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_cliente
    ADD CONSTRAINT uk_ir2m70agseiyyajtaxq7wsw20 UNIQUE (email);


--
-- Name: tb_endereco fk1wlvil0y56h89uki97895gl5o; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT fk1wlvil0y56h89uki97895gl5o FOREIGN KEY (id_cidade) REFERENCES public.tb_cidade(id);


--
-- Name: tb_item_pedido fk3qvnhpdyxagngbf1t326cvnse; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_item_pedido
    ADD CONSTRAINT fk3qvnhpdyxagngbf1t326cvnse FOREIGN KEY (pedido_id) REFERENCES public.tb_pedido(id);


--
-- Name: tb_pagamento_cartao fk60pxg3xqim48dy397gry33t30; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pagamento_cartao
    ADD CONSTRAINT fk60pxg3xqim48dy397gry33t30 FOREIGN KEY (pedido_id) REFERENCES public.tb_pagamento(pedido_id);


--
-- Name: produto_categoria fkb5u1xuiroy0tls0b2odm8aj64; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.produto_categoria
    ADD CONSTRAINT fkb5u1xuiroy0tls0b2odm8aj64 FOREIGN KEY (produto_id) REFERENCES public.tb_produto(id);


--
-- Name: tb_pagamento_boleto fkemoctuaowlk1gg2sknv9fmixb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pagamento_boleto
    ADD CONSTRAINT fkemoctuaowlk1gg2sknv9fmixb FOREIGN KEY (pedido_id) REFERENCES public.tb_pagamento(pedido_id);


--
-- Name: tb_endereco fkfybceun95o8l6dq559fji2q8n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_endereco
    ADD CONSTRAINT fkfybceun95o8l6dq559fji2q8n FOREIGN KEY (id_cliente) REFERENCES public.tb_cliente(id);


--
-- Name: tb_item_pedido fkgfmv77km3wt2evaaq2vkiv2oj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_item_pedido
    ADD CONSTRAINT fkgfmv77km3wt2evaaq2vkiv2oj FOREIGN KEY (produto_id) REFERENCES public.tb_produto(id);


--
-- Name: tb_pagamento fkjghfnncmma1w9wn5hnpq6nhx2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pagamento
    ADD CONSTRAINT fkjghfnncmma1w9wn5hnpq6nhx2 FOREIGN KEY (pedido_id) REFERENCES public.tb_pedido(id);


--
-- Name: tb_cidade fklxge3ne91xrep1oe4cvrjldmm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_cidade
    ADD CONSTRAINT fklxge3ne91xrep1oe4cvrjldmm FOREIGN KEY (estado_id) REFERENCES public.tb_estado(id);


--
-- Name: tb_pedido fkmfmrxaiieg7pbiuii68005j3q; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pedido
    ADD CONSTRAINT fkmfmrxaiieg7pbiuii68005j3q FOREIGN KEY (endereco_de_entrega_id) REFERENCES public.tb_endereco(id);


--
-- Name: tb_pedido fkmjqm65wiaj65gia070a45vt9w; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pedido
    ADD CONSTRAINT fkmjqm65wiaj65gia070a45vt9w FOREIGN KEY (id_cliente) REFERENCES public.tb_cliente(id);


--
-- Name: produto_categoria fkms3o1ji6o60h9s4acjqqc5fw5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.produto_categoria
    ADD CONSTRAINT fkms3o1ji6o60h9s4acjqqc5fw5 FOREIGN KEY (categoria_id) REFERENCES public.tb_categoria(id);


--
-- Name: tb_telefone fkpwjwudqbv75e49ux295dm87al; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_telefone
    ADD CONSTRAINT fkpwjwudqbv75e49ux295dm87al FOREIGN KEY (cliente_id) REFERENCES public.tb_cliente(id);


--
-- PostgreSQL database dump complete
--

