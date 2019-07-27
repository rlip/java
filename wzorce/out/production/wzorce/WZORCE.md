### Praktyki
- konstrukror max 3 elementowy

#Wzorce kreacyjne

### Wzorzec budowniczy
Robimy np. żeby nie robic konstruktorów z wieloma elementami.

Robi się klasę np. HouseBuilder (ctrl+i na konstuktorze i wpisać builder), najlepiej jako statyczną i wewnątrz klasy którą chcemy zrobć.
Tam są wszystkie setery, które zwracają też HouseBuilder, żeby można było je robić jeden za drugim.
Na końcu metoda buid, która już stworzy oryginnalną klasę i ma wszystko w seterze. 
Konstruktor oryginalnej klasy może być prywatny.
```java
    public class House {
        private String address;
        private Integer floorsNumber;
        private House(String address, Integer floorsNumber) { 
            this.address = address;
            this.floorsNumber = floorsNumber;
        }
        public static class HouseBuilder {
            private String address;
            private Integer floorsNumber = 1; //może być coś domyślnego
            public HouseBuilder setAddress(String address) {
                this.address = address;
                return this;
            }
            public HouseBuilder setFloorsNumber(Integer floorsNumber) {
                this.floorsNumber = floorsNumber;
                return this;
            }
            public House build() {
                return new House(address, floorsNumber);
            }
        }
    }
```
### Statyczna metoda wytwórcza
Pozwala utworzyć obiekt za pomocą innego obiektu np. Boolean.valueOf(), Obiekt z jsona, albo jakieś dom z innego domu.
Metody: from (na podstawie), of (z, np. json, xml), valueOf (jest wartością), instanceOf
```java
    FamilyHouse familyHouse = FamilyHouse.from(myHouse);
    
    // i w klasie:

    public static FamilyHouse from(House myHouse) {
        return new FamilyHouse(myHouse.getAddress(), myHouse.getFloorsNumber());
    }
```    
### Singleton
Jeden obiekt na 1 program, intensywnie używany w większości klas np. log, stan autentyfikacji, cache, repozytorim,
 coś do śledzenia, coś co się nie zmienia bez względu na miejsce użycia. Trzeba uważać żeby był bezpieczny wątkowo.
```java

public class Logger {
    private static Logger instace;

    private Logger() {
    }

    public static Logger getInstace() {
        return SingletonHolder.INSTANCE;
    }

    public void logToConsole(){

    }

    private static class SingletonHolder {
        private static final Logger INSTANCE = new Logger();
    }
}
```
#Wzorce czynnościowe    
Żeby dzielić duże klasy na mniejsze z 1 odpowiedzialnością i nimi zarządzać.
###Obserwator
Jest obiekt obserwujący i obserwowany. Obserwowany powiadamia obserwujacego(cych) o zmianach. Np. obsługa interfejsu użytkownika (jakaś kacja na kliknieciu),
 reakcja na coś (np. zmiany repozutorium), obsługa zmiany w czujnikach. 
 Klasa Observer jest przestarzała, bo nie moza jej zerializować, nie jest bezpieczna wątkowo, i nie dostarcza zbyt sużo informacji
 You can use PropertyChangeEvent and PropertyChangeListener from java.beans package.
###Strategia
Robimy interfejs(y) np. JobStrategy i jego implementacje np. DoctorJobStrategy. Potem jakiś obiekt bedzie miał zmienną(e) typu tego(tych) interfejsu, 
ustawianą gdzieś z zewnątrz. Następnie obiekt ma metodę, w której jest wykonanie akcji na na tamtej zmiennej. 
Czyli można dynamicznie takie strategie ustawiać obiektowi i je zmieniać w razie potrzeby. 
    
    public interface JobStrategy {
        void doYourJob();
    }
    public class DoctorJobStrategy implements JobStrategy {
        @Override
        public void doYourJob() {
            System.out.println("Work as doctor");
        }
    }
    public class Employee implements TravelStrategy, JobStrategy {
        public JobStrategy jobStrategy;
    
        @Override
        public void doYourJob() {
            jobStrategy.doYourJob();
        }
    }
    public static void main(String[] args) {
        Employee mike = new Employee();
        mike.jobStrategy = new DoctorJobStrategy();
        mike.doYourJob();
    }


#Wzorce strukturalne
Wzorce modelujące zwięzki pomiędzy klasami, żeby były lużno powiązane. Łączenie, integracja różnych klas.
###Adapter
Rozszerza funkcjonalność na podstawie innego obiektu. Obiektu starego nie zmieniamy, a nowy dopowujemy do nowych wymagań.
Można np. połączyć nim różne api, ale raczej unikać żeby nie było za dużego zamieszania.

Robi się nową klasę, która albo rozszeża poprzednią albo ma jako pole tą poprzednią i na niej wywołuje się stare lub noowe fuknkcjonalności
```java
OffitialTrippingEmployee ofMike = new OffitialTrippingEmployee(mike); //rozszerzeamy fukcjonalność mika nie zmieniająć jego klasy
ofMike.goToClient();
-------------------
    public void goToClient() {
        employee.travelToWork(employee);
        System.out.println("Travel to Klient"); // i tu coś nowego
    }
```
###dekorator
Dekorujemy obiekt dodając mu coś nowego. Robi się to tak, że tworzy się taki łańcuch opakowywując klasę inną klasą, a to mozna dalej opakowywać.
```java
new FreqBonus(new DeadLinieBonus(new SpecialBonus(mike))).getSalary()
``` 
Każda klasa opakowywyjąca dziedziczy po klasie abstrakcyjnej. W której jest zmienna, która bedzie zawierać to co do tej pory
 się nazabierało i konstruktor wpisujący to w tą zmienną.
```java
public abstract class Bonus implements Payable{
    private Payable payable;

    Bonus(Payable payable){
        this.payable = payable;
    }
    public int getSalary() {
        return payable.getSalary() + getPaidBonus(payable.getSalary());
    }
    abstract protected int getPaidBonus(int salary);
}
-----------------------------------------
public class SpecialBonus extends Bonus {
    public SpecialBonus(Payable payable) {
        super(payable);
    }

    @Override
    protected int getPaidBonus(int salary) {
        return 1000;
    }
}
``` 
###Fasada
Upraszcza metody które wystawiane dalej, żeby były prostrze, idiotoodporne i żeby nikt nie integrował w wewnętrzny system.
 Można robić kilka poziomów. Dobrze urzymywać ten sam pozoiom w fasadach.
```java
public class ApiFacade {
    private EmployeeCreator employeeCreator = new EmployeeCreator(); //to taka fabryka
    private EmployeeDatabase eDataBase = new EmployeeDatabase(); 
    
    public Employee createDoctor(int i) {
       Employee mike = employeeCreator.create(EmployeeCreator.JAKAS_STALA);
       eDatabase.addEmployee(mike);
       return mike;
    }
    public int countSalary(Employee mike){
        //a tu coś jeszcze innego
    }
}
```