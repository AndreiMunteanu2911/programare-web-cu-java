# Programare Web cu Java – Laboratorul 1

## Spring Core – Beans & Dependency Injection

Acest repository conține exercițiile practice pentru primul laborator de Programare Web cu Java.

**Obiectivele laboratorului:**
- Înțelegerea conceptelor de Inversion of Control (IoC) și Dependency Injection (DI).
- Definirea și utilizarea bean-urilor Spring.
- Utilizarea `ApplicationContext` pentru recuperarea bean-urilor.
- Înregistrarea componentelor prin `@Bean` și `@Component`.
- Injectarea dependențelor prin constructor.
- Rezolvarea ambiguităților folosind `@Primary` și `@Qualifier`.

## Cerințe

- Java JDK 21
- IntelliJ IDEA
- Maven (integrat în IntelliJ IDEA)
- Spring Context (gestionat prin Maven)

## Pornirea proiectului

1. Clonați repository-ul:

   `git clone https://github.com/tbogdang99/programare-web-cu-java.git`

2. Deschideți proiectul în IntelliJ IDEA.
3. Selectați JDK 21 dacă IntelliJ solicită configurarea SDK-ului.
4. Așteptați încărcarea dependențelor Maven din `pom.xml`.
5. Deschideți clasa `Main.java` din exercițiul dorit și rulați metoda `main()`.

Fiecare exercițiu are propriul punct de pornire.

## Exercițiul 1 – Dependency Injection fără Spring

**Scop:** eliminarea dependenței directe dintre un serviciu și implementarea concretă pe care o utilizează.

**Cerințe:**
1. Identificați problema din `NotificationService`, unde `EmailNotificationSender` este instanțiat direct.
2. Refactorizați clasa pentru a primi un `NotificationSender` prin constructor.
3. Modificați `Main` pentru a crea și injecta dependența.
4. Implementați `SmsNotificationSender`.
5. Verificați că puteți schimba implementarea Email cu SMS fără modificarea clasei `NotificationService`.

## Exercițiul 2 – Spring Beans

**Scop:** definirea și recuperarea bean-urilor din Spring ApplicationContext.

**Cerințe:**
1. Definiți un bean de tip `BankAccount` în `AppConfig`, folosind `@Bean`.
2. Recuperați bean-ul în `Main`, folosind `getBean()`.
3. Definiți un al doilea bean de același tip.
4. Observați ce se întâmplă când solicitați un bean doar după tip.
5. Recuperați un bean după nume.
6. Folosiți `@Primary` pentru a stabili bean-ul preferat.

## Exercițiul 3 – Component Scanning

**Scop:** înregistrarea automată a componentelor Spring.

**Cerințe:**
1. Adnotați clasa `GreetingService` cu `@Component`.
2. Activați `@ComponentScan` în `AppConfig`.
3. Recuperați `GreetingService` din Spring Context.
4. Apelați metoda `greet("students")`.
5. Dezactivați temporar component scanning și observați comportamentul aplicației.

## Exercițiul 4 – Dependency Injection cu Spring

**Scop:** gestionarea și injectarea automată a dependențelor folosind Spring.

**Cerințe:**
1. Înregistrați `EmailNotificationSender` și `SmsNotificationSender` drept componente Spring.
2. Adnotați `NotificationService` cu `@Service`.
3. Configurați `@ComponentScan`.
4. Recuperați `NotificationService` din Spring Context.
5. Observați problema existenței a două implementări pentru `NotificationSender`.
6. Rezolvați ambiguitatea folosind `@Qualifier`.
7. Experimentați și cu `@Primary`.

## Observații

- Exercițiile conțin comentarii `TODO` care trebuie completate în timpul laboratorului.
- Nu este necesară o bază de date sau un server web.
- Pentru fiecare exercițiu se rulează clasa `Main` corespunzătoare.