INSERT INTO public.tb_backlog (id, description, name_task, priority, status) VALUES
('1'::bigint, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, 'None'::character varying);

INSERT INTO public.tb_inbox (id, description, name_task, priority, status) VALUES
('1'::bigint, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, 'Analyzing'::character varying);

INSERT INTO public.tb_todo (id, description, name_task, priority, status) VALUES
('1'::bigint, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, 'To Do'::character varying);

INSERT INTO public.tb_doing (id, description, name_task, priority, status) VALUES
('1'::bigint, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, 'Doing'::character varying);

INSERT INTO public.tb_done (id, description, name_task, priority, status) VALUES
('1'::bigint, 'Detailed analysis of market trends for Q1 2024'::character varying, 'Market Trends Analysis'::character varying, '5'::integer, 'Done'::character varying);