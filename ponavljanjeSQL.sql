create database mat;
use mat;
create table t (id int primary key auto_increment, ime varchar(100) not null, telst varchar(20) default null);
insert into t (ime, telst) values ('abc', '123426453265'),('cde', '4554342234');
select * from t;

create table b (sifra int auto_increment, id int not null, tip char(15), reg char(20), primary key (sifra), foreign key (id) references t(id));

alter table b add column znamka char(20) not null after id;
desc b;
desc t;

alter table t modify column telst varchar(34);
alter table t add column test int;
alter table t drop column test;
select distinct ime from t;

create index i on t(ime);
drop index i on t;


/*########### primeri na bazi za maturo ###########*/
show tables;
select * from uporabniki;
select * from stranke_in_zaposleni;
select * from narocila;
select * from izdelki_pri_narocilu;

select count(*), uporabniki.uporabnisko_ime 
from uporabniki, narocila, stranke_in_zaposleni
where uporabniki.uporabnisko_ime = stranke_in_zaposleni.uporabnisko_ime and stranke_in_zaposleni.ID = narocila.ID_stranke
group by uporabniki.uporabnisko_ime;

select narocila.datum, stranke_in_zaposleni.ime
from narocila, stranke_in_zaposleni
where narocila.ID_stranke = stranke_in_zaposleni.ID
group by narocila.datum,stranke_in_zaposleni.ime
having count(stranke_in_zaposleni.ID) > 0
order by narocila.datum desc;

select format(narocila.datum, 'YYYY,DD,MM') from narocila;
select distinct narocila.datum from narocila where narocila.datum between '2023-04-22' and '2023-04-25';
select narocila.imeStranke, narocila.postnina + 1 as pp1 from narocila group by narocila.postnina, narocila.imeStranke;

select stranke_in_zaposleni.ID, stranke_in_zaposleni.ime, narocila.ID_narocila, narocila.naslovDostave, sum(izdelki_pri_narocilu.cena) as 'skupna cena narocila'
from stranke_in_zaposleni, narocila, izdelki_pri_narocilu
where stranke_in_zaposleni.ID = narocila.ID_stranke and narocila.ID_narocila = izdelki_pri_narocilu.ID_narocila
group by stranke_in_zaposleni.ID, narocila.ID_narocila
having sum(izdelki_pri_narocilu.cena) > 500
order by stranke_in_zaposleni.ID asc;

select stranke_in_zaposleni.ID, stranke_in_zaposleni.ime, avg(izdelki_pri_narocilu.cena)
from stranke_in_zaposleni, izdelki_pri_narocilu, narocila
where stranke_in_zaposleni.ID = narocila.ID_stranke and narocila.ID_narocila = izdelki_pri_narocilu.ID_narocila
group by stranke_in_zaposleni.ID
order by avg(izdelki_pri_narocilu.cena) desc, stranke_in_zaposleni.ime asc;

select izdelki.ID_izdelka, izdelki.ime, izdelki.cena_za_kos, count(izdelki_pri_narocilu.ID_izdelka)
from izdelki, izdelki_pri_narocilu
where izdelki.ID_izdelka = izdelki_pri_narocilu.ID_izdelka /*and izdelki.kategorija in ('televizorji', 'mobilni telefoni', 'monitorji')*/
group by izdelki.ime
having count(izdelki_pri_narocilu.ID_izdelka) > 0
order by izdelki_pri_narocilu.ID_izdelka asc, izdelki.ime desc; 

update izdelki set popust = 15 where izdelki.ID_izdelka in 
(select izdelki_pri_narocilu.ID_izdelka from izdelki_pri_narocilu group by izdelki_pri_narocilu.ID_izdelka having count(izdelki_pri_narocilu.ID_izdelka) = 0);

create table arhivRacunov (select * from racuni where racuni.datumIzdaje > '2022-10-10');
select * from arhivRacunov;

select * from izdelki where izdelki.ime like 'a%' or izdelki.ime like 's_m%';

select izdelki.ime from izdelki order by rand() limit 5;

select stranke_in_zaposleni.ime, izdelki.ime, narocila.ID_narocila
from stranke_in_zaposleni, narocila, izdelki
where exists (select 1 from izdelki_pri_narocilu, izdelki where izdelki.ID_izdelka = izdelki_pri_narocilu.ID_izdelka) and stranke_in_zaposleni.ID = narocila.ID_stranke
group by stranke_in_zaposleni.ime, izdelki.ime;


/*########### primeri ric ###########*/
select oseba.davcnaSt, oseba.Ime, oseba.Priimek
from oseba, racun
where oseba.davcnaSt = racun.davcnaSt
group by oseba.davcnaSt
having sum(racun.stanje) > 10000;
update racun set stanje = stanje + 20
where racun.BID = 300 and racun.opomba = 'kredit';

select dijak.Priimek, dijak.Ime
from dijak, tekmovanje, rezultat
where dijak.zapSt = rezultat.zapSt and dijak.solaID = rezultat.solaID and tekmovanje.TID = rezultat.TID
and tekmovanje.imeTekmovanja = 'Bralna znacka 2018' and rezultat.mesto = 1
order by dijak.priimek;
select tekmovanje.imeTekmovanja, sola.imeSole, count(dijak.zapSt) as sTekmovalcev
from sola, dijak, tekmovanje, rezultat
where sola.SOD = dijak.SolaID and dijak.zapSt = rezultat.zapSt and dijak.solaID = rezultat.solaID and tekmovanje.TID = rezultat.TID
group by tekmovanje.imeTekmovanja, sola.imeSole;

create table Naloga (NID int primary key, besedilo char(30) not null);
create table Opomba (NID int not null, st int primary key not null, besedilo char(50) not null,
					foreign key (NID) references Naloga(NID));
select * from prijatelji, interes, hobi
where prijatelji.id = interes.id and interes.id_hobija = hobi.id_hobija
and hobi.ime_hobija = 'lokostrelstvo';
select hobi.ime_hobija, count(interes.id)
from hobi, interes
where interes.id_hobija = hobi.id_hobija
group by hobi.ime_hobija;

select count(tekmovalec.TID)
from tekmovalec, skok
where tekmovalec.TID = skok.TID and skok.serija = 1
group by tekmovalec.TID
having skok.dolzina > 100;
select tekmovalec.TID, tekmovalec.Priimek, sum(skok.dolzina)
from tekmovalec, skok
where tekmovalec.TID = skok.TID
group by tekmovalec.TID
order by sum(skok.dolzina) desc;

select distinct kupec.naziv
from kupec, nakup
where kupec.IDkupca = nakup.IDkupca and nakup.IDizdelka = 2;
select sum(izdelek.cena)
from izdelek, nakup
where izdelek.IDizdelka = nakup.IDizdelka and nakup.datumNakupa = '2013-12-24';

select oseba.Priimek, oseba.Ime
from oseba where oseba.kraj = 'Ljubljana';
select knjiga.ime_knjige
from knjiga, jePrebrala, oseba
where knjiga.ISBN = jePrebrala.ISBN and oseba.EMSO = jePrebrala.EMSO and oseba.ime = 'Milena' and oseba.priimek = 'Jost'
order by kngiga.ime asc;









