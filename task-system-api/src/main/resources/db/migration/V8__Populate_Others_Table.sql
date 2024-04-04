INSERT INTO public.tb_backlog (id, description, name_task, priority, status) VALUES
('1'::uuid, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, '0'::smallint);

INSERT INTO public.tb_inbox (id, description, name_task, priority, status) VALUES
('1'::uuid, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, '1'::smallint);

INSERT INTO public.tb_todo (id, description, name_task, priority, status) VALUES
('1'::uuid, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, '2'::smallint);

INSERT INTO public.tb_doing (id, description, name_task, priority, status) VALUES
('1'::uuid, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, '3'::smallint);

INSERT INTO public.tb_done (id, description, name_task, priority, status) VALUES
('1'::uuid, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, '4'::smallint);