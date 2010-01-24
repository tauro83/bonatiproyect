--
-- PostgreSQL database dump
--

-- Started on 2010-01-23 22:18:10

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1880 (class 0 OID 0)
-- Dependencies: 1329
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_seq', 3, true);


--
-- TOC entry 1873 (class 0 OID 16785)
-- Dependencies: 1365
-- Data for Name: asuntowebaviso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY asuntowebaviso (nombre) FROM stdin;
\.


--
-- TOC entry 1845 (class 0 OID 16470)
-- Dependencies: 1337
-- Data for Name: atencion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencion (clienterut, mascotanombre, servicio, hora, fecha, costo) FROM stdin;
\.


--
-- TOC entry 1865 (class 0 OID 16705)
-- Dependencies: 1357
-- Data for Name: atencionalojamiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionalojamiento (servicio, hora, fechaingreso, costo, responsable, cliente, mascota, canil, fechasalida, comentario, diasestadia, eliminado, estado) FROM stdin;
\N	22:17     	2009-12-15	34324  	juan                          	162989243                     	larry                         	5	2010-01-05	Comentario hoteleria	\N	\N	0
\.


--
-- TOC entry 1843 (class 0 OID 16444)
-- Dependencies: 1335
-- Data for Name: atencionbanio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionbanio (rutcliente, nombremascota, servicio, hora, fecha, costo, comentario) FROM stdin;
\.


--
-- TOC entry 1850 (class 0 OID 16538)
-- Dependencies: 1342
-- Data for Name: atencioncirugia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencioncirugia (estado, diagnostico, tipo, servicio, hora, fecha, costo) FROM stdin;
\.


--
-- TOC entry 1851 (class 0 OID 16546)
-- Dependencies: 1343
-- Data for Name: atencionconsulta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionconsulta (anamnesis, servicio, hora, fecha, costo) FROM stdin;
\.


--
-- TOC entry 1852 (class 0 OID 16554)
-- Dependencies: 1344
-- Data for Name: atencioncontrol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencioncontrol (cliente, mascota, descripcion, fecha, hora, responsable, servicio, costo, motivo) FROM stdin;
162989243	larry                         	Control detalle	2010-01-23	22:15:12  	juan                          	Policlínico         	4555   	0
\.


--
-- TOC entry 1842 (class 0 OID 16431)
-- Dependencies: 1334
-- Data for Name: atencionpedicure; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionpedicure (rutcliente, nombremascota, servicio, hora, fecha, costo, descripcion, nombre) FROM stdin;
\.


--
-- TOC entry 1863 (class 0 OID 16665)
-- Dependencies: 1355
-- Data for Name: atencionpeluqueria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionpeluqueria (clienterut, mascotanombre, hora, responsable, fecha, estado, servicio) FROM stdin;
140517461	zury                                              	14:13:42	cbonati             	2010-01-12	0	Peluqueria
140517461	zury                                              	14:13:46	cbonati             	2010-01-14	0	Peluqueria
\.


--
-- TOC entry 1860 (class 0 OID 16638)
-- Dependencies: 1352
-- Data for Name: atencionpostoperatorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionpostoperatorio (medicamentos, alimentos, indicaciones, servicio, hora, fecha, costo, nombremascota, rut, apellido, nombrecliente, estado, motivo) FROM stdin;
\N	\N	Revision rutinaria	Pabellon	10:30     	01/18/2010	\N	Martin                                            	16358963K	\N	\N	0	0                                                                                                                                                                                                       
\N	\N	Postoperatorio	Pabellon	10:30     	01/19/2010	\N	larry                                             	162989243	\N	\N	0	0                                                                                                                                                                                                       
\.


--
-- TOC entry 1853 (class 0 OID 16572)
-- Dependencies: 1345
-- Data for Name: atencionpreoperatorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionpreoperatorio (observaciones, sintomas, diagnosticos, servicio, hora, fecha, costo) FROM stdin;
\.


--
-- TOC entry 1849 (class 0 OID 16530)
-- Dependencies: 1341
-- Data for Name: atencionvacuna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY atencionvacuna (precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo) FROM stdin;
\.


--
-- TOC entry 1870 (class 0 OID 16759)
-- Dependencies: 1362
-- Data for Name: avisoweb; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY avisoweb (id, nombre, apaterno, telefono0, telefono, celular0, celular, asunto, descripcion, estado) FROM stdin;
\.


--
-- TOC entry 1841 (class 0 OID 16427)
-- Dependencies: 1333
-- Data for Name: bitacora; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bitacora (usuario, accion, fechaaccion, horaaccion, fechaacita, horacita, cliente, mascota, servicio) FROM stdin;
juan                	Registrar           	23/1/2010           	16:1:40             	23/01/2010          	12:30               	16358963K           	Martin              	Peluquería          
\.


--
-- TOC entry 1875 (class 0 OID 16791)
-- Dependencies: 1367
-- Data for Name: bitacora2; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bitacora2 (fecha, usuario, servicio, accion) FROM stdin;
23-01-2010	rlo                                               	Administración      	Registra el usuario: cbonati nombre: claudio apellido paterno: bonati                                                   
23-01-2010	rlo                                               	Administración      	Registra cliente: raul lopez diaz                                                                                       
23-01-2010	rlo                                               	Administración      	Registra mascota: zury especie: Canina                                                                                  
23-01-2010	rlo                                               	Administración      	Edita cliente: raul lopez diaz                                                                                          
23-01-2010	juan                                              	Administración      	Registra cliente: adsdsasad adsads                                                                                      
23-01-2010	juan                                              	Administración      	Registra mascota:  especie: Canina                                                                                      
23-01-2010	juan                                              	Administración      	Registra mascota: aAASDADS especie: Canina                                                                              
23-01-2010	juan                                              	Administración      	Registra cliente: vfdjsfdsj dsaads                                                                                      
23-01-2010	juan                                              	Administración      	Registra cliente: houiu adsdasas                                                                                        
23-01-2010	juan                                              	Administración      	Registra mascota: sadssadasdsa especie: Canina                                                                          
23-01-2010	juan                                              	Administración      	Registra cliente: Sebastian Arancibia Olguin                                                                            
23-01-2010	juan                                              	Administración      	Elimina cliente rut: 65765757                                                                                           
23-01-2010	juan                                              	Administración      	Elimina cliente rut: 43544                                                                                              
23-01-2010	juan                                              	Administración      	Elimina cliente rut: 2131321                                                                                            
23-01-2010	juan                                              	Administración      	Purga cliente rut: 43544                                                                                                
23-01-2010	juan                                              	Administración      	Elimina cliente rut: 140517461                                                                                          
23-01-2010	juan                                              	Administración      	Registra el usuario: sarancibia nombre: Sebastian apellido paterno: Arancibia                                           
23-01-2010	juan                                              	Administración      	Elimina el usuario: cbonati                                                                                             
23-01-2010	juan                                              	Administración      	Registra mascota: Martin especie: Perro                                                                                 
23-01-2010	juan                                              	Administración      	Registra mascota: Mia especie: Perro                                                                                    
23-01-2010	juan                                              	Administración      	Elimina mascota:                                                                                                        
23-01-2010	juan                                              	Administración      	Elimina mascota: sadssadasdsa                                                                                           
23-01-2010	juan                                              	Administración      	Elimina mascota: aAASDADS                                                                                               
23-01-2010	usuario                                           	Administración      	Purga mascota: sadssadasdsa                                                                                             
23-01-2010	usuario                                           	Administración      	Purga mascota: aAASDADS                                                                                                 
23-01-2010	juan                                              	Administración      	Purga cliente rut: 65765757                                                                                             
23-01-2010	juan                                              	Administración      	Registra cliente: Camilo Verdugo Gunther                                                                                
23-01-2010	juan                                              	Administración      	Registra mascota: larry especie: Perro                                                                                  
23-01-2010	juan                                              	Administración      	Registra el usuario: cverdugo nombre: Camilo apellido paterno: Verdugo                                                  
\.


--
-- TOC entry 1855 (class 0 OID 16584)
-- Dependencies: 1347
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cargo (nombre) FROM stdin;
Peluquero           
Cajero              
Dueño               
Veterinario         
Peluquera           
\.


--
-- TOC entry 1862 (class 0 OID 16657)
-- Dependencies: 1354
-- Data for Name: catpeluqueria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY catpeluqueria (servicio, nombre, precio, descripcion, estado) FROM stdin;
corte               	Corte               	4000	asdasd	0
corte               	Baño tres           	7000	asdasdasd	0
corte               	dasdsaads           	231231	dsadsaadsdassdadas	0
\.


--
-- TOC entry 1847 (class 0 OID 16493)
-- Dependencies: 1339
-- Data for Name: cirugia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cirugia (clienterut, mascotanombre, hora, responsable, ayudante, fecha, costo, estado, motivo, servicio) FROM stdin;
16358963K	Martin                                            	16:09:39	rlo                 	juan                	19/01/2010	9999                	2	0	Pabellon
16358963K	Martin                                            	16:13:03	juan                	rlo                 	23/01/2010	332                 	0	0	Pabellon
162989243	larry                                             	22:13:46	juan                	rlo                 	16/01/2010	5600                	0	0	Pabellon
\.


--
-- TOC entry 1876 (class 0 OID 16793)
-- Dependencies: 1368
-- Data for Name: cirugiaobj; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cirugiaobj (nombre, precio, descripcion) FROM stdin;
Castramiento        	1000	se le cortan los coquitos
\.


--
-- TOC entry 1846 (class 0 OID 16479)
-- Dependencies: 1338
-- Data for Name: cita; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cita (rutcliente, nombremascota, fecha, hora, servicio, responsable) FROM stdin;
16358963K	Martin              	23/1/2010 	12:30	Peluquería                    	sarancibia          
162989243	larry               	19/1/2010 	10:30	Policlínico                   	juan                
\.


--
-- TOC entry 1839 (class 0 OID 16411)
-- Dependencies: 1331
-- Data for Name: clientepresencial; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clientepresencial (rut, telefono, celular, nombre, apaterno, amaterno, correo, estado, domicilio, comuna, region) FROM stdin;
16358963K	\N	\N	Sebastian           	Arancibia           	Olguin              	s.arancibia.o@gmail.com                                     	t	Santa Lucia N 26                                                                                                                                                                                        	Curicó                                            	Del Maule                                         
140517461	75222333	7222333	raul                	lopez               	diaz                	ra@gmail.com                                                	t	rodriguez 977                                                                                                                                                                                           	Alto Hospicio                                     	De Tarapaca                                       
162989243	75222223	934332432	Camilo              	Verdugo             	Gunther             	camilo@gmail.com                                            	t	27 Sur                                                                                                                                                                                                  	Talca                                             	Del Maule                                         
\.


--
-- TOC entry 1874 (class 0 OID 16787)
-- Dependencies: 1366
-- Data for Name: comuna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY comuna (nombre, numregion, nombreregion) FROM stdin;
\.


--
-- TOC entry 1859 (class 0 OID 16624)
-- Dependencies: 1351
-- Data for Name: consulta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY consulta (anamnesis, servicio, hora, fecha, costo, rut, nombre, responsable, estado, motivo) FROM stdin;
Consulta detalle	Hotelería           	22:14:50            	14/12/2009          	3333                                              	162989243	larry               	raul lopez          	0	0
\.


--
-- TOC entry 1866 (class 0 OID 16718)
-- Dependencies: 1358
-- Data for Name: control; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY control (cliente, mascota, descripcion, fecha, hora, responsable, servicio, costo, estado) FROM stdin;
\.


--
-- TOC entry 1844 (class 0 OID 16457)
-- Dependencies: 1336
-- Data for Name: corte; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY corte (rutcliente, nombremascota, servicio, hora, foto, fecha, raza, costo, nombre, categoria, descripcion) FROM stdin;
\.


--
-- TOC entry 1869 (class 0 OID 16750)
-- Dependencies: 1361
-- Data for Name: detallepago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detallepago (fecha, hora, codigoproducto, cantidad, subtotal) FROM stdin;
\.


--
-- TOC entry 1848 (class 0 OID 16518)
-- Dependencies: 1340
-- Data for Name: diagnosticos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY diagnosticos (clienterut, mascotanombre, hora, fecha, diagnostico, nuevafecha, tipocirugia, nuevahora, id) FROM stdin;
16358963K	Martin                                            	16:09:39	19/01/2010	lkmlkmlk	19/01/2010	Castramiento                  	16:09:39	0 
16358963K	Martin                                            	16:09:39	19/01/2010	habra que ponerle unos postizos	23/1/2010 	Castramiento                  	16:10:59	0 
16358963K	Martin                                            	16:13:03	23/01/2010	tiene los testiculos muy grande	23/01/2010	Castramiento                  	16:13:03	0 
16358963K	Martin                                            	16:13:03	23/01/2010	lkmlkmlkm	23/1/2010 	Castramiento                  	16:13:12	0 
162989243	larry                                             	22:13:46	16/01/2010	Diagnostico cirugia	16/01/2010	Castramiento                  	22:13:46	0 
\.


--
-- TOC entry 1854 (class 0 OID 16580)
-- Dependencies: 1346
-- Data for Name: especie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY especie (nombre) FROM stdin;
Perro               
Gato                
Conejo              
Caballo             
\.


--
-- TOC entry 1840 (class 0 OID 16415)
-- Dependencies: 1332
-- Data for Name: mascota; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY mascota (rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado, imagen) FROM stdin;
140517461	zury                                              	17/11/2009	Canina                                            	Salchicha                                         	Hembra    	t	\N
16358963K	Martin                                            	09/01/2003	Perro                                             	Poodle                                            	Macho     	t	\N
16358963K	Mia                                               	14/01/2003	Perro                                             	Poodle                                            	Hembra    	t	\N
162989243	larry                                             	17/09/2009	Perro                                             	Boxer                                             	Macho     	t	\N
\.


--
-- TOC entry 1868 (class 0 OID 16745)
-- Dependencies: 1360
-- Data for Name: pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pago (fecha, hora, estado, total) FROM stdin;
2010-01-23	22:16:34	0	0
2010-01-23	22:16:35	0	0
\.


--
-- TOC entry 1867 (class 0 OID 16736)
-- Dependencies: 1359
-- Data for Name: preoperatorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preoperatorio (rut, nombre, observaciones, sintomas, diagnostico, fecha, hora, responsable, ayudante, estado, motivo) FROM stdin;
16358963K	Martin                                            	moriralkm	se hace caca solo	esta liquidado tiene 2 horas de vida	01/23/2010	16:3:53   	Sebastian Arancibia           	                              	0	0
16298924 	larry                                             	Observaciones	Preopeatorio sintomas	Diagnostico	01/23/2010	22:13:19  	Sebastian Arancibia           	\N	0	0
\.


--
-- TOC entry 1872 (class 0 OID 16776)
-- Dependencies: 1364
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY producto (nombre, precio, categoria, codigo, descripcion, estado, stock) FROM stdin;
BCDEFG              	600                 	5                   	0000000000001       	\N	0	0
                    	0                   	0                   	0000000000002       	\N	0	0
                    	0                   	2                   	0000002000333       	\N	0	0
                    	0                   	0                   	0000002000505       	\N	0	0
                    	0                   	0                   	0000008000068       	\N	0	0
HUESO ENR 1         	120                 	2                   	0000010000014       	\N	0	0
HUESO ENR 2         	80                  	2                   	0000010000021       	\N	0	0
HUESO ENR 3         	150                 	2                   	0000010000038       	\N	0	0
HUESO ENR 4         	160                 	2                   	0000010000045       	\N	0	0
HUESO ENR 5         	200                 	2                   	0000010000052       	\N	0	0
HUESO ENR 6         	250                 	2                   	0000010000069       	\N	0	0
HUESO ENR 7         	290                 	2                   	0000010000076       	\N	0	0
HUESO ENR 8         	340                 	2                   	0000010000083       	\N	0	0
HUESO ENR 9         	360                 	2                   	0000010000090       	\N	0	0
HUESO CHALIM        	200                 	2                   	0000010000106       	\N	0	0
PACK CORAZON        	100                 	2                   	0000010000113       	\N	0	0
PALITOS             	80                  	2                   	0000010000120       	\N	0	0
PACK BAR X10        	50                  	2                   	0000010000151       	\N	0	0
ARNE ARM 1          	600                 	2                   	0000020000011       	\N	0	0
ARNE AR 2           	630                 	2                   	0000020000028       	\N	0	0
ARNE AR 3           	660                 	2                   	0000020000035       	\N	0	0
ARNE ARM 4          	770                 	2                   	0000020000042       	\N	0	0
AR GE HUE GR        	600                 	2                   	0000020000059       	\N	0	0
AR GEN MIL M        	370                 	2                   	0000020000073       	\N	0	0
AR GEN MOR M        	370                 	2                   	0000020000080       	\N	0	0
AR INGL CUER        	700                 	2                   	0000020000097       	\N	0	0
AR IN CUE 2         	740                 	2                   	0000020000103       	\N	0	0
AR ING CUE 3        	760                 	2                   	0000020000110       	\N	0	0
AR REF G S/T        	550                 	2                   	0000020000134       	\N	0	0
ARN TIPTOP S        	270                 	2                   	0000020000141       	\N	0	0
ARN TIPTOP L        	590                 	2                   	0000020000158       	\N	0	0
ARN TIPTOP M        	480                 	2                   	0000020000165       	\N	0	0
ARN TIPTO XS        	290                 	2                   	0000020000172       	\N	0	0
ARNE T-TO S         	350                 	2                   	0000020000189       	\N	0	0
AR T-T S LOV        	330                 	2                   	0000020000196       	\N	0	0
AR T-T M            	380                 	2                   	0000020000202       	\N	0	0
AR T-T M-LOV        	370                 	2                   	0000020000219       	\N	0	0
AR T-T M-L          	550                 	2                   	0000020000226       	\N	0	0
ARN GAMU S          	240                 	2                   	0000020000240       	\N	0	0
ARN GAMU L          	280                 	2                   	0000020000257       	\N	0	0
ARN CUE CHIC        	250                 	2                   	0000020000264       	\N	0	0
ARN CUE GR          	320                 	2                   	0000020000271       	\N	0	0
AR CTC chico        	320                 	2                   	0000020000288       	\N	0	0
ARN CTC medi        	370                 	2                   	0000020000295       	\N	0	0
ARN CTC GRAN        	420                 	2                   	0000020000301       	\N	0	0
AR SEDA chic        	260                 	2                   	0000020000318       	\N	0	0
AR SEDA medi        	330                 	2                   	0000020000325       	\N	0	0
AR SEDA GR          	380                 	2                   	0000020000332       	\N	0	0
AR CAP TR ch        	300                 	2                   	0000020000349       	\N	0	0
AR CAP TR me        	350                 	2                   	0000020000356       	\N	0	0
AR CAP TR GR        	400                 	2                   	0000020000363       	\N	0	0
ARN AUTO S          	800                 	2                   	0000020000370       	\N	0	0
ARN AUTO M          	860                 	2                   	0000020000387       	\N	0	0
ARN AUTO L          	920                 	2                   	0000020000394       	\N	0	0
ARN AS XL           	1000                	2                   	0000020000400       	\N	0	0
CA CELO TA 0        	290                 	2                   	0000020001988       	\N	0	0
CA CELO T1          	320                 	2                   	0000020001995       	\N	0	0
CO CU 18X46P        	380                 	2                   	0000020003005       	\N	0	0
CO CU 25X57P        	380                 	2                   	0000020003012       	\N	0	0
CO CU 59 TUK        	520                 	2                   	0000020003043       	\N	0	0
CO CU 65 TUK        	560                 	2                   	0000020003067       	\N	0	0
CO CU 71 TUK        	580                 	2                   	0000020003074       	\N	0	0
CO CU 73HE/D        	560                 	2                   	0000020003081       	\N	0	0
CO CU 76HE/D        	700                 	2                   	0000020003098       	\N	0	0
CO CU 55 C/P        	490                 	2                   	0000020003104       	\N	0	0
CO CU 65C/PL        	560                 	2                   	0000020003111       	\N	0	0
CO CU 62HE/D        	780                 	2                   	0000020003128       	\N	0	0
CO CU P-T 1         	250                 	2                   	0000020003135       	\N	0	0
CO CU C/B30C        	680                 	2                   	0000020003142       	\N	0	0
CO CU C/BD40        	850                 	2                   	0000020003159       	\N	0	0
CO CU C/ESME        	680                 	2                   	0000020003166       	\N	0	0
CCU TAC/CH34        	200                 	2                   	0000020003173       	\N	0	0
CCU TAC/GRA         	250                 	2                   	0000020003180       	\N	0	0
CCU TAC/MED         	240                 	2                   	0000020003197       	\N	0	0
CO CU C/BRIL        	650                 	2                   	0000020003203       	\N	0	0
CCU/FL 46 CM        	290                 	2                   	0000020003210       	\N	0	0
CO CU 27C/PT        	180                 	2                   	0000020003227       	\N	0	0
CO CU 30C/PL        	190                 	2                   	0000020003234       	\N	0	0
CO CU 34C/PT        	220                 	2                   	0000020003241       	\N	0	0
CO CU 36C/P         	160                 	2                   	0000020003258       	\N	0	0
CO PL TA 3          	460                 	2                   	0000020003265       	\N	0	0
CO SUE 42C/P        	290                 	2                   	0000020003272       	\N	0	0
CO SUE GATO         	100                 	2                   	0000020003289       	\N	0	0
CO CU P-T N0        	220                 	2                   	0000020003302       	\N	0	0
CO CU P-T 2         	330                 	2                   	0000020003319       	\N	0	0
CO CU P-T 4         	430                 	2                   	0000020003326       	\N	0	0
CO CU P-T 4         	520                 	2                   	0000020003333       	\N	0	0
CO CU P-T 5         	610                 	2                   	0000020003340       	\N	0	0
CO CU P-T 6         	830                 	2                   	0000020003357       	\N	0	0
CO PITBULL          	830                 	2                   	0000020003364       	\N	0	0
CO PUN N 3          	490                 	2                   	0000020003371       	\N	0	0
CO PUN N 4          	610                 	2                   	0000020003388       	\N	0	0
CO PUN N 5          	750                 	2                   	0000020003395       	\N	0	0
CO BAK T/P          	260                 	2                   	0000020003401       	\N	0	0
CO BAK T/P 2        	340                 	2                   	0000020003418       	\N	0	0
CO BAK T/P 3        	440                 	2                   	0000020003425       	\N	0	0
CO BAK P/T 5        	550                 	2                   	0000020003432       	\N	0	0
CO BAK P/T 6        	600                 	2                   	0000020003449       	\N	0	0
CO BAK C/T 1        	340                 	2                   	0000020003456       	\N	0	0
CO BAK C/T 2        	380                 	2                   	0000020003463       	\N	0	0
CO BAK C/T 3        	420                 	2                   	0000020003470       	\N	0	0
CO BAK T/P 4        	480                 	2                   	0000020003487       	\N	0	0
CO SH 3161          	170                 	2                   	0000020003494       	\N	0	0
CO 210 C            	160                 	2                   	0000020003500       	\N	0	0
CO SH 3328          	180                 	2                   	0000020003517       	\N	0	0
CO GEN HU FA        	180                 	2                   	0000020003524       	\N	0	0
TI SH 2729          	620                 	2                   	0000020003531       	\N	0	0
CO SYX013B          	420                 	2                   	0000020003548       	\N	0	0
PVC SH 3195         	180                 	2                   	0000020003555       	\N	0	0
CO NY COLORE        	210                 	2                   	0000020003562       	\N	0	0
CO CASCABEL         	240                 	2                   	0000020003586       	\N	0	0
CO POPURI           	200                 	2                   	0000020003593       	\N	0	0
2                   	780                 	2                   	0000020003609       	\N	0	0
CO GATO PESC        	165                 	2                   	0000020004903       	\N	0	0
CO GAT PLAST        	180                 	2                   	0000020004910       	\N	0	0
CO CU C/CASC        	150                 	2                   	0000020004934       	\N	0	0
CO GA PL C/C        	100                 	2                   	0000020004941       	\N	0	0
CO PL C/CA          	120                 	2                   	0000020004958       	\N	0	0
CO PL C/BRIL        	190                 	2                   	0000020004965       	\N	0	0
CO RE C/F4CM        	220                 	2                   	0000020005009       	\N	0	0
CO RE C/H 40        	200                 	2                   	0000020005016       	\N	0	0
CO RE C/PLAC        	120                 	2                   	0000020005023       	\N	0	0
CO RE/FL 40         	200                 	2                   	0000020005030       	\N	0	0
CO RE C/F 46        	280                 	2                   	0000020005047       	\N	0	0
CO RE C/F+B         	150                 	2                   	0000020005054       	\N	0	0
CO REF C/F+B        	180                 	2                   	0000020005061       	\N	0	0
C REFc/hu 46        	280                 	2                   	0000020005078       	\N	0	0
C. REF 10X30        	200                 	2                   	0000020005085       	\N	0	0
CO SH2721           	380                 	3                   	0000020005092       	\N	0	0
COLLETS BAKA        	180                 	3                   	0000020006006       	\N	0	0
CORTAUNAS 10        	590                 	2                   	0000020007003       	\N	0	0
CORTAUNAS 15        	640                 	3                   	0000020007010       	\N	0	0
CUNA ESP CHI        	980                 	2                   	0000020007508       	\N	0	0
CUNA ESP GRA        	1750                	2                   	0000020007515       	\N	0	0
CUNA ESP MED        	1310                	2                   	0000020007522       	\N	0	0
GUANTE RASQU        	630                 	2                   	0000020007607       	\N	0	0
CUCH ROMPENU        	740                 	2                   	0000020008000       	\N	0	0
PEINETA HPET        	310                 	2                   	0000020008024       	\N	0	0
                    	30                  	0                   	0000020008093       	\N	0	0
PLACA IDENT         	140                 	2                   	0000020008109       	\N	0	0
PLACA IDENT         	140                 	2                   	0000020008116       	\N	0	0
PLACA IDENT         	140                 	2                   	0000020008123       	\N	0	0
PLACA IDENT         	140                 	2                   	0000020008130       	\N	0	0
PLACA ID            	35                  	2                   	0000020008147       	\N	0	0
PLACA IDEN          	35                  	2                   	0000020008154       	\N	0	0
PLACA IDEN          	35                  	2                   	0000020008161       	\N	0	0
PLACA IDEN          	80                  	2                   	0000020008178       	\N	0	0
PLACA IDEN          	40                  	2                   	0000020008185       	\N	0	0
RASQ HELLO P        	590                 	2                   	0000020008192       	\N	0	0
PLACA IDENT         	90                  	2                   	0000020008208       	\N	0	0
RASQ GOMA           	200                 	2                   	0000020008215       	\N	0	0
COL GAM CASC        	120                 	2                   	0000020009007       	\N	0	0
PLATO PL 8cm        	160                 	2                   	0000020009014       	\N	0	0
PLAT GAT 9.5        	160                 	2                   	0000020009021       	\N	0	0
PLA PET KING        	210                 	2                   	0000020009038       	\N	0	0
PLAT MELAMIN        	270                 	2                   	0000020009069       	\N	0	0
CO C/SCHNAU         	390                 	2                   	0000020013264       	\N	0	0
CO CU 40 CM         	360                 	2                   	0000020013271       	\N	0	0
CO CU C/H-PA        	480                 	2                   	0000020013288       	\N	0	0
ROLLO 18 20         	150                 	2                   	0000020013301       	\N	0	0
ROLLO 105           	150                 	2                   	0000020013318       	\N	0	0
FEMUR CERDO         	260                 	2                   	0000020013325       	\N	0	0
TIRAS OREJA         	140                 	2                   	0000020013332       	\N	0	0
CENTRAL FEMU        	400                 	2                   	0000020013349       	\N	0	0
RAS HELLO PE        	590                 	2                   	0000020013356       	\N	0	0
CO CU ROTTW         	900                 	2                   	0000020013363       	\N	0	0
CO CUE AR CH        	330                 	2                   	0000020014001       	\N	0	0
CO CUE AR GR        	380                 	2                   	0000020014018       	\N	0	0
TRAILLA 2           	160                 	2                   	0000040000220       	\N	0	0
TRAILLA 25          	200                 	2                   	0000040000237       	\N	0	0
TRAILLA 4MM         	220                 	2                   	0000040000251       	\N	0	0
TR CO EX GRU        	700                 	2                   	0000040000275       	\N	0	0
TR CO GRUESA        	480                 	2                   	0000040000282       	\N	0	0
TR COR 13 MM        	460                 	2                   	0000040000299       	\N	0	0
TR COR 8 MM         	260                 	2                   	0000040000305       	\N	0	0
TRAILLA 31          	200                 	2                   	0000040000312       	\N	0	0
TRAILLA 1 6         	120                 	2                   	0000040000329       	\N	0	0
T SH581             	380                 	3                   	0000040000343       	\N	0	0
TRAI CADENA         	480                 	2                   	0000040000909       	\N	0	0
PEROXYDEX           	550                 	3                   	0000050600243       	\N	0	0
TRAILLA COXG        	700                 	2                   	0000054013018       	\N	0	0
ROPA                	430                 	6                   	0000070000016       	\N	0	0
ROPA                	450                 	6                   	0000070000023       	\N	0	0
ROPA                	410                 	6                   	0000070000030       	\N	0	0
ROPA                	420                 	6                   	0000070000047       	\N	0	0
ROPA                	480                 	6                   	0000070000054       	\N	0	0
ROPA                	970                 	6                   	0000070000061       	\N	0	0
ROPA                	750                 	6                   	0000070000078       	\N	0	0
ROPA                	700                 	6                   	0000070000085       	\N	0	0
ROPA                	890                 	6                   	0000070000092       	\N	0	0
ROPA                	950                 	6                   	0000070000108       	\N	0	0
ROPA                	900                 	6                   	0000070000115       	\N	0	0
ROPA                	800                 	6                   	0000070000122       	\N	0	0
ROPA                	1400                	6                   	0000070000139       	\N	0	0
ROPA                	400                 	6                   	0000070000146       	\N	0	0
CHALECO 1           	400                 	6                   	0000070000306       	\N	0	0
CHALECO 2           	420                 	6                   	0000070000313       	\N	0	0
CHALECO 3           	540                 	6                   	0000070000320       	\N	0	0
CHALECO 4           	570                 	6                   	0000070000337       	\N	0	0
CHALECO 5           	600                 	6                   	0000070000344       	\N	0	0
CHALECO 6           	650                 	6                   	0000070000351       	\N	0	0
CAPA PA/GOR1        	480                 	6                   	0000070000504       	\N	0	0
CAPA PA/GOR2        	500                 	6                   	0000070000511       	\N	0	0
CAP PA/GORR3        	520                 	6                   	0000070000528       	\N	0	0
CA PA/GOR4          	600                 	6                   	0000070000535       	\N	0	0
CA PA/CHIPO1        	420                 	6                   	0000070000702       	\N	0	0
CA PA/CHIPO2        	470                 	6                   	0000070000719       	\N	0	0
CA PA/CHIPO3        	510                 	6                   	0000070000726       	\N	0	0
CA PA/CHIPO4        	570                 	6                   	0000070000733       	\N	0	0
CAPA PA/POL1        	450                 	6                   	0000070000900       	\N	0	0
CAPA PA/PO2         	470                 	6                   	0000070000917       	\N	0	0
CA PA/POL3          	510                 	6                   	0000070000924       	\N	0	0
CA PA/POL4          	600                 	6                   	0000070000931       	\N	0	0
CA PA/POL5          	420                 	6                   	0000070000948       	\N	0	0
CA PA/POL6          	650                 	6                   	0000070000955       	\N	0	0
CA PA/POL7          	580                 	6                   	0000070000962       	\N	0	0
CA PA/POL8          	540                 	6                   	0000070000979       	\N	0	0
CA PO/CHIP1         	470                 	6                   	0000070001303       	\N	0	0
CA PO/CHIP2         	480                 	6                   	0000070001310       	\N	0	0
CA PO/CHIP3         	520                 	6                   	0000070001327       	\N	0	0
CA PA/CHIP4         	490                 	6                   	0000070001334       	\N	0	0
CA PA/CHIP5         	560                 	6                   	0000070001341       	\N	0	0
CA PA/CHIP6         	280                 	6                   	0000070001358       	\N	0	0
CA POL/GOR1         	580                 	6                   	0000070001501       	\N	0	0
CA PO/GOR2          	560                 	6                   	0000070001518       	\N	0	0
CA PO/GOR3          	480                 	6                   	0000070001525       	\N	0	0
CA PO/PAT1          	580                 	6                   	0000070001655       	\N	0	0
CA PO/PAT2          	540                 	6                   	0000070001662       	\N	0	0
CA PO/PAT3          	480                 	6                   	0000070001679       	\N	0	0
CAPA POL1           	320                 	6                   	0000070001808       	\N	0	0
CAPA POL2           	350                 	6                   	0000070001815       	\N	0	0
CAPA POL3           	400                 	6                   	0000070001822       	\N	0	0
CA ES/CHI 1         	850                 	6                   	0000070002003       	\N	0	0
CA ES/CHI 2         	890                 	6                   	0000070002010       	\N	0	0
CA ES/CHI 3         	450                 	6                   	0000070002027       	\N	0	0
CA ES/CHI 4         	470                 	6                   	0000070002034       	\N	0	0
CA ES/CHI 5         	510                 	6                   	0000070002041       	\N	0	0
CA ES/CHI 6         	550                 	6                   	0000070002058       	\N	0	0
CA ES/CHI 7         	580                 	6                   	0000070002065       	\N	0	0
CA ES/CHI 8         	620                 	6                   	0000070002072       	\N	0	0
CA PA/PO 1          	680                 	6                   	0000070002201       	\N	0	0
CA PA/PO 2          	720                 	6                   	0000070002218       	\N	0	0
CA PA/PO 3          	750                 	6                   	0000070002225       	\N	0	0
TIRADOR PIT         	1200                	2                   	0000070002232       	\N	0	0
AR PA GR            	750                 	2                   	0000070002249       	\N	0	0
AR PASTOR AL        	440                 	2                   	0000070002256       	\N	0	0
ABRIGO POLAR        	480                 	6                   	0000070002263       	\N	0	0
6                   	0                   	6                   	0000070002270       	\N	0	0
COCA                	35                  	1                   	0000078001848       	\N	0	0
                    	0                   	3                   	0000080000044       	\N	0	0
                    	0                   	3                   	0000080000051       	\N	0	0
                    	0                   	3                   	0000080000068       	\N	0	0
CREMA 6A            	650                 	3                   	0000080000075       	\N	0	0
PEROXY SHAMP        	550                 	3                   	0000080000082       	\N	0	0
RESISTOL POL        	200                 	3                   	0000080000099       	\N	0	0
PET ODOR            	230                 	3                   	0000080000105       	\N	0	0
OTI FLEX 25         	350                 	3                   	0000080000112       	\N	0	0
ALBEND CACHO        	245                 	3                   	0000080000129       	\N	0	0
GRISEOF 250         	490                 	3                   	0000080000136       	\N	0	0
FELIWAY             	1180                	3                   	0000080000143       	\N	0	0
ULTRA 5             	290                 	3                   	0000080000174       	\N	0	0
SH SE GA EHL        	150                 	3                   	0000080000181       	\N	0	0
SH SEC PE EH        	150                 	3                   	0000080000198       	\N	0	0
                    	0                   	0                   	0000090140068       	\N	0	0
SINPUL 10ML         	100                 	3                   	000011D1220D1       	\N	0	0
                    	0                   	0                   	0000200090007       	\N	0	0
                    	0                   	0                   	0000200090021       	\N	0	0
CACA                	250                 	9                   	0001105766686       	\N	0	0
PL IN 10 CM         	180                 	2                   	0004004803202       	\N	0	0
TRAI MET 2mm        	220                 	2                   	0006900401302       	\N	0	0
TR MET C/CU         	310                 	2                   	0006900401303       	\N	0	0
TR M C/C 5mm        	460                 	2                   	0006900401304       	\N	0	0
TR M C/C 3.5        	440                 	2                   	0006900401305       	\N	0	0
                    	0                   	0                   	0007805200553       	\N	0	0
TRAI AHORQUE        	470                 	2                   	0007805290311       	\N	0	0
TR CORDON GR        	550                 	2                   	0007891013934       	\N	0	0
CORR TRAKT80        	1500                	2                   	0015561775861       	\N	0	0
IAMS HAIR 1K        	360                 	1                   	0019014006861       	\N	0	0
EUKAN SB 1,5        	420                 	1                   	0019014007660       	\N	0	0
EU Low pH FE        	1350                	1                   	0019014142101       	\N	0	0
EU LB AD 15K        	3200                	1                   	0019014261642       	\N	0	0
EU LB PU 20         	3800                	1                   	0019014262656       	\N	0	0
EU MB AD 20K        	3600                	1                   	0019014263653       	\N	0	0
EU SB PU 7,5        	2080                	1                   	0019014264636       	\N	0	0
EUK ENL  MAX        	100                 	1                   	0019014281060       	\N	0	0
EU SB AD 7,5        	1650                	1                   	0019014303632       	\N	0	0
EU LI AD 2,5        	850                 	1                   	0019014304622       	\N	0	0
EU SEN AD 3K        	750                 	1                   	0019014305629       	\N	0	0
EU SENIOR 15        	3300                	1                   	0019014305643       	\N	0	0
IAMS AD CH 1        	320                 	1                   	0019014620036       	\N	0	0
IAMS LIGHT 1        	400                 	1                   	0019014620043       	\N	0	0
IAMS AD CH 3        	980                 	1                   	0019014620067       	\N	0	0
IAMS LIGHT 3        	1100                	1                   	0019014620074       	\N	0	0
EU KITTEN 1K        	330                 	1                   	0019014620159       	\N	0	0
EU KITTEN 3K        	980                 	1                   	0019014620166       	\N	0	0
I L/G PU 6,5        	1080                	1                   	0019014620562       	\N	0	0
IAMS 65             	1100                	1                   	0019014620579       	\N	0	0
IAMS PU MB          	2200                	1                   	0019014620586       	\N	0	0
IAMS A MB           	1970                	1                   	0019014620593       	\N	0	0
AIMS PU LB13        	2200                	1                   	0019014620609       	\N	0	0
IA LB AD 13K        	1970                	1                   	0019014620616       	\N	0	0
IA S/M PU 2K        	480                 	1                   	0019014620685       	\N	0	0
IA S&M AD 2K        	440                 	1                   	0019014620692       	\N	0	0
COLL NY/CA G        	250                 	2                   	0022517515914       	\N	0	0
PANALES             	50                  	2                   	0022517705216       	\N	0	0
JU RATON            	150                 	2                   	0032700839697       	\N	0	0
SHAMPO O BER        	499                 	3                   	0034264419087       	\N	0	0
SHAMPO O ALO        	499                 	3                   	0034264419100       	\N	0	0
SHAMPO O BL         	499                 	3                   	0034264419124       	\N	0	0
SHAMPO O NA         	499                 	3                   	0034264419148       	\N	0	0
SHAMPO O NEG        	499                 	3                   	0034264419162       	\N	0	0
O ACONDICION        	499                 	3                   	0034264419186       	\N	0	0
GALLE NUT           	360                 	2                   	0034846716115       	\N	0	0
JTE KONG L          	850                 	2                   	0035585111117       	\N	0	0
JTE KONG M          	730                 	2                   	0035585111216       	\N	0	0
JTE KONG S          	520                 	2                   	0035585111315       	\N	0	0
DENT KONG M         	1260                	2                   	0035585121215       	\N	0	0
DENT KONG S         	1030                	2                   	0035585121314       	\N	0	0
KONG PUPPY L        	760                 	2                   	0035585131115       	\N	0	0
KONG PUPPY M        	600                 	2                   	0035585131214       	\N	0	0
KONG PUPPY S        	450                 	2                   	0035585131313       	\N	0	0
BALL KONG L         	760                 	2                   	0035585181127       	\N	0	0
BALL KONG M         	600                 	2                   	0035585181226       	\N	0	0
KID3202             	110                 	2                   	0040048032021       	\N	0	0
PL IN 15 CM         	200                 	2                   	0040048032038       	\N	0	0
PL IN 17 CM         	330                 	2                   	0040048032045       	\N	0	0
KID 3205            	350                 	2                   	0040048032052       	\N	0	0
PL IN 21 CM         	400                 	2                   	0040048032069       	\N	0	0
PL IN 23 CM         	670                 	2                   	0040048032076       	\N	0	0
PL INOX 16oz        	130                 	2                   	0040048500018       	\N	0	0
PL INOX 64oz        	180                 	2                   	0040048500025       	\N	0	0
PLATO AEPBME        	190                 	2                   	0040048500032       	\N	0	0
PL INOX Med         	240                 	2                   	0040048500049       	\N	0	0
PL INOX M-Gr        	280                 	2                   	0040048500056       	\N	0	0
PL INOX 24          	360                 	2                   	0040048500060       	\N	0	0
PL INOX Gran        	420                 	2                   	0040048500063       	\N	0	0
PET COMB            	580                 	2                   	0045663001506       	\N	0	0
PET DENTAL          	380                 	2                   	0045663410322       	\N	0	0
COLLAR ISA T        	300                 	2                   	0051115053351       	\N	0	0
AL Hi r/d FE        	170                 	1                   	0052742444000       	\N	0	0
Hi j/d 4,53K        	1700                	1                   	0052742449203       	\N	0	0
AL Hi i/d FE        	180                 	1                   	0052742462806       	\N	0	0
Hi r/d CA 1K        	500                 	1                   	0052742495309       	\N	0	0
AL EN Hi a/d        	190                 	1                   	0052742567006       	\N	0	0
Hi r/d C 4,5        	1200                	1                   	0052742582009       	\N	0	0
Hi r/d F 3,8        	2000                	1                   	0052742589800       	\N	0	0
Hi SBit PU 2        	700                 	1                   	0052742652108       	\N	0	0
ALIM R/D            	2070                	1                   	0052742660400       	\N	0	0
AL Hi k/d CA        	190                 	1                   	0052742701004       	\N	0	0
AL Hi r/d CA        	190                 	1                   	0052742701400       	\N	0	0
AL Hi s/d CA        	190                 	1                   	0052742701509       	\N	0	0
AL Hills u/d        	190                 	1                   	0052742701608       	\N	0	0
Hi k/d C 4,5        	1500                	1                   	0052742724706       	\N	0	0
Hi k/d F 4,5        	2000                	1                   	0052742725307       	\N	0	0
Hi SBit AD 3        	600                 	1                   	0052742994918       	\N	0	0
PESTELL &4          	315                 	2                   	0068328060601       	\N	0	0
KITTYSAND           	495                 	2                   	0068328200113       	\N	0	0
STAR PRO 10         	1600                	1                   	0072693198302       	\N	0	0
CO JEWEL 30.        	640                 	2                   	0076484014611       	\N	0	0
CO JEWEL 35         	730                 	2                   	0076484015410       	\N	0	0
ARNES 71.1CM        	770                 	2                   	0076484088841       	\N	0	0
COLL AHOR 31        	260                 	2                   	0076484093029       	\N	0	0
COLL AHOR 35        	290                 	2                   	0076484093111       	\N	0	0
COLL AHOR 46        	310                 	2                   	0076484093135       	\N	0	0
COLL AHOR 41        	330                 	2                   	0076484093210       	\N	0	0
CO AHOR 46 G        	410                 	2                   	0076484093302       	\N	0	0
COLL AHOR 56        	600                 	2                   	0076484093425       	\N	0	0
COLL AHOR 66        	630                 	2                   	0076484093449       	\N	0	0
LEUCEMIA V F        	400                 	4                   	0087219003732       	\N	0	0
ANF PU28 1,5        	360                 	1                   	0090972310184       	\N	0	0
ANF PU SB 15        	2400                	1                   	0090972314175       	\N	0	0
ANF CH AD 15        	2400                	1                   	0090972314236       	\N	0	0
ANF PU28 15K        	2400                	1                   	0090972314281       	\N	0	0
SCOOP AWAY          	470                 	2                   	0096689000073       	\N	0	0
                    	0                   	0                   	0123456789012       	\N	0	0
PL IN 25 CM         	720                 	2                   	0400480320771       	\N	0	0
JU PEL PET          	200                 	2                   	0645940614209       	\N	0	0
CO PAT2,5X50        	200                 	2                   	0645942334105       	\N	0	0
COLL VER NEO        	130                 	2                   	0645942356107       	\N	0	0
COL REF 2X55        	90                  	2                   	0645942374200       	\N	0	0
COL GA CORBA        	180                 	2                   	0645942393102       	\N	0	0
TRAI 1x120          	180                 	2                   	0645942429108       	\N	0	0
PEIN PLAS FI        	230                 	2                   	0645942884105       	\N	0	0
PEIN SIMPLE         	180                 	2                   	0645942885102       	\N	0	0
JU PELO MOR         	220                 	2                   	0645943306101       	\N	0	0
JUG PELOTA          	180                 	2                   	0645943307108       	\N	0	0
JU COR TRE P        	210                 	2                   	0645943543100       	\N	0	0
JU RUB TOY          	300                 	2                   	0645943560107       	\N	0	0
KITTYSAND38L        	490                 	2                   	0692358954557       	\N	0	0
BIL JAC 566         	310                 	1                   	0731794001040       	\N	0	0
BIL JAC 113         	160                 	1                   	0731794005017       	\N	0	0
LITTLE JACS         	160                 	1                   	0731794005024       	\N	0	0
FESTINES BJA        	350                 	1                   	0731794005215       	\N	0	0
TRAI NAU 73C        	280                 	2                   	0789111201390       	\N	0	0
HUESO BL 9          	360                 	2                   	1000000000009       	\N	0	0
CAMA 1048 G         	1650                	2                   	2345670104817       	\N	0	0
CAMA 1048 M         	1400                	2                   	2345670104824       	\N	0	0
SYXO13C             	450                 	2                   	2345672800120       	\N	0	0
SH534TA             	750                 	2                   	2345678905348       	\N	0	0
AR TI2097SH2        	550                 	2                   	2345678920976       	\N	0	0
SH 3113             	180                 	2                   	2345678931132       	\N	0	0
SH3196B             	180                 	2                   	2345678931965       	\N	0	0
TI SH 3257          	300                 	2                   	2345678932573       	\N	0	0
TRA SH3259          	450                 	2                   	2345678932597       	\N	0	0
SH3328              	180                 	2                   	2345678933280       	\N	0	0
TRA AUTO MD         	1500                	2                   	4000498005118       	\N	0	0
CLICKER             	320                 	2                   	4018653835425       	\N	0	0
KIT DENTAL          	490                 	2                   	5703188034243       	\N	0	0
BUSTER 7.5CM        	250                 	2                   	5703188040183       	\N	0	0
BUSTER 22CM         	450                 	2                   	5703188233011       	\N	0	0
BUSTER 25CM         	660                 	2                   	5703188233035       	\N	0	0
TRAI RE 3mm         	260                 	2                   	6900015401301       	\N	0	0
TRAI REF 4mm        	280                 	2                   	6900015401400       	\N	0	0
CORR RET DOG        	350                 	2                   	6931598224919       	\N	0	0
EUK/SM              	490                 	0                   	7501007494685       	\N	0	0
EUKA SB AD 3        	920                 	1                   	7501007494692       	\N	0	0
EUK SB 7.5 K        	1900                	1                   	7501007494708       	\N	0	0
EU LB AD 20K        	3600                	1                   	7501007494838       	\N	0	0
EU SB PU 1,5        	470                 	1                   	7501007494869       	\N	0	0
EU SB PU 3KG        	995                 	1                   	7501007494876       	\N	0	0
EU PU SB 7.5        	2070                	1                   	7501007494883       	\N	0	0
PERFOR 3K           	990                 	1                   	7501007498492       	\N	0	0
EUK/LIGHT3          	930                 	1                   	7501007498522       	\N	0	0
EUK/SECH            	930                 	0                   	7501007498546       	\N	0	0
DEXORYL OTIC        	1030                	3                   	7502010420326       	\N	0	0
HUESO 3 4           	50                  	2                   	7701180203016       	\N	0	0
HUESO 4-5           	70                  	2                   	7701180204013       	\N	0	0
HUESO 6-7           	150                 	2                   	7701180206017       	\N	0	0
HUESO 10-11         	280                 	2                   	7701180210014       	\N	0	0
HUESO 11-12         	300                 	2                   	7701180211011       	\N	0	0
HUESO 12-13         	350                 	2                   	7701180212018       	\N	0	0
HUESO 13 14         	400                 	2                   	7701180213015       	\N	0	0
MAMADERA            	180                 	2                   	7707297411528       	\N	0	0
DISPERT DEX         	0                   	3                   	7730407021911       	\N	0	0
DISPERSONA          	280                 	3                   	7730407022611       	\N	0	0
ACETIDRONA          	7                   	3                   	7730407023717       	\N	0	0
HISTOCREM           	520                 	3                   	7730407024219       	\N	0	0
SANIUM G            	90                  	3                   	7730407025612       	\N	0	0
RO FIT 32           	890                 	1                   	7790187108417       	\N	0	0
RC PERSA 2KG        	990                 	1                   	7790187108462       	\N	0	0
RC SIA 38 2K        	990                 	1                   	7790187108486       	\N	0	0
RC BABYC 0,4        	290                 	1                   	7790187108509       	\N	0	0
BABY CAT 34         	990                 	1                   	7790187108516       	\N	0	0
RC KIT34 2KG        	890                 	1                   	7790187108530       	\N	0	0
RO INDOOR 27        	890                 	1                   	7790187108554       	\N	0	0
INDOOR 27 75        	2450                	1                   	7790187108561       	\N	0	0
RO MATURE 27        	890                 	1                   	7790187108608       	\N	0	0
ACTI MAT 28         	890                 	1                   	7790187108653       	\N	0	0
RC MI JU 1KG        	490                 	1                   	7790187108844       	\N	0	0
RC MI JU 3KG        	1090                	1                   	7790187108851       	\N	0	0
RC MI AD 1KG        	490                 	1                   	7790187108868       	\N	0	0
RC MI AD 3KG        	980                 	1                   	7790187108875       	\N	0	0
RC MI LIG 3K        	1090                	1                   	7790187108905       	\N	0	0
RC MI MA 1KG        	360                 	1                   	7790187108912       	\N	0	0
RO MI MA 3KG        	1090                	1                   	7790187108929       	\N	0	0
RC DACHS 1 K        	590                 	1                   	7790187108936       	\N	0	0
RC YORK AD 3        	1250                	1                   	7790187109025       	\N	0	0
RC PO AD 1KG        	490                 	1                   	7790187109032       	\N	0	0
RC POODLE 3K        	1250                	1                   	7790187109049       	\N	0	0
RC OBES 0,5         	390                 	1                   	7790187109179       	\N	0	0
HYPO CA             	1150                	1                   	7790187109186       	\N	0	0
RC WEITH 1.5        	960                 	1                   	7790187109216       	\N	0	0
EARLY CARDIA        	1050                	1                   	7790187109292       	\N	0	0
INTES G 32          	1090                	1                   	7790187109339       	\N	0	0
URI SO  400G        	390                 	1                   	7790187109407       	\N	0	0
RC URI S/O 2        	1090                	1                   	7790187109414       	\N	0	0
RC MA JU 32         	3100                	1                   	7790187110533       	\N	0	0
RC MA AD26          	2790                	1                   	7790187110557       	\N	0	0
YORK283K            	1390                	1                   	7790187110687       	\N	0	0
RC YORKS 1KG        	590                 	1                   	7790187110694       	\N	0	0
POODLE 30 U3        	1390                	1                   	7790187110700       	\N	0	0
RC POOD 1 KG        	590                 	1                   	7790187110717       	\N	0	0
RC SCH MI 1K        	590                 	1                   	7790187110731       	\N	0	0
RC DACHS 3KG        	1390                	1                   	7790187110748       	\N	0	0
ES SEC SP EH        	280                 	3                   	7792816002059       	\N	0	0
PROF PI 0,35        	280                 	3                   	7793640808121       	\N	0	0
HUESO 34            	85                  	2                   	7796777006408       	\N	0	0
HUESO 56            	150                 	2                   	7796777006576       	\N	0	0
ENROXINA 50         	450                 	3                   	7797600000242       	\N	0	0
PROTELIV            	300                 	3                   	7798042361779       	\N	0	0
APETIL              	420                 	3                   	7798042361830       	\N	0	0
VITAL 1.5 JU        	280                 	1                   	7798098840242       	\N	0	0
VITAL 1.5 AD        	240                 	1                   	7798098840525       	\N	0	0
DECTOMAX            	1750                	3                   	7800001000176       	\N	0	0
PET CAL             	1240                	3                   	7800001003276       	\N	0	0
RIMADYL             	970                 	3                   	7800001003313       	\N	0	0
RIMADYL             	2570                	3                   	7800001003696       	\N	0	0
                    	0                   	0                   	7800001003818       	\N	0	0
RABGUARD            	500                 	4                   	7800001003825       	\N	0	0
PARVOVIRUS          	200                 	4                   	7800001950006       	\N	0	0
FELOCELL            	350                 	4                   	7800001950037       	\N	0	0
PARVO-CORONA        	200                 	4                   	7800001950051       	\N	0	0
OCTUPLE             	300                 	4                   	7800001950082       	\N	0	0
LEUKOCELL           	400                 	4                   	7800001950181       	\N	0	0
CALCIDOG            	525                 	3                   	7800006000010       	\N	0	0
CATTI COLLAR        	130                 	3                   	7800006000041       	\N	0	0
DOGUICAN COL        	130                 	3                   	7800006000058       	\N	0	0
DOGUI.ADULTO        	340                 	3                   	7800006000119       	\N	0	0
JUVECAN 250         	580                 	3                   	7800006000126       	\N	0	0
SIN POL PERR        	100                 	3                   	7800006000164       	\N	0	0
SUPER PET           	380                 	3                   	7800006000171       	\N	0	0
SH SECO TIDY        	200                 	3                   	7800006000188       	\N	0	0
HEPROTEC            	400                 	3                   	7800006000232       	\N	0	0
INVER GOT           	140                 	3                   	7800006000249       	\N	0	0
SINPULKILL          	120                 	3                   	7800006000263       	\N	0	0
OVO 6               	360                 	3                   	7800006000287       	\N	0	0
PACIFOR GOTA        	350                 	3                   	7800006000294       	\N	0	0
RESPIG              	490                 	3                   	7800006000324       	\N	0	0
SHA DZEL 100        	140                 	3                   	7800006000485       	\N	0	0
SINPU SP 500        	580                 	3                   	7800006000508       	\N	0	0
SH MED FLT          	575                 	3                   	7800006000546       	\N	0	0
HASYUN              	400                 	3                   	7800006000553       	\N	0	0
TRANSIMED           	510                 	3                   	7800006000577       	\N	0	0
NONPET 20 MG        	590                 	3                   	7800006000607       	\N	0	0
SINPUL 30 SO        	80                  	3                   	7800006000614       	\N	0	0
DEPODRAG 5          	450                 	3                   	7800006000652       	\N	0	0
DEPODRAG 20         	1300                	3                   	7800006000669       	\N	0	0
INVEADE GOTA        	260                 	3                   	7800006000683       	\N	0	0
PACIFOR COMP        	520                 	3                   	7800006000720       	\N	0	0
DIARREPAS           	460                 	3                   	7800006000737       	\N	0	0
DRAGOVIN            	480                 	3                   	7800006001260       	\N	0	0
PETEVER FORT        	500                 	3                   	7800006001291       	\N	0	0
SH ALERDRAG         	530                 	3                   	7800006001321       	\N	0	0
ULTRAFIL            	650                 	3                   	7800006001512       	\N	0	0
SHA DZEL 300        	280                 	3                   	7800006002069       	\N	0	0
NONPET 5 MG         	290                 	3                   	7800006002199       	\N	0	0
ROSTRUM 50          	390                 	3                   	7800006002397       	\N	0	0
NAXPET 10 MG        	390                 	3                   	7800006002410       	\N	0	0
LAX DRAG            	320                 	3                   	7800006002564       	\N	0	0
CALVIPET            	300                 	3                   	7800006002595       	\N	0	0
ULTIL 200 SP        	320                 	3                   	7800006002618       	\N	0	0
ROSTRUM 150         	1050                	3                   	7800006002700       	\N	0	0
APETIPET            	500                 	3                   	7800006002724       	\N	0	0
FLOVOV 10 KG        	90                  	3                   	7800006002779       	\N	0	0
MEBERMIC            	90                  	2                   	7800006002854       	\N	0	0
INVERMIC GAT        	140                 	3                   	7800006002861       	\N	0	0
APETICAT            	500                 	3                   	7800006002908       	\N	0	0
SINP POL GAT        	220                 	3                   	7800006002953       	\N	0	0
PICHICHI            	140                 	3                   	7800006002960       	\N	0	0
NISCLER R GR        	270                 	3                   	7800006002977       	\N	0	0
VITADRAG            	340                 	3                   	7800006003028       	\N	0	0
DRAGOXIL 220        	460                 	3                   	7800006003141       	\N	0	0
DOXIMICIN           	480                 	3                   	7800006003158       	\N	0	0
DRAGXICILINA        	190                 	3                   	7800006003189       	\N	0	0
FLOVOV 35 KG        	260                 	3                   	7800006003349       	\N	0	0
NAXPET 30 MG        	540                 	3                   	7800006003370       	\N	0	0
MIXANTIP PLU        	420                 	3                   	7800006003455       	\N	0	0
MAMISTOP 125        	290                 	3                   	7800006003561       	\N	0	0
MAMISTOP 250        	480                 	3                   	7800006003622       	\N	0	0
ROSTRUM OTIC        	480                 	3                   	7800006003646       	\N	0	0
LAGRIPET            	350                 	3                   	7800006003653       	\N	0	0
SIR DOG WHIT        	390                 	3                   	7800006003684       	\N	0	0
SIR DOG BLAC        	390                 	3                   	7800006003691       	\N	0	0
SIR DOG BRON        	390                 	3                   	7800006003707       	\N	0	0
LARVIC SP 80        	380                 	3                   	7800006003738       	\N	0	0
PET OTIC            	460                 	3                   	7800006003745       	\N	0	0
DOGUI.CACHOR        	340                 	3                   	7800006003752       	\N	0	0
DOGUI. SENIO        	450                 	3                   	7800006003769       	\N	0	0
DRAGOXIL 660        	670                 	3                   	7800006003820       	\N	0	0
ARTRIOFIN 88        	610                 	3                   	7800006004384       	\N	0	0
MAMISTOPGATO        	250                 	3                   	7800006004421       	\N	0	0
COLLAR SPKIL        	330                 	3                   	7800006004674       	\N	0	0
SUP.OMEGA 6         	290                 	3                   	7800006004933       	\N	0	0
SINPUL RGR          	270                 	3                   	7800006005091       	\N	0	0
SINPUL RPEQ         	170                 	3                   	7800006005107       	\N	0	0
SINP PL 2 ml        	170                 	3                   	7800006005152       	\N	0	0
SH REGEP PLU        	460                 	3                   	7800006005169       	\N	0	0
BIO POWER           	520                 	3                   	7800006005220       	\N	0	0
DERMISOLONA         	550                 	3                   	7800006005268       	\N	0	0
LAGRIPET 50         	480                 	3                   	7800006005350       	\N	0	0
DIPRAMIDA           	360                 	3                   	7800006005572       	\N	0	0
PAZ-PET             	460                 	3                   	7800006005589       	\N	0	0
CONDROVET           	860                 	3                   	7800006005619       	\N	0	0
SUAVIPEL            	380                 	3                   	7800006005749       	\N	0	0
FIPROK 100          	790                 	3                   	7800006005794       	\N	0	0
FIPR 250 SPR        	1310                	3                   	7800006005800       	\N	0	0
CLINDABONE          	1400                	3                   	7800006006364       	\N	0	0
FIT LAT ADUL        	120                 	1                   	7800006006395       	\N	0	0
FIT LATA CAC        	120                 	1                   	7800006006418       	\N	0	0
FIT POLLO AD        	105                 	1                   	7800006006425       	\N	0	0
FIPR PI GATO        	400                 	3                   	7800006006449       	\N	0	0
FIPR PI 10 K        	400                 	3                   	7800006006456       	\N	0	0
FIP PI 10/20        	500                 	3                   	7800006006463       	\N	0	0
FIP PI 20/40        	700                 	3                   	7800006006470       	\N	0	0
FIPRO 40 60         	900                 	3                   	7800006006487       	\N	0	0
MEBERMIC            	90                  	3                   	7800006006524       	\N	0	0
DOXIMICIN JB        	490                 	3                   	7800006006692       	\N	0	0
NAXPET ORAL         	310                 	3                   	7800006006814       	\N	0	0
HERPLEX L           	540                 	3                   	7800006006821       	\N	0	0
PRO IN IN           	240                 	3                   	7800006006869       	\N	0	0
ROSTRUM SUSP        	380                 	3                   	7800006006913       	\N	0	0
GASTROENTERI        	550                 	3                   	7800006006975       	\N	0	0
SIR DOG LADY        	450                 	3                   	7800006006999       	\N	0	0
SIR DOG MUSK        	450                 	3                   	7800006007002       	\N	0	0
BIOTIVET            	220                 	3                   	7800007635419       	\N	0	0
GALGO CAJX25        	2250                	3                   	7800007644404       	\N	0	0
VETAP 20 MG         	450                 	3                   	7800007645210       	\N	0	0
GALGOVET            	90                  	3                   	7800007645487       	\N	0	0
METYCEL EXTR        	790                 	3                   	7800007657220       	\N	0	0
FRENIL 0.67         	560                 	3                   	7800007718709       	\N	0	0
FRENIL 1.34         	630                 	3                   	7800007718891       	\N	0	0
KETOFEN 100         	1700                	2                   	7800066014125       	\N	0	0
STOMORGYL 10        	1280                	3                   	7800066016020       	\N	0	0
KETOFEN 5MG         	620                 	3                   	7800066016105       	\N	0	0
FRONT SP 250        	2050                	3                   	7800066016235       	\N	0	0
FRONT SP 100        	1150                	3                   	7800066016242       	\N	0	0
FRONTL. 0.67        	770                 	3                   	7800066026371       	\N	0	0
FRONT P 1,34        	990                 	3                   	7800066026388       	\N	0	0
FRONT P 2,68        	1350                	3                   	7800066026395       	\N	0	0
FRONT P 4,02        	1600                	3                   	7800066026401       	\N	0	0
FRONT PI 0,5        	660                 	3                   	7800066026418       	\N	0	0
AMOX 250 COM        	650                 	3                   	7800086205954       	\N	0	0
PROTELIV            	370                 	3                   	7800093051681       	\N	0	0
POVISEPT            	55                  	3                   	7801000209768       	\N	0	0
COCA L              	100                 	1                   	7801610001042       	\N	0	0
ALBENDASOL          	90                  	3                   	7804605270003       	\N	0	0
FELIWAY SPRA        	1180                	3                   	7804605270072       	\N	0	0
VETANCID            	540                 	3                   	7804605270188       	\N	0	0
VIGOSINE            	510                 	3                   	7804605270201       	\N	0	0
CIPROVET            	1150                	3                   	7804605270256       	\N	0	0
CREMA 6A            	750                 	3                   	7804605270270       	\N	0	0
ETODOLACO           	590                 	3                   	7804605270522       	\N	0	0
OXTRIM 30 CO        	1200                	3                   	7804605270546       	\N	0	0
POWER SP 100        	550                 	3                   	7804605270553       	\N	0	0
POW FEL PIP         	300                 	3                   	7804605270560       	\N	0	0
PO PE -10KG         	360                 	3                   	7804605270577       	\N	0	0
POWER 11-20         	390                 	3                   	7804605270584       	\N	0	0
POWER 21-40         	410                 	3                   	7804605270591       	\N	0	0
POWER 41-60K        	470                 	3                   	7804605270607       	\N	0	0
GERI 20 COMP        	1250                	3                   	7804605270652       	\N	0	0
GERI 10 COMP        	650                 	3                   	7804605270669       	\N	0	0
LABYES TEARS        	890                 	3                   	7804605270676       	\N	0	0
AMITRAS 12 5        	780                 	3                   	7804605270713       	\N	0	0
NUTRA PEL           	725                 	3                   	7804605270720       	\N	0	0
FIPRO 41 60         	1060                	3                   	7804605270737       	\N	0	0
FIPRO 11 20         	580                 	3                   	7804605270744       	\N	0	0
FIPRO 1 A 10        	450                 	3                   	7804605270768       	\N	0	0
FIPRO 21 40         	780                 	3                   	7804605270775       	\N	0	0
DIAZINON 10         	120                 	3                   	7804610650012       	\N	0	0
CA DOG-JOY          	240                 	3                   	7804610650098       	\N	0	0
POL-V-OTIC          	370                 	3                   	7804610650142       	\N	0	0
LACTOCAN            	520                 	3                   	7804610650173       	\N	0	0
RESISTOL PV         	200                 	3                   	7804610650203       	\N	0	0
SHAMP SEC EX        	200                 	3                   	7804610650210       	\N	0	0
RESIST SPRAY        	380                 	3                   	7804610650258       	\N	0	0
CLORANF SPRA        	420                 	3                   	7804610650265       	\N	0	0
DIAZINON 50         	400                 	3                   	7804610650272       	\N	0	0
JABON AZUFRE        	150                 	3                   	7804610650289       	\N	0	0
COLO DES EXI        	320                 	3                   	7804610650296       	\N	0	0
ESPUM SEC EX        	290                 	3                   	7804610650302       	\N	0	0
SHA LIQ EXI         	160                 	3                   	7804610650319       	\N	0	0
RESISTOL LIQ        	440                 	3                   	7804610650340       	\N	0	0
CONDROPROTEC        	590                 	3                   	7804610650470       	\N	0	0
JABON GLICER        	180                 	3                   	7804613900039       	\N	0	0
HOLLY HUE 2         	70                  	2                   	7804613900121       	\N	0	0
SNACKS              	48                  	2                   	7804613900145       	\N	0	0
CARPROF 20          	330                 	3                   	7804622980183       	\N	0	0
GRISEOF 250         	490                 	3                   	7804622980190       	\N	0	0
FIPRON 100          	700                 	3                   	7804622980374       	\N	0	0
UITO NORMAL         	800                 	3                   	7804628660003       	\N	0	0
VITO JUNIOR         	800                 	3                   	7804628660010       	\N	0	0
VITO SENIOR         	900                 	3                   	7804628660027       	\N	0	0
CO TRIP CUER        	500                 	2                   	7805292000522       	\N	0	0
TRA CORDON S        	230                 	2                   	7805292000539       	\N	0	0
TRA CORDON M        	340                 	2                   	7805292000546       	\N	0	0
TRA CORDO L         	380                 	2                   	7805292000553       	\N	0	0
CO PL 20 MET        	330                 	2                   	7805292002540       	\N	0	0
CO PL 25 MET        	330                 	2                   	7805292002564       	\N	0	0
COLL ADIESTR        	460                 	2                   	7805292090103       	\N	0	0
TRAI AHORQUE        	440                 	2                   	7805292090202       	\N	0	0
TRAI PA GR          	470                 	2                   	7805292090301       	\N	0	0
TRAI PA FINA        	440                 	2                   	7805292090400       	\N	0	0
TRAILLA RETR        	960                 	2                   	7805292090424       	\N	0	0
COL AH L60CM        	230                 	2                   	7805292090509       	\N	0	0
COL AH CH40C        	210                 	2                   	7805292090516       	\N	0	0
CO TRI CORTO        	420                 	2                   	7805292090578       	\N	0	0
COL TRIPL 50        	480                 	2                   	7805292090585       	\N	0	0
CO GR 62 CM         	440                 	2                   	7805292090608       	\N	0	0
CO CH 42 CM         	320                 	2                   	7805292090707       	\N	0	0
CADENA RETEN        	740                 	2                   	7805292090806       	\N	0	0
CAT LITTER          	360                 	2                   	7805292094132       	\N	0	0
PL INO ATRx2        	570                 	2                   	7805292096402       	\N	0	0
CO FR C/A 16        	400                 	2                   	7805292097348       	\N	0	0
CO FR C/A 20        	480                 	2                   	7805292097355       	\N	0	0
CO FRA 25mm         	600                 	2                   	7805292097362       	\N	0	0
JU PF PEL           	420                 	2                   	7805292098376       	\N	0	0
OMEGA PIEL P        	300                 	3                   	7805350000365       	\N	0	0
OMEGA PETS 3        	300                 	3                   	7805350000389       	\N	0	0
PLA PLAST 15        	220                 	2                   	7805614301023       	\N	0	0
ADVANT GATOS        	420                 	3                   	7805750400550       	\N	0	0
DRONTAL GATO        	120                 	3                   	7805750401182       	\N	0	0
DRONTAL 35 K        	440                 	3                   	7805750401281       	\N	0	0
DRONT 10 PER        	170                 	3                   	7805750401328       	\N	0	0
FIT ADUL 20K        	1400                	1                   	7808750700880       	\N	0	0
SHAM MAS ACO        	270                 	3                   	7809573600036       	\N	0	0
SHAM MAS HIP        	270                 	3                   	7809573600043       	\N	0	0
DIMODROL            	360                 	3                   	7809573609961       	\N	0	0
TR CORD 70          	280                 	2                   	7891112013919       	\N	0	0
TR CORDO 120        	420                 	2                   	7891112013933       	\N	0	0
TR CORD 150         	480                 	2                   	7891112013940       	\N	0	0
TRAILLA CORT        	280                 	2                   	7891112013995       	\N	0	0
CONTRALAC 20        	1060                	3                   	7897515652885       	\N	0	0
RILEXINE 300        	1400                	3                   	7897515652953       	\N	0	0
GRANTELM            	90                  	3                   	7897515653905       	\N	0	0
HUESO 8.5           	200                 	2                   	7898292510139       	\N	0	0
HUESO 55            	180                 	2                   	7898292510719       	\N	0	0
JU  ERIZO           	100                 	2                   	7898292510757       	\N	0	0
HUESO (5UN)         	180                 	2                   	7898292513284       	\N	0	0
CAMA PERLA 1        	1300                	2                   	8006751063112       	\N	0	0
CA PERLA2 45        	1600                	2                   	8006751063211       	\N	0	0
CAMA PERLA 3        	1900                	2                   	8006751063327       	\N	0	0
CAMA PERLA 4        	2100                	2                   	8006751064140       	\N	0	0
COM AUT 3LT         	1250                	2                   	8010690052533       	\N	0	0
CAMA 1048 CH        	950                 	2                   	8528500010487       	\N	0	0
DOG-A-DENT          	890                 	3                   	8711231100736       	\N	0	0
SHAMP BLACK         	470                 	3                   	8711231104789       	\N	0	0
MAMA BEAPH          	600                 	2                   	8711231112449       	\N	0	0
LAVETA CARNI        	540                 	3                   	8711231114283       	\N	0	0
LAVETA TAURI        	620                 	3                   	8711231114306       	\N	0	0
OFTAL               	570                 	3                   	8711231116294       	\N	0	0
REP REPPERS         	890                 	3                   	8711231124824       	\N	0	0
DUO-MALT            	700                 	3                   	8711231129614       	\N	0	0
REP REPP SPR        	700                 	3                   	8711231135127       	\N	0	0
SHAM TE VERD        	580                 	3                   	8711231137206       	\N	0	0
MILKPOWDER          	550                 	3                   	8711231142040       	\N	0	0
SHAM WHITE          	470                 	3                   	8711231184101       	\N	0	0
SHAMPOO GOLD        	470                 	3                   	8711231184125       	\N	0	0
CHOCO DROPS         	350                 	3                   	8711908133005       	\N	0	0
TRIAMTELM           	90                  	3                   	8713184028785       	\N	0	0
RABIA               	500                 	4                   	8713184061126       	\N	0	0
TRICAT              	350                 	4                   	8713184061188       	\N	0	0
PUPPY DP            	350                 	4                   	8713184067661       	\N	0	0
SCALIBOR            	1000                	3                   	8713184084644       	\N	0	0
CI SEG T S          	860                 	2                   	9003687319909       	\N	0	0
CI SE TA M          	960                 	2                   	9003687319961       	\N	0	0
CI SE TA L          	1090                	2                   	9003687319978       	\N	0	0
NICO NICO NI        	1090                	2                   	9003687319979       	\N	0	0
Producto            	3333                	Alimento            	000000001           	Producto de comer	0	0
\.


--
-- TOC entry 1877 (class 0 OID 16809)
-- Dependencies: 1369
-- Data for Name: productovendido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY productovendido (codigo, unidades, precio, fecha) FROM stdin;
\.


--
-- TOC entry 1871 (class 0 OID 16767)
-- Dependencies: 1363
-- Data for Name: raza; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY raza (nombre, especie) FROM stdin;
Poodle                        	Perro               
Mestizo                       	Perro               
Boxer                         	Perro               
Persa                         	Gato                
Mestizo                       	Gato                
Angora                        	Gato                
Montes                        	Gato                
Angora                        	Conejo              
de Feria                      	Caballo             
de Campo                      	Caballo             
del Club Hipico               	Caballo             
\.


--
-- TOC entry 1856 (class 0 OID 16588)
-- Dependencies: 1348
-- Data for Name: servicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servicio (nombre) FROM stdin;
Hotelería           
Peluquería          
Clinica             
Pabellon            
Pet Shop            
\.


--
-- TOC entry 1861 (class 0 OID 16653)
-- Dependencies: 1353
-- Data for Name: serviciopeluq; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY serviciopeluq (nombre) FROM stdin;
Pedicura            
Baño                
Corte               
\.


--
-- TOC entry 1864 (class 0 OID 16681)
-- Dependencies: 1356
-- Data for Name: serviciospeluqueria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY serviciospeluqueria (servicio, nombre, clienterut, mascotanombre, hora, responsable, fecha, nuevafecha, nuevahora, costo, descripcion, estado, motivo) FROM stdin;
corte               	Baño tres           	140517461	zury                                              	14:13:42	cbonati             	2010-01-12	2010-01-12	14:13:42	7000                	asdasd	0	0
corte               	Baño tres           	140517461	zury                                              	14:13:46	cbonati             	2010-01-14	2010-01-14	14:13:46	7000                	qeqweqwe	0	0
corte               	Corte               	140517461	zury                                              	14:13:46	cbonati             	2010-01-14	2010-01-20	14:15:34	4000                		0	0
corte               	Corte               	140517461	zury                                              	14:13:42	cbonati             	2010-01-12	2010-01-19	14:16:21	4000                	Ahora si	0	0
\.


--
-- TOC entry 1838 (class 0 OID 16405)
-- Dependencies: 1330
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar, estado, id) FROM stdin;
Juanito             	Juanito             	Juanito             	juan                	Veterinario         	juan                	petshop             	t	t	t	t	t	1
raul                	lopez               	diaz                	rlo                 	Veterinario         	rlo                 	Nada                	t	t	t	t	t	1
Sebastian           	Arancibia           	Olguin              	sarancibia          	Cajero              	sarancibia          	Hotelería           	t	t	t	t	t	2
claudio             	bonati              	bonati              	cbonati             	Peluquero           	cbonati             	Peluquería          	t	t	t	t	f	1
Camilo              	Verdugo             	Gunther             	cverdugo            	Veterinario         	cverdugo            	Hotelería           	t	t	t	t	t	3
\.


--
-- TOC entry 1857 (class 0 OID 16592)
-- Dependencies: 1349
-- Data for Name: vacuna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY vacuna (nombre, precio, caducidad, descripcion) FROM stdin;
Octuple             	3400	2	Vacunas de prevension
Antirrabica         	9500	2	Prevension de la rabia
\.


--
-- TOC entry 1858 (class 0 OID 16599)
-- Dependencies: 1350
-- Data for Name: vacunacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY vacunacion (vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, estado, fechacaducidad, descripcion, motivo, servicio) FROM stdin;
Octuple                       	162989243	larry                                             	22:14:28	rlo                 	2010-01-21	3400                	0	2010-03-21	Descripcion vacuncion	0	Policlinico
Antirrabica                   	162989243	larry                                             	22:14:28	rlo                 	2010-01-21	9500                	0	2010-03-21	Descripcion vacuncion	0	Policlinico
\.


-- Completed on 2010-01-23 22:18:10

--
-- PostgreSQL database dump complete
--

