# VizsgaRemek
Készült a Codecool Junior Automata Tesztelői kurzuson, záróvizsga részeként. \
Automata tesztek a https://lennertamas.github.io/roxo weboldal különböző funkcióihoz. \
A weboldalt Chrome böngészőben futtattam.

A tesztelt funkciók:
1. Regisztráció
2. Bejelentkezés
3. Adatkezelési nyilatkozat használata
4. Adatok listázása
5. Több oldalas lista bejárása
6. Új adat bevitel
7. Ismételt és sorozatos adatbevitel adatforrásból
8. Meglévő adat módosítás
9. Adat vagy adatok törlése
10. Adatok lementése felületről
11. Kijelentkezés

Programnyelv: JAVA \
Az összefoglaló tesztjelentés (Allure report) linkje: https://ndrew1984.github.io/VizsgaRemek/

A teszteket és azok beállításait a TestRoxo osztályba gyűjtöttem. \
A különböző funkciókat külön-külön osztályokat készítettem. Az oldalra navigáló metódust és a webdriver definicióját egy külön Base osztályba helyeztem, majd a többi osztályt ebből származtattam.\

## 1. Regisztráció
Az oldalra navigálva megjelenik a Terms and Conditions ablak. Ezt elfogadva a regisztráció és bejelentkező ablak kerül elénk. \
A Register fülre kattintva 4 input ező jelenik meg. \
A a TestRoxo osztályban található RegisterTest metódus futtatásával automatikusan megtörténik a regisztráció a megadott tesztadatokkal.

## 2. Bejelentkezés
### 2.1. LoginTest1
Ez a teszt egy korábban létrehozott regisztrációval történik. A regisztráció elvégzése után zárjuk be a böngészőt, majd nyissuk meg újra. \
Ekkor a LoginTest1 futtatásával a korábbi regisztrációs adatokkal hibára fut. Ha bezárjuk a böngészőt, a weboldal "elfelejti" regisztrációt. \
Az Allure reportban ez jelentésre került.
### 2.2. LoginTest2
A korábbi regisztráció után nem zárjuk be a böngészőt, hanem azonnal a Login fülre kattintva, az adatokat beírva belépünk. \
A továbbiakban ezt a metódust használjuk a bejelentkezéshez.

## 3. Adatkezelési nyilatkozat használata
Az oldal megnyitásakor felugró Terms and Condotions ablakon kattintsunk az Accept gombra. \
Ezt a clickAccept() metódus hajtja végre.

## 4. Adatok listázása
A DataListTest() nevű tesztmetódus futtatásával történik meg. \
A list az About gombra kattintva érhető el néhány névjegykártya, melynek adatait (név és titulus) egy HashMap-ba listázza.\
A tesztben a lista méretére vonatkozó Assert lett meghívva, valamint az elvárt eredmény (exp) kiírásra került.

## 5. Több oldalas lista bejárása
A PagingTest() tesztmetódussal egy többoldalas lista került bejárásra, lapozással. A lista méretére vonatkozó Assert lett meghívva.\
Az aktuális eredmény (act) független a lista méretétől. Az lista bővítése esetén az új elemekt hozzászámolja.

## 6. Új adat bevitel
Az InputNewDataTest() tesztmetódus futtatásával a "Get in Touch" feliratra kattintva megjelenő form mezőit kitölti a megadott tesztadatokkal.\
Ezután a "Send Message" gombra kattint, és elküldi az üzenetet. A felugró megerősítő ablakon az OK gombra kattint.

## 7. Ismételt és sorozatos adatbevitel adatforrásból
### 7.1.
A korábban létrehozott registerData.txt és a loginData.txt tartalmazza egy új felhasználó regisztrációs és bejelentkezési adatait.\
A ReadFromFileTest() tesztmetódus ezeknek az adatoknak a kiolvasásával létrehoz egy új regisztrációt és bejelentkezik.
### 7.2.
A Users.txt file tartalmazza több felhasználó regisztrációs adatait.\
A RegUsersTest() tesztmetódus futtatásával létrehozzuk az összes felhasználó regisztrációját, melyet a file-ban megadtunk.\
A file további felhasználókkal való bővítésével az újak regisztrációja is megtörténik.

## 8. Meglévő adat módosítás
A korábban említett "Get in Touch" gombra kattintva megjeleniik a form.\
A RewriteDataTest() tesztmetódus futtatásával a formot feltölti adatokkal, majd közülük néhányat töröl, és újat ír be a helyére.

## 9. Adat vagy adatok törlése
Ld. az előző pont, korábban beírt adat kerül törlésre a RewriteDataTest() metódus futtatásával.

## 10. Adatok lementése felületről
Az About gombra kattintva elérhetőek a névjegykártyák.\
A SaveDataTest() tesztmetódus létrehoz egy .txt file-t, és a névjegykártyákon szereplő neveket és titulusokat egyesével beírja egy táblázat formában.\
A táblázat fejléccel és sorszámozással van ellátva, minden személy adatai új sorba kerülnek. 







